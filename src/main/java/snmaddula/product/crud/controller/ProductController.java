package snmaddula.product.crud.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import snmaddula.product.crud.dto.ProductDto;
import snmaddula.product.crud.entity.Price;
import snmaddula.product.crud.entity.Product;
import snmaddula.product.crud.service.ProductService;
import snmaddula.product.crud.transformer.ObjectTransformer;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

	private final ObjectTransformer transformer;
	private final ProductService service;

	@GetMapping("{id}")
	public ProductDto getProductById(@PathVariable Long id) {
		Product product = service.getProductById(id);
		Price price = service.getPriceById(product.getPriceId());
		return transformer.toDTO(product, price);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addProduct(@RequestBody ProductDto productDto) {
		service.addProduct(productDto);
	}

	@DeleteMapping("{id}")
	@CacheEvict(value = "ProductCache", key = "#id")
	public void deleteProductById(@PathVariable Long id) {
		Product product = service.getProductById(id);
		service.removeProduct(id);
		service.removePrice(product.getPriceId());
	}
}
