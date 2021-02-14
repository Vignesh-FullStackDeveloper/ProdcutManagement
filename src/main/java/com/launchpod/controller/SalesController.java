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
import com.launchpod.entity.Distributor;
import com.launchpod.entity.Sales;
import com.launchpod.model.SalesOrder;
import com.launchpod.service.CustomerService;
import com.launchpod.service.DistributorService;
import com.launchpod.service.SalesService;

@Controller
@RequestMapping("/salesorder")
public class SalesController {
	@Autowired
	private SalesService salesService;
	
 	@RequestMapping("/ShowAll")
	public String listOfSalesOrder(Model model) {
		List<SalesOrder> listSalesorder = salesService.getAllSalesOrder();
		model.addAttribute("listSalesorder", listSalesorder);
		
		return "saleorder";
	}
	
	@RequestMapping("/new")
	public String showNewSalesForm(Model model) {
		Sales sale = new Sales();
		model.addAttribute("sale", sale);
		
		return "new_sale";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSalesOrder(@ModelAttribute("salesorder") SalesOrder salesorder) {
		//salesService.saveSalesorder(salesorder);
		
		return "redirect:/salesorder/ShowAll";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditSaleForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_saleorder");
		
		SalesOrder saleOrder = salesService.getSaleOrder(id);
		mav.addObject("saleOrder", saleOrder);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteSale(@PathVariable(name = "id") Long id) {
		salesService.deleteSaleOrder(id);
		
		return "redirect:/salesorder/ShowAll";
	}
}
