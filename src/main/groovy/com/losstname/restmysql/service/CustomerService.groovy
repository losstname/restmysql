package com.losstname.restmysql.service

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

}
