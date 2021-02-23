package com.accenture.test.service;

import com.accenture.test.model.Product;

public interface ShoppingCartService {

	public void add(Product product);
	public void remove(Product product);
}
