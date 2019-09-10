package com.losstname.restmysql.service

import com.losstname.restmysql.model.Customer
import com.losstname.restmysql.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by umarwhk(umrwhk@gmail.com) on 2019-09-10.
 */

@Service
class CustomerService {

    @Autowired
    CustomerRepository customerRepository

    List<Customer> getAll() throws Exception{
        List<Customer> customers = customerRepository.findAll()
        return customers
    }

    Customer saveAndFlush(Customer customer) throws Exception{
       Customer customerSaved = customerRepository.saveAndFlush(customer)
        return customerSaved
    }

    Customer newCustomer(Map<String, String> params) throws Exception{
        Customer newCustomer = new Customer(name: params.get("name"), email: params.get("email"), age: params.get("age").toInteger())
        this.saveAndFlush(newCustomer)
        return newCustomer
    }

    Optional<Customer> getCustomer(Long id) throws Exception{
        Optional<Customer> customer = customerRepository.findById(id)
        return customer
    }

    Customer updateCustomer(Long id, Map<String, String> params){
        Optional<Customer> customer = customerRepository.findById(id)
        if(customer.isPresent()){
            customer.get().name = params.get("name")
            customer.get().email = params.get("email")
            customer.get().age = params.get("age").toInteger()

            this.saveAndFlush(customer.get())
            return customer.get()
        }else{
            Customer newCustomer = new Customer(name: params.get("name"), email: params.get("email"), age: params.get("age").toInteger())
            this.saveAndFlush(newCustomer)
            return newCustomer
        }
    }

    void deleteCustomerById(Long id){
        customerRepository.deleteById(id)
    }

}
