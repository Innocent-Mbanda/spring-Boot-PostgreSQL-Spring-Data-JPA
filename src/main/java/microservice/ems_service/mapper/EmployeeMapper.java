package microservice.ems_service.mapper;

import microservice.ems_service.dto.EmployeeDto;
import microservice.ems_service.entity.Employee;

import java.util.Locale;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
           employee.getId(),
           employee.getFirstname(),
           employee.getLastName(),
           employee.getEmail()
        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}
