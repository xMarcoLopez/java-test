package com.accenture.test.service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.ProductDTO;

public interface ShoppingCartService {

	public ProductDTO add(ProductDTO product, CustomerDTO Customer);
	public ProductDTO remove(ProductDTO product, CustomerDTO Customer);
}
