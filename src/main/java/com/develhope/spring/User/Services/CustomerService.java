package com.develhope.spring.User.Services;

import com.develhope.spring.Purchase.Entities.Purchase;
import com.develhope.spring.Rent.Entities.Rent;
import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public List<Purchase> myPurchase(){
        return customerRepository.purchaseList();
    }

    public List<Purchase> myOrder(){
        return customerRepository.orderList();
    }

    public List<Rent> myRent(){
        return customerRepository.rentList();
    }

    public void deleteAccount(Long id){ //id di accesso del cliente
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updateCustomer) {

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User con id: " + id + " non trovato!"));

        if (updateCustomer.getFirstName() != null && !updateCustomer.getFirstName().isEmpty()) {
            customer.setFirstName(updateCustomer.getFirstName());
        }
        if (updateCustomer.getLastName() != null && !updateCustomer.getLastName().isEmpty()) {
            customer.setLastName(updateCustomer.getLastName());
        }
        if (updateCustomer.getEmail() != null && !updateCustomer.getEmail().isEmpty()) {
            customer.setEmail(updateCustomer.getEmail());
        }
        if (updateCustomer.getPassword() != null && !updateCustomer.getPassword().isEmpty()) {
            customer.setPassword(updateCustomer.getPassword());
        }
        if (updateCustomer.getPhone() != null && !updateCustomer.getPhone().isEmpty()) {
            customer.setPhone(updateCustomer.getPhone());
        }
        if (updateCustomer.getAddress() != null && !updateCustomer.getAddress().isEmpty()) {
            customer.setAddress(updateCustomer.getAddress());
        }
        if (updateCustomer.getCreditCard() != null && !updateCustomer.getCreditCard().isEmpty()) {
            customer.setCreditCard(updateCustomer.getCreditCard());
        }
        if (updateCustomer.getTaxId() != null && !updateCustomer.getTaxId().isEmpty()) {
            customer.setTaxId(updateCustomer.getTaxId());
        }
        if (!customer.equals(updateCustomer)) {
            customer = customerRepository.save(customer);
        }

        return customer;

    }
}
