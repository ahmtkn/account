package com.springProject.account.service;

import com.springProject.account.dto.CustomerDto;
import com.springProject.account.dto.CustomerDtoConverter;
import com.springProject.account.exception.CustomerNotFoundException;
import com.springProject.account.model.Customer;
import com.springProject.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id){
        System.out.println(id);
        return this.customerRepository.findById(id)
                 .orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }

    public CustomerDto getCustomerById(String customerId){
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
    }

    public List<CustomerDto> getAllCustomer(){
        return customerRepository.findAll()
                .stream()
                .map(customerDtoConverter::convertToCustomerDto)
                .collect(Collectors.toList());
    }
}
