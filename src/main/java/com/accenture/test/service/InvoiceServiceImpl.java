package com.accenture.test.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ShoppingCartDTO;
import com.accenture.test.utils.Utils;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Override
	public InvoiceDTO generateInvoice(CustomerDTO customer) {
		double subtotal = Utils.calculateSubtotal(customer.getShoppingCart().getProducts());
		ShoppingCartDTO emptyShoppingCart = new ShoppingCartDTO();
		InvoiceDTO invoice = new InvoiceDTO(customer.getId(), customer.getAddress(), subtotal, subtotal * Utils.iva,
				new Date(), Utils.approvedStatus, customer.getShoppingCart());
		
		invoice.getShoppingCart().setCustomer(customer);
		customer.setShoppingCart(emptyShoppingCart);

		if (subtotal > Utils.minValueToGenerateInvoice && subtotal < Utils.minValueToFreeDelivery) {
			invoice.setId(Utils.autoIncremental.size() + 1);
			Utils.autoIncremental.add(1);
			invoice.setShipPrice(Utils.shipPrice);
			invoice.calculateTotal();
			Utils.invoices.add(invoice);
		} else if (subtotal > Utils.minValueToFreeDelivery) {
			invoice.setId(Utils.autoIncremental.size() + 1);
			Utils.autoIncremental.add(1);
			invoice.setShipPrice(0);
			invoice.calculateTotal();
			Utils.invoices.add(invoice);
		} else {
			invoice = null;
		}

		return invoice;
	}

	@Override
	public InvoiceDTO editInvoice(Integer invoice_id, ShoppingCartDTO shoppingCart) {
		InvoiceDTO invoiceInDB = getInvoice(invoice_id);
		double totalNewProducts = Utils.calculateSubtotal(shoppingCart.getProducts());
		if (verifyCreatedDateWithHoursInMs(invoice_id, 5)) {
			if (totalNewProducts >= invoiceInDB.getSubtotal()) {
				getInvoice(invoice_id).setShoppingCart(shoppingCart);
				getInvoice(invoice_id).setSubtotal(totalNewProducts);
				getInvoice(invoice_id).setIva(totalNewProducts * Utils.iva);
				if (getInvoice(invoice_id).getSubtotal() > Utils.minValueToFreeDelivery) {
					getInvoice(invoice_id).setShipPrice(0);
					getInvoice(invoice_id).calculateTotal();
				} else {
					getInvoice(invoice_id).calculateTotal();
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

		if (verifyCreatedDateWithHoursInMs(invoice_id, 12)) {
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
		penaltyInvoice.setShipAddress(invoiceInDB.getShipAddress());
		penaltyInvoice.setCreatedDate(new Date());
		penaltyInvoice.setStatus(Utils.approvedStatus);
		Utils.invoices.add(penaltyInvoice);

		return penaltyInvoice;
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
	public boolean verifyCreatedDateWithHoursInMs(Integer invoice_id, int hours) {
		Date nowTime = new Date();
		Date invoice = getInvoice(invoice_id).getCreatedDate();
		long hoursInMs = 3600000l * hours;

		if (nowTime.getTime() - invoice.getTime() < hoursInMs) {
			return true;
		}

		return false;
	}

	@Override
	public InvoiceDTO changeCreatedDate(Integer invoice_id) {
		Date createdDate = Utils.generateDate();
		getInvoice(invoice_id).setCreatedDate(createdDate);
		return getInvoice(invoice_id);
	}
}
