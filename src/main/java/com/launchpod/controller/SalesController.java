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

import com.launchpod.entity.Customer;
import com.launchpod.entity.Product;
import com.launchpod.entity.Sales;
import com.launchpod.service.CustomerService;
import com.launchpod.service.ProductService;
import com.launchpod.service.SalesService;

@Controller
@RequestMapping("/")
public class SalesController {
	@Autowired
	private SalesService salesService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	
 	@RequestMapping("/")
	public String listOfSalesOrder(Model model) {
		List<Sales> listSalesorder = salesService.listAll();
		model.addAttribute("listSalesorder", listSalesorder);
		
		return "saleorder";
	}
	
	@RequestMapping("/new")
	public String showNewSalesForm(Model model) {
		Sales sale = new Sales();
		List<Customer> listCustomer = customerService.listAll();
		List<Product> listProducts = productService.listAll();
		
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("listCustomers", listCustomer);
		model.addAttribute("sales", sale);
		
		return "new_salesorder";
	}
	
	@RequestMapping(value = "/newsave", method = RequestMethod.POST)
	public String saveSalesOrder(@ModelAttribute("salesorder") Sales salesorder) {
		
		Product product = productService.get(salesorder.getIdProduct());
		if(product.getInStock() > 0) {
		Customer customer = customerService.get(salesorder.getIdCustomer());
		customer.setLastBillAmount(salesorder.getPrice());
		customer.setLastBillDate(salesorder.getPurchaseDate());
		customerService.save(customer);
		
		product.setLastPurchaseOn(salesorder.getPurchaseDate());
		product.setInStock(product.getInStock() - 1);
		productService.save(product);
		salesService.save(salesorder);
		
		return "redirect:/salesorder/ShowAll";
		}
		else {
			return "redirect:/salesorder/SalesOrderNotPossible";
		}
	}
	
	@RequestMapping(value = "/SalesOrderNotPossible", method = RequestMethod.POST)
	public ModelAndView SalesOrderNotPossible() {
		ModelAndView mav = new ModelAndView("SalesOrderNotPossible");
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEditSalesOrder(@ModelAttribute("salesorder") Sales salesorder) {
		
		Customer customer = customerService.get(salesorder.getIdCustomer());
		customer.setLastBillAmount(salesorder.getPrice());
		customer.setLastBillDate(salesorder.getPurchaseDate());
		customerService.save(customer);
		Product product = productService.get(salesorder.getIdProduct());
		product.setLastPurchaseOn(salesorder.getPurchaseDate());
		productService.save(product);
		salesService.save(salesorder);
		
		return "redirect:/salesorder/ShowAll";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditSaleForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_saleorder");
		
		Sales sale = salesService.get(id);
		List<Customer> listCustomer = customerService.listAll();
		List<Product> listProducts = productService.listAll();
		
		mav.addObject("listCustomer", listCustomer);
		mav.addObject("listProducts", listProducts);
		mav.addObject("Sales", sale);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteSale(@PathVariable(name = "id") Long id) {
		
		Sales sale = salesService.get(id);
		Product products = productService.get(sale.getIdProduct());
		products.setInStock(products.getInStock() - 1);
		productService.save(products);
		salesService.delete(id);
		return "redirect:/salesorder/ShowAll";
	}
}
