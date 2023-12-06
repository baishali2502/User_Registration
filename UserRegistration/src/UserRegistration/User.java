package UserRegistration;

import java.util.regex.*;

public class User 
{
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	
	/*
	 * @desc:This method checks whether a valid firstname is entered or not
	 * 
	 * @params:none
	 * 
	 * @returns:boolean
	 */
	
	public void validateFisrtName()throws InvalidUserDetailsException,ValidUserDetailsException {

		/*
		 * First name starts with Cap and has minimum 3 characters
		 */
        String regex = "^[A-Z][a-zA-Z]{2,}$";

        //compile the regular expression
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(firstName);

        if (!matcher.matches()) {
            throw new InvalidUserDetailsException("Invalid First Name");
        }else
        {
        	throw new ValidUserDetailsException("Valid First Name");
        }
    }
	
}
class InvalidUserDetailsException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public InvalidUserDetailsException(String message) {
        super(message);
    }
}
class ValidUserDetailsException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public ValidUserDetailsException(String message) {
        super(message);
    }
}
