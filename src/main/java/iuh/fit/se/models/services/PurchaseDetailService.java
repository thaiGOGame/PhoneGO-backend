package iuh.fit.se.models.services;

import java.util.List;

import iuh.fit.se.models.entities.PurchaseDetail;

public interface PurchaseDetailService {
	List<PurchaseDetail> findAll();
	
	PurchaseDetail findById(int id);
	
	List<PurchaseDetail> getPurchaseDetailByProductIdAndProviderId(int productId, int providerId);

	PurchaseDetail save(PurchaseDetail newDetail);

	PurchaseDetail update(int id, PurchaseDetail updatedDetail);

	boolean delete(int id);


	

}
