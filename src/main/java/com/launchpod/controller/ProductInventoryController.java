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
        Product product = productService.get(stock.getIdProduct());
        product.setInStock(stock.getUnitsreceived() + product.getInStock());
        productService.save(product);
        productInventoryService.save(stock);
		
		return "redirect:/inventory/ShowAll";
	}
	
	@RequestMapping("/ShowAll")
	public String viewInventoryPage(Model model) {
		List<Stock> listStocks = productInventoryService.listAll();
		model.addAttribute("listStocks", listStocks);
		return "inventoryList";
	}
	
	
//	@RequestMapping("/edit/{id}")
//	public ModelAndView showEditInventoryForm(@PathVariable(name = "id") Long id) {
//		ModelAndView mav = new ModelAndView("edit_inventory");
//		
//		Stock stock = productInventoryService.get(id);		
//		List<Distributor> listDistributors = distributorService.listAll();
//		List<Product> listProducts = productService.listAll();	
//		
//		mav.addObject("listProducts", listProducts);
//		mav.addObject("listDistributors", listDistributors);
//		mav.addObject("stock", stock);
//		
//		return mav;
//	}	
//	
//	@RequestMapping("/delete/{id}")
//	public String deleteInventory(@PathVariable(name = "id") Long id) {
//		
//		Stock stock = productInventoryService.get(id);		
//		Product product = productService.get(stock.getIdProduct());
//        product.setInStock(product.getInStock() - 1);
//        productService.save(product);
//		
//		productInventoryService.delete(id);
//		
//		return "redirect:/";
//	}
	
	
}
