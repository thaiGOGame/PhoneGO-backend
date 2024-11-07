package iuh.fit.se.models.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;

import iuh.fit.se.models.dtos.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAll();
	
	ProductDTO findById(int id);
	
	List<ProductDTO> search(String keyword);
	
	Page<ProductDTO> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);
	
	ProductDTO save(ProductDTO productDTO);

	ProductDTO update(int id, ProductDTO productDTO);
	
	boolean delete(int id);
}
