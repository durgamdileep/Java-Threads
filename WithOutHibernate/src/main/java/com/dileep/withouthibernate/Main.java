package com.dileep.withouthibernate;

import com.dileep.withouthibernate.DAO.EmployeeDAO;
import com.dileep.withouthibernate.Model.Employee;

import java.sql.*;

public class Main {
    public static  void main(String[] args) throws ClassNotFoundException, SQLException {

        Employee obj= new Employee();
        obj.setId(123);
        obj.setName("Madhu");
        obj.setSalary(1000000.00);

        
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/withouthibernate_db";
        Connection con = DriverManager.getConnection(url, "root", "root");
        Statement stmt = con.createStatement();
        String query = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, obj.getId());
        pstmt.setString(2, obj.getName());
        pstmt.setDouble(3, obj.getSalary());

        pstmt.executeUpdate();
        pstmt.close();
        con.close();



//        EmployeeDAO employeeDAO= new EmployeeDAO();
//
//        //storing an employee info into DB
//        // storing first employee info
//        Employee employee = new Employee(1,"Virat",124.95);
//        employeeDAO.saveEmployee(employee);
//
//        // second employee info
//        employee= new Employee(2,"ABD",136.78);
//        employeeDAO.saveEmployee(employee);
//
//
//        // Getting the employee information
//        Employee displayingEmployee = employeeDAO.getEmployeeById(employee.getId());
//        System.out.println(displayingEmployee.toString());
//
//        // updating the existing employee info
//        Employee updatedEmployeeInfo = employeeDAO.getEmployeeById(1);
//        updatedEmployeeInfo.setName("VK");
//        employeeDAO.updateEmployee(updatedEmployeeInfo);
//
//        //deleting the employee info
//        employeeDAO.deleteEmployee(2);

    }
}
