package snmaddula.product.crud.dto;

import lombok.Data;

@Data
public class PriceDto {

	private Long id;
	private Double basePrice;
	private Double tax;
	private Double maxRetailPrice;
}
