package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.services.EmployeeService;

/*
 * Most of the classes we're testing deletaget the work to other methods in other classes (like the DAO)
 */
public class EmployeeServiceTest {

	// @Mock will create a mock implementation for the EmployeeDaoImpl
	@Mock
	private EmployeeDAOImpl daoMock;
	
	// @InjectMocks will inject the mocks marked with @Mock to this instance when it is created
	@InjectMocks
	private EmployeeService service;
	
	@Before
	public void setUp() throws Exception {
		
		/*
		 * These instances would be created at the start of every test method in this class
		 */
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void testAddEmployee_returnTrue() {
		
		Employee employee = Mockito.mock(Employee.class);
		
		when(daoMock.insert(employee)).thenReturn(true);
		
		assertEquals(service.addEmployee(employee), true);
		
	}
	
	/* The When - Then pattern" 
	 * When is a static method of the Mockito class and it returns 
	 * OnGoingStubbing<T> (T is the return tupe of the method that we're mocking)
	 * 
	 * The following are methods that you can call on this stub:
	 * 
	 * - thenReturn(returnValue)
	 * - thenThrow(exception)
	 * - thenCallRealMethod()
	 * - thenAnswer() - this can be used to set up more complex/smarter stubs and mock behavior of the methods
	 * 
	 */
	
	@Test(expected = NullPointerException.class) // use attribute and assign to expected Exception to be thrown
	public void whenExceptionThrown_theExceptionIsSatisfied() {
		String word = null;
		
		// this automatically results in an Exception
		word.length();
	}
	
	@Rule 
	public ExpectedException e = ExpectedException.none();
	
	@Test
	public void testArithmetic() {
		int i = 1/0;
	}
}















