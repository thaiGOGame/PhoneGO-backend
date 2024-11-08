package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.models.dtos.ProductDTO;
import iuh.fit.se.models.entities.Product;
import iuh.fit.se.models.entities.PurchaseDetail;
import iuh.fit.se.models.repositiory.PurchaseDetailRepository;
import iuh.fit.se.models.services.ProductService;
import iuh.fit.se.models.services.PurchaseDetailService;
import org.modelmapper.ModelMapper;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

	@Autowired
	private PurchaseDetailRepository purchaseDetailRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ModelMapper modelMapper;

	// Convert Product to ProductDTO
	private ProductDTO convertToDTO(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}

	// Convert ProductDTO to Product
	private Product convertToEntity(ProductDTO productDTO) {
		return modelMapper.map(productDTO, Product.class);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PurchaseDetail> findAll() {
		return purchaseDetailRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public PurchaseDetail findById(int id) {
		return purchaseDetailRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("PurchaseDetail id = " + id + " is not found"));
	}

	@Transactional(readOnly = true)
	@Override
	public List<PurchaseDetail> getPurchaseDetailByProductIdAndProviderId(int productId, int providerId) {
		return purchaseDetailRepository.findByProductIdAndProviderId(productId, providerId);
	}

	@Transactional
	@Override
	public PurchaseDetail save(PurchaseDetail newDetail) {
		// Save the purchase detail
		PurchaseDetail savedDetail = purchaseDetailRepository.save(newDetail);

		// Update the associated product
		Product product = productService.findProductById(newDetail.getProduct().getId());
		if (product != null) {
			product.setQuantity(product.getQuantity() + newDetail.getQuantity());
			product.setPurchasePrice(newDetail.getPurchasePrice());
			product.setSalePrice(newDetail.getSalePrice());
			productService.save(convertToDTO(product)); // Save updated product using ProductDTO
		}

		return savedDetail;
	}

	@Transactional
	@Override
	public PurchaseDetail update(int id, PurchaseDetail updatedDetail) {
		PurchaseDetail existingDetail = findById(id);

		Product product = productService.findProductById(existingDetail.getProduct().getId());

		// Adjust quantity by removing the old amount and adding the new one
		product.setQuantity(product.getQuantity() - existingDetail.getQuantity() + updatedDetail.getQuantity());
		product.setPurchasePrice(updatedDetail.getPurchasePrice());
		product.setSalePrice(updatedDetail.getSalePrice());

		if (product.getQuantity() < 0) {
			product.setQuantity(0);
		}

		productService.save(convertToDTO(product)); // Save updated product using ProductDTO

		// Update the PurchaseDetail itself
		existingDetail.setQuantity(updatedDetail.getQuantity());
		existingDetail.setPurchasePrice(updatedDetail.getPurchasePrice());
		existingDetail.setSalePrice(updatedDetail.getSalePrice());

		return purchaseDetailRepository.save(existingDetail);
	}

	@Transactional
	@Override
	public boolean delete(int id) {
		PurchaseDetail existingDetail = findById(id);

		Product product = productService.findProductById(existingDetail.getProduct().getId());

		purchaseDetailRepository.delete(existingDetail);

		product.setQuantity(product.getQuantity() - existingDetail.getQuantity());
		if (product.getQuantity() < 0) {
			product.setQuantity(0);
		}
		productService.save(convertToDTO(product)); // Save the updated product using ProductDTO
		return true;
	}
}
