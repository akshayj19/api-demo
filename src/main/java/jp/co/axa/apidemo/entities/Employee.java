package jp.co.axa.apidemo.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name="EMPLOYEE")
public class Employee {
	  
	  @Id
	  @GeneratedValue(strategy= GenerationType.IDENTITY)
	 // @Column(name="ID")
	  private  Long id;

	  @Column(name="EMPLOYEE_NAME")
	  private String name;
	  
	  @Column(name="EMPLOYEE_SALARY")
	  private Integer salary;

	  @Column(name="DEPARTMENT")
	  private String department;

	  public Employee(long id, String name, int salary,String department ) {
			super();
			this.id = id;
			this.name = name;
			this.salary = salary;
			this.department = department;
		}
}