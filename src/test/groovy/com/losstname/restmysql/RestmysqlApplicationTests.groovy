package com.losstname.restmysql

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.losstname.restmysql.model.Customer
import com.losstname.restmysql.service.CustomerService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@RunWith(SpringRunner)
@SpringBootTest
@AutoConfigureMockMvc
class RestmysqlApplicationTests {

	@Autowired
	private MockMvc mockMvc

	@Autowired
	CustomerService customerService

	@Before
	void setUp(){
		customerService.saveAndFlush(new Customer(name:"Customer 1", email: "customer1@mail.com", age: 20))
		customerService.saveAndFlush(new Customer(name:"Customer 2", email: "customer2@mail.com", age: 21))
		customerService.saveAndFlush(new Customer(name:"Customer 3", email: "customer3@mail.com", age: 22))
	}

	@Test
	void getAllCustomer_return200() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/all")
				.accept(MediaType.APPLICATION_JSON)

		MvcResult result = mockMvc.perform(requestBuilder).andReturn()

		List<Customer> customers = new ObjectMapper().readValue(result.getResponse().getContentAsString(), new TypeReference<List<Customer>>(){})
		Assert.assertEquals(result.getResponse().getStatus(), HttpStatus.OK.value())
		Assert.assertNotEquals(0, customers.size())
	}

}
