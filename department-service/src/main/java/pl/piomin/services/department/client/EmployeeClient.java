package pl.piomin.services.department.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pl.piomin.services.department.model.Employee;

// Fallback would be invoked when the FeignClient is not available, use feign.hystrix.enable to open it
@FeignClient(name = "employee-service", fallback = EmployeeClientFallback.class)
public interface EmployeeClient {

	@GetMapping("/department/{departmentId}")
	List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);
	
}
