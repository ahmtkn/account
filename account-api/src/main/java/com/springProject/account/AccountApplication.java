package com.springProject.account;

import com.springProject.account.model.Customer;
import com.springProject.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = customerRepository.save(new Customer("Ahmet", "Tekin", new HashSet<>()));
		Customer customer2 = customerRepository.save(new Customer("Hüseyin", "Tekin", new HashSet<>()));
		Customer customer3 = customerRepository.save(new Customer("Yusuf", "Tekin", new HashSet<>()));
		System.out.println(customer);
		System.out.println(customer2);
		System.out.println(customer3);
	}
}
