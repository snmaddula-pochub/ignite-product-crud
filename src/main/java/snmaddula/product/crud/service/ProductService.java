package snmaddula.product.crud.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import snmaddula.product.crud.dto.ProductDto;
import snmaddula.product.crud.entity.Price;
import snmaddula.product.crud.entity.Product;
import snmaddula.product.crud.repo.PriceRepo;
import snmaddula.product.crud.repo.ProductRepo;
import snmaddula.product.crud.transformer.ObjectTransformer;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ObjectTransformer transformer;
	private final ProductRepo productRepo;
	private final PriceRepo priceRepo;

	/*************************** CREATE ********************************/
	public void addProduct(ProductDto productDto) {
		Price price = savePrice(transformer.toEntity(productDto.getPrice()));
		Product product = transformer.toEntity(productDto);
		product.setPriceId(price.getId());
		saveProduct(product);
	}

	private Price savePrice(Price price) {
		return priceRepo.save(price);
	}

	private Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	

	/*************************** FETCH ********************************/
	@Cacheable(value = "ProductCache", key = "#id")
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}

	@Cacheable(value = "PriceCache", key = "#id")
	public Price getPriceById(Long id) {
		return priceRepo.findById(id).orElse(null);
	}

	
	/*************************** DELETE ********************************/
	@CacheEvict(value = "ProductCache", key = "#id")
	public void removeProduct(Long id) {
		productRepo.deleteById(id);
	}

	@CacheEvict(value = "PriceCache", key = "#id")
	public void removePrice(Long id) {
		priceRepo.deleteById(id);
	}


}
