package com.accenture.test.service;

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
		double subtotal = 0;
		double iva = 0.19;
		double minValueToGenerateInvoice = 70000;
		double minValueToFreeDelivery = 100000;
		double deliveryPrice = 10000;
		String status = "Approbed";
		InvoiceDTO invoice = new InvoiceDTO();
		List<ProductDTO> products = customer.getShoppingCart().getProducts();

		for (ProductDTO product : products) {
			subtotal += product.getTotalPriceProduct();
		}

		invoice.setId(Utils.invoices.size() + 1);
		invoice.setSubtotal(subtotal);
		invoice.setIva(subtotal * iva);
		invoice.setId_customer(customer.getId());
		invoice.setDeliveryAddress(customer.getAddress());
		if (invoice.getCreatedDate() == null) {
			invoice.setCreatedDate(new Date());
		}
		invoice.setStatus(status);
		invoice.setShoppingCart(customer.getShoppingCart());
		ShoppingCartDTO shoppingCart = new ShoppingCartDTO();
		customer.setShoppingCart(shoppingCart);

		if (subtotal > minValueToGenerateInvoice && subtotal < minValueToFreeDelivery) {
			invoice.setDeliveryPrice(deliveryPrice);
			invoice.setTotal(invoice.getDeliveryPrice() + invoice.getSubtotal() + invoice.getIva());
			Utils.invoices.add(invoice);
			return invoice;
		} else if (subtotal > minValueToFreeDelivery) {
			invoice.setDeliveryPrice(0);
			invoice.setTotal(invoice.getDeliveryPrice() + invoice.getSubtotal() + invoice.getIva());
			Utils.invoices.add(invoice);
			return invoice;
		}

		return null;
	}

	@Override
	public boolean createdMsTimeLowerThanFiveHours(Integer invoice_id) {
		Date nowTime = new Date();
		Date invoice = getInvoice(invoice_id).getCreatedDate();
		long fiveHoursInMs = 18000000l;

		if (nowTime.getTime() - invoice.getTime() < fiveHoursInMs) {
			return true;
		}

		return false;
	}
	
	@Override
	public boolean createdMsTimeLowerThanTwelveHours(Integer invoice_id) {
		Date nowTime = new Date();
		Date invoice = getInvoice(invoice_id).getCreatedDate();
		long twelveHoursInMs = 43200000l;

		if (nowTime.getTime() - invoice.getTime() < twelveHoursInMs) {
			return true;
		}

		return false;
	}

	@Override
	public InvoiceDTO getInvoice(Integer invoice_id) {
		InvoiceDTO invoiceToFound = new InvoiceDTO(invoice_id);
		for (InvoiceDTO invoice : Utils.invoices) {
			if (invoice.getId() == invoiceToFound.getId()) {
				invoiceToFound = invoice;
				return invoiceToFound;
			}
		}

		return invoiceToFound;
	}

	@Override
	public InvoiceDTO editInvoice(Integer invoice_id, ShoppingCartDTO shoppingCart) {
		double iva = 0.19;
		double minValueToFreeDelivery = 100000;
		InvoiceDTO invoiceInDB = getInvoice(invoice_id);
		List<ProductDTO> newProducts = shoppingCart.getProducts();
		double totalNewProducts = 0;
		if (createdMsTimeLowerThanFiveHours(invoice_id)) {
			for (ProductDTO product : newProducts) {
				totalNewProducts += product.getPrice() * product.getAmount();
			}
			if (totalNewProducts >= invoiceInDB.getSubtotal()) {
				getInvoice(invoice_id).setShoppingCart(shoppingCart);
				getInvoice(invoice_id).setSubtotal(totalNewProducts);
				getInvoice(invoice_id).setIva(totalNewProducts * iva);
				if (getInvoice(invoice_id).getSubtotal() > minValueToFreeDelivery) {
					getInvoice(invoice_id).setDeliveryPrice(0);
					getInvoice(invoice_id).setTotal(getInvoice(invoice_id).getDeliveryPrice()
							+ getInvoice(invoice_id).getSubtotal() + getInvoice(invoice_id).getIva());
				} else {
					getInvoice(invoice_id).setTotal(getInvoice(invoice_id).getDeliveryPrice()
							+ getInvoice(invoice_id).getSubtotal() + getInvoice(invoice_id).getIva());
				}

			}
		}
		return getInvoice(invoice_id);
	}

	@Override
	public InvoiceDTO deleteInvoice(Integer invoice_id) {
		int indexInvoiceInDB = 0;
		String deletedStatus = "deleted";
		InvoiceDTO invoiceInDB = getInvoice(invoice_id);
		if(createdMsTimeLowerThanTwelveHours(invoice_id)) {
			indexInvoiceInDB = Utils.invoices.indexOf(invoiceInDB);
			Utils.invoices.remove(indexInvoiceInDB);
			invoiceInDB.setStatus(deletedStatus);
			return invoiceInDB;
		}
		
		return null;
	}
}
