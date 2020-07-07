/**
 * 
 */
package com.learner.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learner.capg.model.Customer;
import com.learner.capg.model.CustomerDetails;
import com.learner.capg.service.CustomerService;

/**
 * @author DELL
 *
 */
@Controller
public class CustomerController {

	private CustomerService customerService;

	@Autowired(required = true)
	@Qualifier(value = "customerService")
	public void setCustomerService(CustomerService cr) {
		this.customerService = cr;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("customerDetails", new CustomerDetails());
		return "login";
	}

	@RequestMapping(value = "/loginDetails", method = RequestMethod.POST)
	public String login(@ModelAttribute("customerDetails") CustomerDetails cd) {

		String name = cd.getUsername();
		String pwd = cd.getPassword();
		if (name.equals("srini") && pwd.equals("srini123")) {
			return  "redirect:/customers";
		} else {
			return "login";
		}

	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}

	// For add and update person both
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer c) {

		List<Customer> customers = customerService.listCustomers();
		boolean value = containsId(customers, c.getId());
		if (!value) {
			if (c.getId() > 0) {
				// new person, add it
				this.customerService.addCustomer(c);
			}
		} else if (c.getId() > 0) {
			this.customerService.updateCustomer(c);
			// existing person, call update
		}

		return "redirect:/customers";

	}

	@RequestMapping("/remove/{id}")
	public String removeCustomer(@PathVariable("id") int id) {

		this.customerService.removeCustomer(id);
		return "redirect:/customers";
	}

	@RequestMapping("/edit/{id}")
	public String editCustomer(@PathVariable("id") int id, Model model) {
		model.addAttribute("customer", this.customerService.getCustomerById(id));
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "customer";
	}

	public boolean containsId(final List<Customer> list, final int id) {
		return list.stream().anyMatch(o -> o.getId() == (id));
	}
}
