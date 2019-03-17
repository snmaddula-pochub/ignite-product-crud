package snmaddula.product.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import snmaddula.product.crud.entity.Price;

@Repository
public interface PriceRepo extends JpaRepository<Price, Long> {

}
