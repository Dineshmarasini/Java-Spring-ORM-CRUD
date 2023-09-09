package com.spring.ormCrud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.entities.Student;
import com.spring.ormCrud.dao.EmployeeDao;
import com.spring.ormCrud.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("configCrud.xml");
    	EmployeeDao employeeDao=context.getBean("employeeDao",EmployeeDao.class);
//    	Employee employee=new Employee(1,"ER. Dinesh Marasini","Software Engineer",10000000);
//    	int r=employeeDao.insert(employee);
//    	
//    	System.out.println("successfully inserted....."+r);
    	  
    	  
    	BufferedReader bReader =new BufferedReader(new InputStreamReader(System.in));
        boolean go =true;
        while (go) {
        	System.out.println("********************************************************");
        System.out.println("press 1 for add new employee: ");
        System.out.println("press 2 for display all employee:");
        System.out.println("press 3 for get details of single employee:");
        System.out.println("press 4 for delete all employee: ");
        System.out.println("press 5 for update employee: ");
        System.out.println("press 6 for exit") ;
        
        try {
        	int input=Integer.parseInt(bReader.readLine());
        	
        	
        switch(input) {
        case 1:
        	//add a new Employeee
        	
        	System.out.println("Enter Employee id:");
        	int eId=Integer.parseInt(bReader.readLine());
        	
        	System.out.println("Enter the Name: ");
        	String eName=bReader.readLine();
        	
        	System.out.println("Enter the Position: ");
        	String ePosition=bReader.readLine();
        	
        	System.out.println("Enter the salary");
        	int eSalary=Integer.parseInt(bReader.readLine());
        	
        	Employee e=new Employee();
        	e.setEmpId(eId);
        	e.setEmpName(eName);
        	e.setEmpPosition(ePosition);
        	e.setEmpSalary(eSalary);
        	
        	int r=employeeDao.insert(e);
        	System.out.println("successfully Inserted data: "+r);
        	System.out.println("********************************************************");
        	System.out.println();
        	 break;
        	 
        case 2:
        	//display all Employee
        	System.out.println("********************************************************");
        	List<Employee> allEmployee=employeeDao.getallEmployees();
        	for(Employee element:allEmployee) {
        		System.out.println("Id: "+element.getEmpId());
        		System.out.println("Name: "+element.getEmpName());
        		System.out.println("Position: "+element.getEmpPosition());
        		System.out.println("Salary");
        		System.out.println("______________________________________________________");
        	}
        	break;
        	
        case 3:
        	//get single object
        	 
        	System.out.println("Enter user id:");
        	int userId=Integer.parseInt(bReader.readLine());
        	Student student= studentDao.getStudent(userId);
        	System.out.println("Name: "+student.getStudentName());
    		System.out.println("Id: "+student.getStudentId());
    		System.out.println("City: "+student.getStudentCity());
        	
        	break;
        	
        	
        case 4:
        	//delete all student
        	System.out.println("Enter user id:");
        	int id=Integer.parseInt(bReader.readLine());
        	studentDao.deleteStudent(id);
        	System.out.println("successfully deleted...!");
        	 
        	 
        	 
        	
        case 5:
        	//update student
        	System.out.print("type in the id of student you want to update:");
			int oldId = Integer.parseInt(bReader.readLine());
			System.out.print("Enter new user name:");
			String namee= bReader.readLine();
			System.out.print("Enter new user city:");
			String cityy= bReader.readLine();
			studentDao.deleteStudent(oldId);
			Student student3 = new Student(oldId, namee, cityy);
			studentDao.insert(student3);
			System.out.println("one row updated");
			break;
        	
        	
        case 6:
        	//exit
        	 go=false;
        	break;
        }
			
		} catch (Exception e) {
			System.out.println("Invalid input....!Choose the right option,");
			System.out.println(e.getMessage());
		}
        
        }
    	 
         
    }
}
