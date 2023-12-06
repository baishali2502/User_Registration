package UserRegistration;

import static org.junit.Assert.*;

import org.junit.Test;

public class lastname_test {

	@Test
	public void testValidLastNames() 
	{
		User user = new User();
		String[] testdata ={"John","Alice","Bob"};
		for(String testname:testdata)
		{
			user.lastName = testname;
			try {
	            user.validateLastName();
	        } catch (InvalidUserDetailsException e) {
	            fail("Expected ValidFirstNameException but got InvalidFirstNameException");
	        } catch (ValidUserDetailsException e) {
	            // This is the expected outcome for valid first names
	            assertEquals("Valid Last Name", e.getMessage());
	        }
		}
	}
	@Test
	public void testInValidLastNames() 
	{
		User user = new User();
		String[] testdata ={"a","Ab","john","123","@Name"};
		for(String testname:testdata)
		{
			user.lastName = testname;
			try {
	            user.validateLastName();
	            fail("Expected InvalidFirstNameException but got no exception");
	        } catch (InvalidUserDetailsException e) {
	            // This is the expected outcome for invalid first names
	            assertEquals("Invalid Last Name", e.getMessage());
	        } catch (ValidUserDetailsException e) {
	            fail("Expected InvalidFirstNameException but got ValidFirstNameException");
	        }
		}
	}

}
