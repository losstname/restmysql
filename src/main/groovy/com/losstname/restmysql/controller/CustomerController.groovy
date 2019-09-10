package com.losstname.restmysql.controller

import com.losstname.restmysql.model.Customer
import com.losstname.restmysql.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by umarwhk(umrwhk@gmail.com) on 2019-09-10.
 */

@RestController
@RequestMapping("/customer")
class CustomerController {

    @Autowired
    CustomerService customerService

    @GetMapping("/all")
    ResponseEntity getAll(){
        ResponseEntity.ok(customerService.getAll())
    }

    @GetMapping("/{id}")
    ResponseEntity getCustomer(@PathVariable Long id){
        ResponseEntity.ok(customerService.getCustomer(id))
    }

    @PostMapping("/new")
    ResponseEntity getAll(@RequestParam Map<String, String> params){
        ResponseEntity.ok(customerService.newCustomer(params))
    }

    @PostMapping("/{id}")
    ResponseEntity putUpdateCustomer(@PathVariable Long id, @RequestParam Map<String, String> params){
        ResponseEntity.ok(customerService.updateCustomer(id, params))
    }

    @DeleteMapping("/{id}")
    ResponseEntity deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id)
        ResponseEntity.ok(HttpStatus.OK)
    }
}
