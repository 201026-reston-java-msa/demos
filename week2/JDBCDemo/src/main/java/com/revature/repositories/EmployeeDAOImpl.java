package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);
	
	public List<Employee> findAll() {
		
		List<Employee> list = new ArrayList<Employee>();
		List<Integer> supervisors = new ArrayList<Integer>();
		
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
		
		// We need to create a String that will pass a SQL command to our database MS
		// The following String represents the SQL that we will execute in our DB:
			String sql = "SELECT * FROM employee;";
		
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			/*
			 * ResultSet starts at 1 position behind the starting point
			 * of our data...So, in order to  access the first value, we invoke
			 * next() to start....
			 */
			while(rs.next()) {
				int id = rs.getInt("emp_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				double salary = rs.getDouble("salary");
				
				Employee e = new Employee(id, first_name, last_name, email, salary, null);
				int sup_id = rs.getInt("supervisor");
				
				list.add(e);
				supervisors.add(sup_id);
			}
			rs.close();
		} catch (SQLException e) {
			log.warn("Unable to retrieve employees from the db");
		}
		
		for (int i=0; i< list.size(); i++) {
			int sup_id = supervisors.get(i);
			
			// Find employee that matches the supervisor ID
			for(Employee e: list) {
				if (e.getId() == sup_id) {
					list.get(i).setSupervisor(e);
				}
			}
		}		
		return list;
	}

	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(Employee e) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			/*
			 * This String represents the SQL which we will execute in our DB
			 * We use ?'s as PLACE HOLDERS which we can insert values from Java
			 * using PreparedStatements...
			 * 
			 * "DROP SCHEMA CASCADE;" ENTERED AS A VALUE FOR EXAMPLE WOULD BE AN
			 * EXAMPLE OF SQL INJECTION!!!!! You really mess them up...
			 */
			String sql = "INSERT INTO employee (first_name, last_name, email, salary, supervisor)" +
			"VALUES (?, ?, ?, ?, ?)";
			
			// This PreparedStatement object is a wrapper around our SQL string
			// this is obtained through the connection to the DB and allows us to
			// insert INTO our placeholders...
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setString(3, e.getEmail());
			stmt.setDouble(4, e.getSalary());
			Employee sup = e.getSupervisor();
			
			// extr logic for handling the Supervisor Object:
			if (sup != null) {
				stmt.setInt(5, sup.getId());
			} else {
				stmt.setNull(5, java.sql.Types.NULL);
			}
			
			if(!stmt.execute()) {
				return false;
			}

		} catch (SQLException ex) {
			log.warn("Unable to insert user", ex);
			return false;
		}		
		return true;
	}

	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
