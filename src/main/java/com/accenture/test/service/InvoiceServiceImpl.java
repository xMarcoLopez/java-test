package com.accenture.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ProductDTO;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Override
	public InvoiceDTO generateInvoice(CustomerDTO customer) {
		InvoiceDTO invoice = new InvoiceDTO();
		List<ProductDTO> products = customer.getShoppingCart().getProducts();
		float totalProducts = 0;
		
		for(ProductDTO product : products) {
			totalProducts = product.getPrice();
		}
		
		invoice.setTotalProducts(totalProducts);
		invoice.setIva((float) (totalProducts*0.19));
		invoice.setCreatedDate(new Date());
		invoice.setShoppingCart(customer.getShoppingCart());
		customer.setShoppingCart(null);
		
		if(totalProducts > 70.000 && totalProducts < 100.000) {
			invoice.setDeliveryPrice((float) 10.000);
			return invoice;
		} else if (totalProducts < 100.000) {
			invoice.setDeliveryPrice(0);
			return invoice;
		}
		
		return null;
	}

}
