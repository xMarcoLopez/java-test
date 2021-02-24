package com.accenture.test.service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.ProductDTO;

public interface ShoppingCartService {

	public ProductDTO add(CustomerDTO Customer, ProductDTO product);
	public CustomerDTO addProductsList(CustomerDTO customer);
	public ProductDTO remove(ProductDTO product, CustomerDTO Customer);
}
