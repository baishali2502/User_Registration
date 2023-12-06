package UserRegistration;

import static org.junit.Assert.*;

import org.junit.Test;

public class phone_test {
	@Test
	public void testValidPhoneNumbers() throws ValidUserDetailsException, InvalidUserDetailsException{
		User user = new User();
		String[] testmobile = {"91 9919819801", "44 9876543210", "33 1234567890"};
		
		for(String test_mobilenos:testmobile)
		{
			user.phone=test_mobilenos;
			try {
	            user.validatePhone();
	        } catch (InvalidUserDetailsException e) {
	            fail("Expected ValidUserDetailsException but got InvalidUserDetailsException");
	        } catch (ValidUserDetailsException e) {
	            // This is the expected outcome for valid first names
	            assertEquals("Valid Phone Number", e.getMessage());
	        }
			
		}
	}
	
	@Test
	public void testInValidPhoneNumbers() throws ValidUserDetailsException, InvalidUserDetailsException{
		User user = new User();
		String[] testmobile = {"1234567890", "1 123456789", "12 12345678901","AB 1234567890","91 12345A7890"};
		
		for(String test_mobilenos:testmobile)
		{
			user.phone=test_mobilenos;
			try {
				user.validatePhone();
	            fail("Expected InvalidFirstNameException but got no exception");
	        } catch (InvalidUserDetailsException e) {
	            // This is the expected outcome for invalid phone nos.
	            assertEquals("Invalid Phone Number", e.getMessage());
	        } catch (ValidUserDetailsException e) {
	            fail("Expected InvalidFirstNameException but got ValidFirstNameException");
	        }
		}
	}

}
