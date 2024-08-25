package microservice.ems_service.employeeServiceImpl;

import microservice.ems_service.dto.EmployeeDto;
import microservice.ems_service.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface Employee_Service {
    public EmployeeDto addEmployee(EmployeeDto employeeDto);

  EmployeeDto getEmployeeById(Long EmployeeId);

  List<EmployeeDto> getAllEmployees();
}
