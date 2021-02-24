package com.accenture.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.ProductDTO;
import com.accenture.test.utils.Utils;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {


	@Override
	public ProductDTO add(CustomerDTO customer, ProductDTO product) {
		customer.getShoppingCart().getProducts().add(product);
		return product;
	}

	@Override
	public CustomerDTO addProductsList(CustomerDTO customer) {
		
		List<ProductDTO> products = customer.getShoppingCart().getProducts();	
		List<ProductDTO> productsList = Utils.generateProducts();
		
		for(int i = 0; i < products.size(); i++) {
			if(productsList.contains(products.get(i))) {
				
			}
		}
		return customer;
	}
	
	@Override
	public ProductDTO remove(ProductDTO product, CustomerDTO customer) {
		customer.getShoppingCart().getProducts().remove(product);
		return product;
	}

}
