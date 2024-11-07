package iuh.fit.se.models.repositiory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import iuh.fit.se.models.entities.Product;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    // Tìm kiếm mà không có phân trang và sắp xếp
    @Query("SELECT p FROM Product p WHERE " + 
           "(LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
           "OR LOWER(p.category) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
           "OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) ")
    List<Product> findProductBySearchTerm(@Param("searchTerm") String searchTerm);

    // Tìm kiếm với phân trang và sắp xếp
    @Query("SELECT p FROM Product p WHERE " + 
           "(LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
           "OR LOWER(p.category) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
           "OR LOWER(p.brand) LIKE LOWER(CONCAT('%', :searchTerm, '%'))) " +
           "ORDER BY CASE WHEN :sortBy = 'price' THEN p.salePrice END ASC, " +
           "CASE WHEN :sortBy = 'name' THEN p.name END ASC")
    Page<Product> findProductBySearchTermWithPagination(@Param("searchTerm") String searchTerm, @Param("sortBy") String sortBy,
            Pageable pageable);
}
