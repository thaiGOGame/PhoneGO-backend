package iuh.fit.se.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.fit.se.models.dtos.ProductDTO;
import iuh.fit.se.models.services.ProductService;

import java.util.LinkedHashMap;
import java.util.Map;

@RepositoryRestController
public class ProductController {
	@Autowired
	private ProductService productService;
	//http://localhost:5000/api/products
	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> getProducts(@RequestParam(required = false) String searchTerm) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("status", HttpStatus.OK.value());
		if (searchTerm == null || searchTerm.isEmpty()) {
			response.put("data", productService.findAll());
		}
		else {
			response.put("data",productService.findAll());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	//http://localhost:5000/api/products/page?pageNo=1&size=2&sortBy=name&sortDirection=asc
	@GetMapping("/products/page")
	public ResponseEntity<Map<String, Object>> getList(
		   @RequestParam(defaultValue = "0", required = false) int pageNo,
		    @RequestParam(defaultValue = "20", required = false) int size,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "ASC", required = false) String sortDirection) {
		Page<ProductDTO> products = productService.findAllWithPaging(pageNo, size, sortBy, sortDirection);
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("data", products);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
