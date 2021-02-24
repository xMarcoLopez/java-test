package com.accenture.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.test.model.CustomerDTO;
import com.accenture.test.model.InvoiceDTO;
import com.accenture.test.model.ShoppingCartDTO;
import com.accenture.test.service.InvoiceService;
import com.accenture.test.utils.Utils;

@RestController
@RequestMapping("/v1/invoice")
public class InvoiceRestController {

	@Autowired
	InvoiceService invoiceService;
	
	@GetMapping
	public List<InvoiceDTO> getInvoices(){
		return Utils.invoices;
	}
	
	@GetMapping("/{id}")
	public InvoiceDTO getInvoiceById(@PathVariable Integer id){
		return invoiceService.getInvoice(id);
	}
	
	@PostMapping
	public InvoiceDTO generateInvoice(@RequestBody CustomerDTO customer) {
		return invoiceService.generateInvoice(customer);
	}
	
	@PutMapping("/{id}")
	public InvoiceDTO editInvoice(@PathVariable Integer id, @RequestBody ShoppingCartDTO shoppingCart) {
		return invoiceService.editInvoice(id, shoppingCart);
	}
	
	@PutMapping("/change-date/{id}")
	public InvoiceDTO changeCreatedDate(@PathVariable Integer id) {
		return invoiceService.changeCreatedDate(id);
	}
	
	@DeleteMapping("/{id}")
	public InvoiceDTO deleteInvoice(@PathVariable Integer id) {
		return invoiceService.deleteInvoice(id);
	}
}
