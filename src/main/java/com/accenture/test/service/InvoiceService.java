package com.accenture.test.service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;

public interface InvoiceService {

	public InvoiceDTO generateInvoice(CustomerDTO customer);
	public boolean createdHourTime(Integer invoice_id);
	public InvoiceDTO getInvoice(Integer invoice_id);
	public InvoiceDTO editInvoice(Integer invoice_id);
}
