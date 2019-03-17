package snmaddula.product.crud.transformer;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import snmaddula.product.crud.dto.PriceDto;
import snmaddula.product.crud.dto.ProductDto;
import snmaddula.product.crud.entity.Price;
import snmaddula.product.crud.entity.Product;

@Service
public class ObjectTransformer {

	public ProductDto toDTO(Product product, Price price) {
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		PriceDto priceDto = new PriceDto();
		BeanUtils.copyProperties(price, priceDto);
		productDto.setPrice(priceDto);
		return productDto;
	}
	
	public Product toEntity(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		product.setPriceId(productDto.getPrice().getId());
		return product;
	}

	public Price toEntity(PriceDto priceDto) {
		Price price = new Price();
		BeanUtils.copyProperties(priceDto, price);
		return price;
	}
	
}
