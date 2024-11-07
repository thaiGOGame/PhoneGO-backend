package iuh.fit.se.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.models.dtos.ProductDTO;
import iuh.fit.se.models.entities.Product;
import iuh.fit.se.models.repositiory.ProductRepository;
import iuh.fit.se.models.services.DiscountService;
import iuh.fit.se.models.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private DiscountService discountService;

	@Autowired
	ModelMapper modelMapper;

	// write convertToEntity and convertToDTO
	private Product convertToEntity(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		return product;
	}

	private ProductDTO convertToDTO(Product product) {
		ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setDiscountedPrice(discountService.calculateDiscountedPrice(product));
		return productDTO;
	}
	@Transactional(readOnly = true)
	@Override
	public List<ProductDTO> findAll() {
		return productRepository.findAll().stream()
	        .map(this::convertToDTO)
	        .collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Page<ProductDTO> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		return productRepository.findAll(pageable).map(this::convertToDTO);
	}

	@Transactional(readOnly = true)
	@Override
	public ProductDTO findById(int id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Product id = "+id+" is not found"));
		return convertToDTO(product);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<ProductDTO> search(String searchTerm) {
		// TODO Auto-generated method stub
		return productRepository.findProductBySearchTerm(searchTerm).stream()
		          .map(this::convertToDTO)
		          .collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	@Override
	public Page<ProductDTO> searchWithPaging(String searchTerm,int pageNo, int pageSize, String sortBy, String sortDirection) {
		//todo Auto-generated method stub
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();
		
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		return productRepository.findProductBySearchTermWithPagination(searchTerm, sortBy, pageable).map(this::convertToDTO);
	}
	
	@Transactional
	@Override
	public ProductDTO save(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Product product = convertToEntity(productDTO);
		product = productRepository.save(product);
		return convertToDTO(product);
	}

	@Override
	public ProductDTO update(int id, ProductDTO productDTO) {
		// Check id exists or not
		findById(id);

		// Update
		productRepository.save(convertToEntity(productDTO));
		return productDTO;
	}

	@Override
	public boolean delete(int id) {
		this.findById(id);
		productRepository.deleteById(id);
		return true;
	}
}
