package snmaddula.product.crud.dto;

import lombok.Data;

@Data
public class ProductDto {

	private Long id;
	private String title;
	private String description;
	private PriceDto price;
}
