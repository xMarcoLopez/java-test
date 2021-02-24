package com.accenture.test.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ProductDTO;
import com.accenture.test.model.ShoppingCartDTO;
import com.accenture.test.utils.Utils;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public InvoiceDTO generateInvoice(CustomerDTO customer) {
		double totalProducts = 0;
		double iva = 0.19;
		double minValueToGenerateInvoice = 70000;
		double minValueToFreeDelivery = 10000;
		InvoiceDTO invoice = new InvoiceDTO();
		List<ProductDTO> products = customer.getShoppingCart().getProducts();
		

		for (ProductDTO product : products) {
			totalProducts += product.getTotalPriceProduct();
		}
	
		invoice.setId(Utils.invoices.size()+1);
		invoice.setTotalProducts(totalProducts);
		invoice.setIva(totalProducts * iva);
		
		if(invoice.getCreatedDate() == null) {
			invoice.setCreatedDate(new Date());	
		}
		
		invoice.setShoppingCart(customer.getShoppingCart());
		ShoppingCartDTO shoppingCart = new ShoppingCartDTO();
		customer.setShoppingCart(shoppingCart);

		if (totalProducts > minValueToGenerateInvoice && totalProducts < minValueToFreeDelivery) {
			invoice.setDeliveryPrice(minValueToFreeDelivery);
			Utils.invoices.add(invoice);
			return invoice;
		} else if (totalProducts > minValueToFreeDelivery) {
			invoice.setDeliveryPrice(0);
			Utils.invoices.add(invoice);
			return invoice;
		}

		return null;
	}

	@Override
	public boolean createdHourTime(Integer invoice_id) {
		Date nowTime = new Date();
		Date invoice = getInvoice(invoice_id).getCreatedDate();
		long fiveHoursInMs = 18000000l;
	
		if(nowTime.getTime() - invoice.getTime() < fiveHoursInMs) {
			return true;
		}
		
		return false;
	}

	
	@Override
	public InvoiceDTO getInvoice(Integer invoice_id) {
		InvoiceDTO invoiceToFound = new InvoiceDTO(invoice_id);
		for(InvoiceDTO invoice: Utils.invoices) {
			if(invoice.getId() == invoiceToFound.getId()) {
				invoiceToFound = invoice;
				return invoiceToFound;
			}
		}
		
		return invoiceToFound;
	}

	@Override
	public InvoiceDTO editInvoice(Integer invoice_id) {
		// TODO Auto-generated method stub
		return null;
	}


}
