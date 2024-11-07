package iuh.fit.se.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import iuh.fit.se.models.dtos.ProductDTO;
import iuh.fit.se.models.entities.Product;
import iuh.fit.se.models.repositiory.DiscountRepository;
import iuh.fit.se.models.repositiory.ProductRepository;
import iuh.fit.se.models.services.DiscountService;
import iuh.fit.se.models.services.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private DiscountService discountService;
	
	@Override
	public List<ProductDTO> findAll() {
		// TODO Auto-generated method stub
		List<ProductDTO> productDTOs = new ArrayList<>();
		productRepository.findAll().forEach(product -> {
			productDTOs.add(new ProductDTO(product, discountService.calculateDiscountedPrice(product)));
		});
		return productDTOs;}

	@Override
	public ProductDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ProductDTO> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO update(int id, ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
