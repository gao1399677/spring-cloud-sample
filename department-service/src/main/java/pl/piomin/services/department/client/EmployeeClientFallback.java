package pl.piomin.services.department.client;

import org.springframework.stereotype.Component;
import pl.piomin.services.department.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeClientFallback implements EmployeeClient {
    @Override
    public List<Employee> findByDepartment(Long departmentId) {
        return new ArrayList<>();
    }
}
