package com.develhope.spring.User.Services;

import com.develhope.spring.User.Entities.Customer;
import com.develhope.spring.User.Entities.Salesman;
import com.develhope.spring.User.Repositories.AdminRepository;
import com.develhope.spring.User.Repositories.CustomerRepository;
import com.develhope.spring.User.Repositories.SalesmanRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    SalesmanRepository salesmanRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Salesman> salesmenList(){return salesmanRepository.findAll();}

    public Salesman deleteASalesman(Long id){

        return salesmanRepository.findById(id)
                .orElseThrow(

                        () -> new EntityNotFoundException("Salesman not fund by id " + id)

                );
    }

    public Salesman modifySalesman(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   Integer newPhoneNumber){

        Salesman salesman = salesmanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not fund by id " + id));

        salesman.setFirstName(newName);
        salesman.setLastName(newSurname);
        salesman.setAddress(newAddress);
        salesman.setPhone(newPhoneNumber);

        return salesman;
    }

    public List<Customer> customersList(){return customerRepository.findAll();}

    public Customer deleteACustomer(Long id){

        return customerRepository.findById(id)
                .orElseThrow(

                        () -> new EntityNotFoundException("Customer not fund by id " + id)

                );
    }

    public Customer modifyCustomer(Long id,
                                   String newName,
                                   String newSurname,
                                   String newAddress,
                                   Integer newPhoneNumber){

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Salesman not fund by id " + id));

        customer.setFirstName(newName);
        customer.setLastName(newSurname);
        customer.setAddress(newAddress);
        customer.setPhone(newPhoneNumber);

        return customer;
    }

}
