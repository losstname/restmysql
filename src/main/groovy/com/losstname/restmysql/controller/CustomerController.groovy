package com.losstname.restmysql.controller

import com.losstname.restmysql.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
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
}
