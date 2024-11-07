package iuh.fit.se.models.services;

import java.util.List;

import org.springframework.data.domain.Page;

import iuh.fit.se.models.dtos.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAll();
	
	Page<ProductDTO> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);

	ProductDTO findById(int id);
	
	List<ProductDTO> search(String searchTerm);
	
	Page<ProductDTO> searchWithPaging(String searchTerm, int pageNo, int pageSize, String sortBy, String sortDirection);
	
	ProductDTO save(ProductDTO productDTO);

	ProductDTO update(int id, ProductDTO productDTO);
	
	boolean delete(int id);
}
