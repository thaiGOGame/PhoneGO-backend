package iuh.fit.se.models.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;
import iuh.fit.se.models.entities.PurchaseDetail;

@RepositoryRestResource(collectionResourceRel = "purchasedetail", path = "purchasedetails")

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail, Integer> {
	@Query("SELECT pd FROM PurchaseDetail pd WHERE pd.product.id = :productId AND pd.provider.id = :providerId")
	List<PurchaseDetail> findByProductIdAndProviderId(@Param("productId") int productId,
			@Param("providerId") int providerId);
}
