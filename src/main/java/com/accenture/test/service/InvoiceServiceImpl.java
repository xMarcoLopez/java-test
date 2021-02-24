package com.accenture.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ProductDTO;
import com.accenture.test.model.ShoppingCartDTO;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public InvoiceDTO generateInvoice(CustomerDTO customer) {
		float totalProducts = 0;
		InvoiceDTO invoice = new InvoiceDTO();
		List<ProductDTO> products = customer.getShoppingCart().getProducts();
		

		for (ProductDTO product : products) {
			totalProducts += product.getTotalPriceProduct();
		}
	
		invoice.setTotalProducts(totalProducts);
		invoice.setIva(totalProducts * 0.19);
		invoice.setCreatedDate(new Date());
		invoice.setShoppingCart(customer.getShoppingCart());
		ShoppingCartDTO shoppingCart = new ShoppingCartDTO();
		customer.setShoppingCart(shoppingCart);

		if (totalProducts > 70000 && totalProducts < 100000) {
			invoice.setDeliveryPrice(10000);
			return invoice;
		} else if (totalProducts > 100000) {
			invoice.setDeliveryPrice(0);
			return invoice;
		}

		return null;
	}

}
