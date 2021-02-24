package com.accenture.test.service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.ProductDTO;


public class ShoppingCartServiceImpl implements ShoppingCartService {


	@Override
	public ProductDTO add(ProductDTO product, CustomerDTO customer) {
		customer.getShoppingCart().getProducts().add(product);
		return product;
	}

	@Override
	public ProductDTO remove(ProductDTO product, CustomerDTO customer) {
		customer.getShoppingCart().getProducts().remove(product);
		return product;
	}

}
