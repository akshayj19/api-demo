package jp.co.axa.apidemo.controllers;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/hello-world")
 	public String helloWorld() {
 		return "Hello World Neeva Jain";
 	}

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        System.out.println("Akshay 1 list All");
    	List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }
    
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable(name="employeeId")Long employeeId) {
        System.out.println("Akshay 2 list by id");
        
        System.out.println("url hitted");
    	return employeeService.getEmployee(employeeId);
    }
   
    @PostMapping("/employee")
    public ResponseEntity<Void> saveEmployee(@RequestBody Employee employee){
    	System.out.println("employee="+employee.getName());
           employee.setId(-1L);
       Employee saveEmployee =  employeeService.saveEmployee(employee);
        System.out.println("Employee Saved Successfully");
            //Location//Get current resource url///{id}
      		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
      				.path("/{id}").buildAndExpand(saveEmployee.getId()).toUri();
      		
      		return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(name="employeeId")Long employeeId){
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name="employeeId")Long employeeId){
    	Employee updated = null;
    	Employee emp = employeeService.getEmployee(employeeId);
        if(emp != null){
           updated= employeeService.updateEmployee(employee);
        }
    	return new ResponseEntity<Employee>(updated, HttpStatus.OK);
    }
}
