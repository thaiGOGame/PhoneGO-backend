package iuh.fit.se.models.repositiory;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import iuh.fit.se.models.entities.BrandDiscount;
import iuh.fit.se.models.entities.CategoryDiscount;
import iuh.fit.se.models.entities.Discount;
import iuh.fit.se.models.entities.ProductDiscount;
import iuh.fit.se.models.enums.Brand;
import iuh.fit.se.models.enums.Category;
@RepositoryRestResource(collectionResourceRel = "discounts", path = "discounts")
public interface DiscountRepository extends JpaRepository<Discount, Integer> {
	// In ProductDiscountRepository
	@Query("SELECT pd.discountValue FROM ProductDiscount pd WHERE pd.product.id = :productId AND CURRENT_TIMESTAMP BETWEEN pd.startDate AND pd.endDate")
	List<BigDecimal> findActiveDiscountValuesByProductId(@Param("productId") int productId);

	// In CategoryDiscountRepository
	@Query("SELECT cd.discountValue FROM CategoryDiscount cd WHERE cd.category = :category AND CURRENT_TIMESTAMP BETWEEN cd.startDate AND cd.endDate")
	List<BigDecimal> findActiveDiscountValuesByCategory(@Param("category") Category category);

	// In BrandDiscountRepository
	@Query("SELECT bd.discountValue FROM BrandDiscount bd WHERE bd.brand = :brand AND CURRENT_TIMESTAMP BETWEEN bd.startDate AND bd.endDate")
	List<BigDecimal> findActiveDiscountValuesByBrand(@Param("brand") Brand brand);
}
