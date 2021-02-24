package com.accenture.test.service;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;

public interface InvoiceService {

	public InvoiceDTO generateInvoice(CustomerDTO customer);
}
