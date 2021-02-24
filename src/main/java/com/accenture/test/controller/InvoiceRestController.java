package com.accenture.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.service.InvoiceService;

@RestController
@RequestMapping("/v1/invoice")
public class InvoiceRestController {

	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping
	public InvoiceDTO generateInvoice(@RequestBody CustomerDTO customer) {
		return invoiceService.generateInvoice(customer);
	}
}
