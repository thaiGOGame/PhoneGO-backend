package iuh.fit.se.models.services;

import java.util.List;

import org.springframework.data.domain.Page;

import iuh.fit.se.models.entities.Provider;


public interface ProviderService {
	List<Provider> findAll();
	
	//Page<Provider> findAllWithPaging(int pageNo, int pageSize, String sortBy, String sortDirection);

	Provider findById(int id);
	
	List<Provider> search(String searchTerm);
	
	//Page<Provider> searchWithPaging(String searchTerm, int pageNo, int pageSize, String sortBy, String sortDirection);
	
	Provider save(Provider provider);

	Provider update(int id, Provider provider);
	
	boolean delete(int id);
}
