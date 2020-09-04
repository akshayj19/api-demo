### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- Fork this project
- Enhance the code in any ways you can see, you are free!. Some possibilities:
  - Add tests
  - Change syntax
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your fork

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues

###### Changes in code and Bug fix ###########
1 Added h2 database proper configuration in application.properties file.
2 Added data.sql file to insert records in employee table in h2 database.
3 Added devtools in pom.xml file for autodeploy webapplication.
 
 changes in Employee.java Entity file.
4   Use lombok @Data annotation for all variables in place of @Setter and @Getter Annotations.
5   Added lombok @NoArgsConstructor 
6   Added lombok jar file in Eclipse for run lombok in webapplication.
     
Changes in EmployeeController method; 
7   changes in  @PostMapping create method
    return type ResponseEntity replace in place of void
    change in return response of this method as required by swagger-Ui.
    
8   changes in @DeleteMapping delete method.
    return type ResponseEntity replace in place of void
    change in return response of this method as required by swagger-Ui.

9  changes in @PutMapping update method.
    return type ResponseEntity replace in place of void
    change in return response of this method as required by swagger-Ui.

   Changes in Service layer interface of 3 methods 
10  public void saveEmployee(Employee employee);
    public void deleteEmployee(Long employeeId);
    public void updateEmployee(Employee employee);
    changes return type of all three methods and implement in serviceImpl class.

11  Added test methods in ApiDemoApplicationTests.java class.
 
12  Swagger-Ui page configuration change in SwaggerConfig.java file.