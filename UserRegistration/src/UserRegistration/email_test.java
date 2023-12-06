package UserRegistration;

import static org.junit.Assert.*;

import org.junit.Test;

public class email_test {

	@Test
	public void vaid_test() 
	{
		User user = new User();
		
		String[] test_validemails = {
	            "abc@yahoo.com",
	            "abc-100@yahoo.com",
	            "abc.100@yahoo.com",
	            "abc111@abc.com",
	            "abc-100@abc.net",
	            "abc.100@abc.com.au",
	            "abc@1.com",
	            "abc@gmail.com.com",
	            "abc+100@gmail.com"
	    };
		
		for(String testemail:test_validemails)
		{
			 user.email= testemail;
			
			 try {
				  user.validateEmail();
		        } catch (InvalidUserDetailsException e) {
		            fail("Expected ValidUserDetailsException but got InvalidUserDetailsException");
		        } catch (ValidUserDetailsException e) {
		            // This is the expected outcome for valid first emails
		            assertEquals("Valid Email", e.getMessage());
		        }
		}
		
	}
	
	
    @Test
    
	public void invaid_test() 
	{
		User user = new User();
		String[] test_invalidemails = {
	            "abcd",
	            "abc@.com.my",
	            "abc123@.com",
	            "abc123@gmail.a",               
	            "abc123@.com.com",
				".abc@abc.com", 
				"abc()*@gmail.com", 
				"abc@%*.com", 
				"abc..2002@gmail.com",
				 "abc.@gmail.com",
				 "abc@abc@gmail.com", 
				"abc@gmail.com.1a",
				 "abc@gmail.com.aa.au"
	    };
		for(String testemail:test_invalidemails)
		{
			 user.email= testemail;
			 try {
				  user.validateEmail();
		        } catch (ValidUserDetailsException e) {
		            fail("Expected InvalidUserDetailsException but got ValidUserDetailsException");
		        } catch (InvalidUserDetailsException e) {
		            // This is the expected outcome for valid first emails
		            assertEquals("Invalid Email", e.getMessage());
		        }
		}
		
	}

}
