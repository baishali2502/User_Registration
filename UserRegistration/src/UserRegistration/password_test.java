package UserRegistration;

import static org.junit.Assert.*;

import org.junit.Test;

public class password_test {

	@Test
	public void testValidPasswords() {
		User user = new User();
		String[] validPasswords = {"StrongPwd1!", "Secure@2023", "P@ssw0rd"};
		
		for(String test_password:validPasswords)
		{
			user.password=test_password;
			try {
	            user.validatePassword();
	        } catch (InvalidUserDetailsException e) {
	            fail("Expected ValidFirstNameException but got InvalidFirstNameException");
	        } catch (ValidUserDetailsException e) {
	            // This is the expected outcome for valid passwords
	            assertEquals("Valid Password", e.getMessage());
	        }
		}
	}
	@Test
	public void testInvalidPasswords() {
		User user = new User();
		String[] invalidPasswords = {"weakpwd", "MissingDigit@", "NoUpperCase123", "Short!1"};
		
		for(String test_password:invalidPasswords)
		{
			user.password=test_password;
			try {
				 user.validatePassword();
	            fail("Expected InvalidPasswordException but got no exception");
	        } catch (InvalidUserDetailsException e) {
	            // This is the expected outcome for invalid password
	            assertEquals("Invalid Password", e.getMessage());
	        } catch (ValidUserDetailsException e) {
	            fail("Expected InvalidPasswordException but got ValidPasswordException");
	        }
		}
	}

}
