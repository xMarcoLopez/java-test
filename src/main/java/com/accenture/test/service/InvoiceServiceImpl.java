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
		InvoiceDTO invoice = new InvoiceDTO();
		ShoppingCartDTO emptyShoppingCart = new ShoppingCartDTO();
		List<ProductDTO> products = customer.getShoppingCart().getProducts();

		for (ProductDTO product : products) {
			subtotal += product.getTotalPriceProduct();
		}

		invoice.setSubtotal(subtotal);
		invoice.setIva(subtotal * Utils.iva);
		invoice.setId_customer(customer.getId());
		invoice.setDeliveryAddress(customer.getAddress());
		invoice.setCreatedDate(new Date());
		invoice.setStatus(Utils.approvedStatus);
		invoice.setShoppingCart(customer.getShoppingCart());
		invoice.getShoppingCart().setCustomer(customer);
		
		customer.setShoppingCart(emptyShoppingCart);

		if (subtotal > Utils.minValueToGenerateInvoice && subtotal < Utils.minValueToFreeDelivery) {
			invoice.setId(Utils.autoIncremental.size() + 1);
			Utils.autoIncremental.add(1);
			invoice.setDeliveryPrice(Utils.deliveryPrice);
			invoice.setTotal(invoice.getDeliveryPrice() + invoice.getSubtotal() + invoice.getIva());
			Utils.invoices.add(invoice);
		} else if (subtotal > Utils.minValueToFreeDelivery) {
			invoice.setId(Utils.autoIncremental.size() + 1);
			Utils.autoIncremental.add(1);
			invoice.setDeliveryPrice(0);
			invoice.setTotal(invoice.getDeliveryPrice() + invoice.getSubtotal() + invoice.getIva());
			Utils.invoices.add(invoice);
		}  else {
			invoice = null;
		}

		return invoice;
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
				getInvoice(invoice_id).setIva(totalNewProducts * Utils.iva);
				if (getInvoice(invoice_id).getSubtotal() > Utils.minValueToFreeDelivery) {
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
		InvoiceDTO penaltyInvoice = new InvoiceDTO();
		InvoiceDTO invoiceInDB = getInvoice(invoice_id);
		
		if(createdMsTimeLowerThanTwelveHours(invoice_id)) {
			indexInvoiceInDB = Utils.invoices.indexOf(invoiceInDB);
			Utils.invoices.remove(indexInvoiceInDB);
			invoiceInDB.setStatus(Utils.deletedStatus);
			return invoiceInDB;
		} 
		indexInvoiceInDB = Utils.invoices.indexOf(invoiceInDB);
		Utils.invoices.get(indexInvoiceInDB).setStatus(Utils.canceledStatus);
		penaltyInvoice.setTotal(invoiceInDB.getSubtotal() * Utils.penalty);
		penaltyInvoice.setId(Utils.autoIncremental.size() + 1);
		Utils.autoIncremental.add(1);
		penaltyInvoice.setId_customer(invoiceInDB.getId_customer());
		penaltyInvoice.setDeliveryAddress(invoiceInDB.getDeliveryAddress());
		penaltyInvoice.setCreatedDate(new Date());
		penaltyInvoice.setStatus(Utils.approvedStatus);
		Utils.invoices.add(penaltyInvoice);
		
		return penaltyInvoice;
	}

	@Override
	public InvoiceDTO changeCreatedDate(Integer invoice_id) {
		Date createdDate = Utils.generateDate();
		getInvoice(invoice_id).setCreatedDate(createdDate);
		return getInvoice(invoice_id);
	}
}
