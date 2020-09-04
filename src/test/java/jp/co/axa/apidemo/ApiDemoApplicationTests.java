package jp.co.axa.apidemo;
import static org.junit.Assert.assertEquals;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiDemoApplicationTests {

	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository repository;
     	
	@Test
	public void getAllEmployeesTest() {
	Mockito.when(repository.findAll()).thenReturn(Stream
				.of(new Employee(1,"Akshay",100000,"HR"),new Employee(2,"Akki",200000,"Manager"),new Employee(3,"neeva",300000,"Engineer"))
				.collect(Collectors.toList()));
		assertEquals(3,employeeService.retrieveEmployees().size());
	System.out.println(employeeService.retrieveEmployees().size());
	}
	
	@Test
	public void saveEmployee() {
		Employee employee= new Employee(1,"Akshay",100000,"HR");
		Mockito.when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeService.saveEmployee(employee));
	}

	
	@Test
	public void updateEmployee() {
		Employee employee= new Employee(1,"Akshay",100000,"HR");
		Mockito.when(repository.save(employee)).thenReturn(employee);
		assertEquals(employee,employeeService.saveEmployee(employee));
	}

}

/*	@Test
public void getEmployeesByIdTest() {
	long id=1;
Employee e= new Employee(1,"Akshay",100000,"HR");	
 Mockito.when(repository.findById(id)).thenReturn(optEmp);
System.out.println("------optEmp.isPresent()--------"+optEmp.isPresent());	
assertEquals(1,optEmp.get());
//System.out.println(employeeService.retrieveEmployees().size());
}

/*	@Test
	public void	getEmployee()throws Exception {
		Mockito.when(employeeService.getEmployee(Mockito.anyLong())).thenReturn(employee);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/v1/employees/1").accept(
				MediaType.APPLICATION_JSON);
		 
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		//Employee e=  (Employee)result.getResponse();
		System.out.println("-------48==========response="+result.getResponse());
		String expected = "{id:1,name:Akshay,salary: 10000,department: HR}";
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
@Test
public void deleteEmployee() {
	Employee employee= new Employee(1,"Akshay",100000,"HR");
	long employeeId=1;
	//employee
//			repository.deleteById(1);
	//	Mockito.when(repository.deleteById(employeeId)).thenReturn(employee);
employeeService.deleteEmployee(employeeId);
//	verify(repository,1).deleteById(employeeId);
//}

//	@Autowired
//	private MockMvc mockMvc;

/*	@Test
public void deleteEmployee() {
	Employee employee= new Employee(1,"Akshay",100000,"HR");
//	Mockito.when(repository.save(employee)).thenReturn(employee);
	long employeeId=1;
	employeeService.deleteEmployee(employeeId);
	verify(repository,1).deleteById(employeeId);
	//(repository,times(1)).deleteById(employeeId);

}*/
