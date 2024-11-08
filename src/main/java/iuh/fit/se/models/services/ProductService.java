package iuh.fit.se.models.services;

import java.util.List;

import org.springframework.data.domain.Page;

import iuh.fit.se.models.dtos.ProductDTO;
import iuh.fit.se.models.entities.Product;

public interface ProductService {
	List<ProductDTO> findAll();
	
	Page<ProductDTO> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);

	ProductDTO findProductDTOById(int id);
	
	Product findProductById(int id);
	
	List<ProductDTO> search(String searchTerm);
	
	Page<ProductDTO> searchWithPaging(String searchTerm, int pageNo, int pageSize, String sortBy, String sortDirection);
	
	ProductDTO save(ProductDTO productDTO);

	ProductDTO update(int id, ProductDTO productDTO);
	
	Product update(int id, Product product);
	
	boolean delete(int id);

}
