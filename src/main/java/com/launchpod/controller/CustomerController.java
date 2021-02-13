package com.launchpod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.launchpod.model.Customer;
import com.launchpod.model.Distributor;
import com.launchpod.service.CustomerService;
import com.launchpod.service.DistributorService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
 	@RequestMapping("/ShowAll")
	public String listOfCustomer(Model model) {
		List<Customer> listCustomers = customerService.listAll();
		model.addAttribute("listCustomers", listCustomers);
		
		return "customerList";
	}
	
	@RequestMapping("/new")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "new_customer";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditCustomerForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_distributor");
		
		Customer customer = customerService.get(id);
		mav.addObject("customer", customer);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(name = "id") Long id) {
		customerService.delete(id);
		
		return "redirect:/";
	}
}
