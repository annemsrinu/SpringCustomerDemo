/**
 * 
 */
package com.learner.capg.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.learner.capg.dao.CustomerDAO;
import com.learner.capg.model.Customer;

/**
 * @author DELL
 *
 */
@Service
public class CustomerServiecImpl implements CustomerService {

	private CustomerDAO customerDAO;

	/**
	 * @param customerDAO the customerDAO to set
	 */
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void addCustomer(Customer c) {

		this.customerDAO.addCustomer(c);

	}

	@Transactional
	public void updateCustomer(Customer c) {
		this.customerDAO.updateCustomer(c);

	}

	@Transactional
	public List<Customer> listCustomers() {

		return this.customerDAO.listCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {

		return this.customerDAO.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {

		this.customerDAO.removeCustomer(id);

	}

}
