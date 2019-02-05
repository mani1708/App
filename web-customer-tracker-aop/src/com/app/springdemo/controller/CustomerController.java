package com.app.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.springdemo.entity.Customer;
import com.app.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomers(Model theModel) {
		
		List<Customer> theCustomers=customerService.getCustomers();
		
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		
		Customer theCustomer=new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer( @ModelAttribute("customer") @Valid Customer theCustomer,
			BindingResult theBindingResult) {
		
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		Customer theCustomer=customerService.getCustomer(theId);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("search") String customer,Model theModel) {
		
		List<Customer> customer1=customerService.findCustomer(customer);
		
		theModel.addAttribute("customers", customer1);
		
		return "list-customers";
	}
	
}
