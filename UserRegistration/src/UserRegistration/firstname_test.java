package UserRegistration;

import static org.junit.Assert.*;

import org.junit.Test;

public class firstname_test {
	@Test
	public void testValidFirstNames() 
	{
	    User user = new User();
	    String[] testdata = {"John", "Alice", "Bob"};
	    for (String testname : testdata) {
	        user.firstName = testname;
	        try {
	            user.validateFisrtName();
	        } catch (InvalidUserDetailsException e) {
	            fail("Expected ValidFirstNameException but got InvalidFirstNameException");
	        } catch (ValidUserDetailsException e) {
	            // This is the expected outcome for valid first names
	            assertEquals("Valid First Name", e.getMessage());
	        }
	    }
	}

	@Test
	public void testInValidFirstNames() 
	{
	    User user = new User();
	    String[] testdata = {"a", "Ab", "john", "123", "@Name"};
	    for (String testname : testdata) {
	        user.firstName = testname;
	        try {
	            user.validateFisrtName();
	            fail("Expected InvalidFirstNameException but got no exception");
	        } catch (InvalidUserDetailsException e) {
	            // This is the expected outcome for invalid first names
	            assertEquals("Invalid First Name", e.getMessage());
	        } catch (ValidUserDetailsException e) {
	            fail("Expected InvalidFirstNameException but got ValidFirstNameException");
	        }
	    }
	}
}
