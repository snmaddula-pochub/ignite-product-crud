package snmaddula.product.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	private Long id;
	private String title;
	private String description;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "price_id")
//	private Price price;
	private Long priceId;
}