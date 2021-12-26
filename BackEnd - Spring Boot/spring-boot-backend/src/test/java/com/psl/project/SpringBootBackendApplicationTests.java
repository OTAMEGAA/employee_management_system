package com.psl.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psl.project.model.Employee;
import com.psl.project.repository.EmployeeRepository;

@SpringBootTest
class SpringBootBackendApplicationTests {
	@Autowired
	EmployeeRepository eRepo;

	@Test
	public void testCreate() {
		Employee e = new Employee();
		e.setId(12L);
		e.setFirstName("Himu");
		e.setLastName("Nay");
		e.setEmailId("HimuNay@gmail.com");
		e.setPassword("aaa");
		e.setSalary(10000);
		e.setRole("Admin");
		eRepo.save(e);
		assertNotNull(eRepo.findById(12L));
	}
}
