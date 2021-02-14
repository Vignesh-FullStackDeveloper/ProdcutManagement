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

import com.launchpod.entity.Distributor;
import com.launchpod.entity.Product;
import com.launchpod.entity.ProductInventory;
import com.launchpod.entity.Stock;
import com.launchpod.service.DistributorService;
import com.launchpod.service.ProductInventoryService;
import com.launchpod.service.ProductService;

@Controller
@RequestMapping("/inventory")
public class ProductInventoryController {
	
	@Autowired
	private ProductInventoryService productInventoryService;
	
	@Autowired
	private DistributorService distributorService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/new")
	public String showNewProductInventoryForm(Model model) {
		
		Stock stock = new Stock();
		List<Distributor> listDistributors = distributorService.listAll();
		List<Product> listProducts = productService.listAll();
		
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("listDistributors", listDistributors);
		model.addAttribute("stock", stock);
		
		return "new_inventory";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProductInventory(@ModelAttribute("stock") Stock stock) {
		productInventoryService.save(stock);
		
		return "redirect:/";
	}
	
	@RequestMapping("/ShowAll")
	public String viewInventoryPage(Model model) {
		List<Stock> listStocks = productInventoryService.listAll();
		model.addAttribute("listStocks", listStocks);
		return "inventoryList";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditInventoryForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_distributor");
		
		Distributor distributor = distributorService.get(id);
		mav.addObject("distributor", distributor);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteInventory(@PathVariable(name = "id") Long id) {
		distributorService.delete(id);
		
		return "redirect:/";
	}
	
	
}
