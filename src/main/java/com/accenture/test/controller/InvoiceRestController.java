package com.accenture.test.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.service.InvoiceService;
import com.accenture.test.utils.Utils;

@RestController
@RequestMapping("/v1/invoice")
public class InvoiceRestController {

	@Autowired
	InvoiceService invoiceService;
	
	@PostMapping
	public InvoiceDTO generateInvoice(@RequestBody CustomerDTO customer) {
		return invoiceService.generateInvoice(customer);
	}
	
	@GetMapping
	public List<InvoiceDTO> getInvoices(){
		return Utils.invoices;
	}
	
	@GetMapping("/{id}")
	public boolean getInvoiceById(@PathVariable Integer id){
		return invoiceService.createdHourTime(id);
	}
}
