package com.losstname.restmysql.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by umarwhk(umrwhk@gmail.com) on 2019-09-10.
 */

@Entity
class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    String name

    Integer age

    String email

}
