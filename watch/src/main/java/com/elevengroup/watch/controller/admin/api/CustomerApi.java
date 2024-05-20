package com.elevengroup.watch.controller.admin.api;

import com.elevengroup.watch.entity.Customer;
import com.elevengroup.watch.repository.CustomerRepository;
import com.elevengroup.watch.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerApi {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete customer");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add customer");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(updatedCustomer.getId());
        if (!optionalCustomer.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + updatedCustomer.getId());
        }
        Customer customer = optionalCustomer.get();

        // Cập nhật các trường thông tin. Kiểm tra các trường đầu vào để tránh việc cập nhật những trường không mong muốn.
        customer.setFullName(updatedCustomer.getFullName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setAddress(updatedCustomer.getAddress());
        customer.setPhone(updatedCustomer.getPhone());

        // Lưu thông tin đã cập nhật
        Customer savedCustomer = customerRepository.save(customer);

        return ResponseEntity.ok(savedCustomer);
    }
}
