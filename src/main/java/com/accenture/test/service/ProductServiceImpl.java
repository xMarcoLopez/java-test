package com.accenture.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.test.model.ProductDTO;
import com.accenture.test.utils.Utils;

@Service
public class ProductServiceImpl implements ProductService{

	@Override
	public List<ProductDTO> getProducts() {	
		return Utils.products;
	}
}
