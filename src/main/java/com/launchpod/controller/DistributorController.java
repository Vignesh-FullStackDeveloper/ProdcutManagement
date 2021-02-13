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

import com.launchpod.model.Distributor;
import com.launchpod.service.DistributorService;

@Controller
public class DistributorController {
	@Autowired
	private DistributorService distributorService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Distributor> listDistributors = distributorService.listAll();
		model.addAttribute("listDistributors", listDistributors);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewDistributorForm(Model model) {
		Distributor distributor = new Distributor();
		model.addAttribute("distributor", distributor);
		
		return "new_distributor";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("distributor") Distributor distributor) {
		distributorService.save(distributor);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditDistributorForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_distributor");
		
		Distributor distributor = distributorService.get(id);
		mav.addObject("distributor", distributor);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteDistributor(@PathVariable(name = "id") Long id) {
		distributorService.delete(id);
		
		return "redirect:/";
	}
}
