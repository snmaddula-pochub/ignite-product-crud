package snmaddula.product.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRICE")
public class Price {

	@Id
	private Long id;
	private Double basePrice;
	private Double tax;
	private Double maxRetailPrice;

}
