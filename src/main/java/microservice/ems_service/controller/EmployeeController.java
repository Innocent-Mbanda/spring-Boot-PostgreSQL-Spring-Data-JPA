package microservice.ems_service.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservice.ems_service.dto.EmployeeDto;
import microservice.ems_service.serviceImp.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/employees")
@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/employee")
    private ResponseEntity<EmployeeDto> createEmployee( @RequestBody  EmployeeDto employeeDto) {
        EmployeeDto saveEmployee = employeeService.addEmployee(employeeDto);
        log.info("employee created");
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}/employeeId")

    public ResponseEntity<EmployeeDto>getEmployee(@PathVariable("id") Long employeeId) throws IllegalArgumentException{
      EmployeeDto employeeDto =  employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(employeeDto);
    }

    @GetMapping("employees")
    public ResponseEntity<List<EmployeeDto>>getListOfAllEmployees(){
       List<EmployeeDto> employees = employeeService.getAllEmployees();
       return ResponseEntity.ok((employees));
    }
}
