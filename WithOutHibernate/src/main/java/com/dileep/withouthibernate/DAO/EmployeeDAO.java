package com.dileep.withouthibernate.DAO;

import com.dileep.withouthibernate.Configuration.MySqlConfig;
import com.dileep.withouthibernate.Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeDAO {

    // Insert employee
    public void saveEmployee(Employee emp) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySqlConfig.getConnection();
            String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(stmt, conn);
        }
    }

    // Select employee by ID
    public Employee getEmployeeById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Employee emp = null;

        try {
            conn = MySqlConfig.getConnection();
            String sql = "SELECT * FROM employee WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setSalary(rs.getDouble("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(rs, stmt, conn);
        }
        return emp;
    }

    // Update employee
    public void updateEmployee(Employee emp) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySqlConfig.getConnection();
            String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getName());
            stmt.setDouble(2, emp.getSalary());
            stmt.setInt(3, emp.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(stmt, conn);
        }
    }

    // Delete employee
    public void deleteEmployee(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = MySqlConfig.getConnection();
            String sql = "DELETE FROM employee WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(stmt, conn);
        }
    }

    // Utility methods for closing resources
    // for suppose if we don't close the resources ,it can lead to following problems
    // Memory leaks, Connection leaks, Exhaustion of database connections, Slower application performance, Potential application crash under load
    private void closeResources(PreparedStatement stmt, Connection conn) {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeResources(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
