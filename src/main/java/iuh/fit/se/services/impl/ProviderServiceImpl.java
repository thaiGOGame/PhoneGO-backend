package iuh.fit.se.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iuh.fit.se.exceptions.ItemNotFoundException;
import iuh.fit.se.models.entities.Product;
import iuh.fit.se.models.entities.Provider;
import iuh.fit.se.models.repositiory.ProviderRepository;
import iuh.fit.se.models.services.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService{
	@Autowired
	private ProviderRepository providerRepository;
	@Transactional(readOnly = true)
	@Override
	public List<Provider> findAll() {
		// TODO Auto-generated method stub
		return providerRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Provider findById(int id) {
		// TODO Auto-generated method stub
		return providerRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Provider id = "+id+" is not found"));
	}
	@Transactional(readOnly = true)
	@Override
	public List<Provider> search(String searchTerm) {
		// TODO Auto-generated method stub
		return providerRepository.findProviderBySearchTerm(searchTerm);
	}

	@Override
	public Provider save(Provider provider) {
		// TODO Auto-generated method stub
		providerRepository.save(provider);
		return provider;
	}

	@Override
	public Provider update(int id, Provider provider) {
		// Check id exists or not
		findById(id);
		
		providerRepository.save(provider);
		return provider;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		findById(id);
		providerRepository.deleteById(id);
		return false;
	}
}
