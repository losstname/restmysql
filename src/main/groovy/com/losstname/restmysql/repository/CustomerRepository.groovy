package com.losstname.restmysql.repository

import com.losstname.restmysql.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Created by umarwhk(umrwhk@gmail.com) on 2019-09-10.
 */

@Repository
interface CustomerRepository extends JpaRepository<Customer, Long>{
}