package snmaddula.product.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import snmaddula.product.crud.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
