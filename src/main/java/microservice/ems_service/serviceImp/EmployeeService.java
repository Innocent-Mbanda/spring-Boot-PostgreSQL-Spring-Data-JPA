package microservice.ems_service.serviceImp;

import lombok.AllArgsConstructor;
import microservice.ems_service.dto.EmployeeDto;
import microservice.ems_service.employeeServiceImpl.Employee_Service;
import microservice.ems_service.entity.Employee;
import microservice.ems_service.exception.employeeNotFoundException;
import microservice.ems_service.mapper.EmployeeMapper;
import microservice.ems_service.repositotry.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService implements Employee_Service {
    private EmployeeRepo employeeRepo;
    
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
       Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
      Employee savedEmployee= employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
     Employee employee =employeeRepo.findById(employeeId)
                .orElseThrow(()-> new employeeNotFoundException("employee not found") );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee>employeeList= employeeRepo.findAll();
        return employeeList.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }


}
