package com.accenture.test.service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ShoppingCartDTO;

public interface InvoiceService {

	public InvoiceDTO generateInvoice(CustomerDTO customer);
	public boolean createdMsTimeLowerThanFiveHours(Integer invoice_id);
	public boolean createdMsTimeLowerThanTwelveHours(Integer invoice_id);
	public InvoiceDTO getInvoice(Integer invoice_id);
	public InvoiceDTO editInvoice(Integer invoice_id, ShoppingCartDTO shoppingCart);
	public InvoiceDTO deleteInvoice(Integer invoice_id);
	public InvoiceDTO changeCreatedDate(Integer invoice_id);
}
