package com.accenture.test.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ProductDTO;
import com.accenture.test.model.ShoppingCartDTO;

public class Utils {

	public static final List<CustomerDTO> customers = generateCustomers();
	public static final List<ProductDTO> products = generateProducts();
	public static final List<InvoiceDTO> invoices = generateInvoices();
	public static final List<ShoppingCartDTO> shoppingCarts = generateShoppingCarts();

	public static List<CustomerDTO> generateCustomers(){
		List <CustomerDTO> customers = new ArrayList<CustomerDTO>();
		customers.add(new CustomerDTO("1245789654", "Tony Stark", "New York"));
		customers.add(new CustomerDTO("7894578601", "Peter Parker", "New York"));
		customers.add(new CustomerDTO("4569871095", "Bruce Banner", "Australia"));
		customers.add(new CustomerDTO("0472847315", "Steve Rogers", "Manhattan"));
		return customers;
	}
	
	public static List<ProductDTO> generateProducts(){
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		products.add(new ProductDTO("ABC01", "Vibranium shield", 60.000f, 5));
		products.add(new ProductDTO("DEF01", "War machine armor", 80.000f, 4));
		products.add(new ProductDTO("FGH01", "Iron man costume", 100.000f, 3));
		products.add(new ProductDTO("IJK01", "Mjolnir", 120.000f, 1));
		return products;
	}
	
	public static List<InvoiceDTO> generateInvoices(){
		List<InvoiceDTO> invoices = new ArrayList<InvoiceDTO>();
		return invoices;
	}
	
	public static List<ShoppingCartDTO> generateShoppingCarts(){
		List<ShoppingCartDTO> shoppingCarts = new ArrayList<ShoppingCartDTO>();
		return shoppingCarts;
	}
	
	public static Date generateDate() {
		LocalDateTime date = LocalDateTime.of(2021, 2, 14, 5, 42, 20);
		Date dateTest = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
		return dateTest;
	}
}
