package UserRegistration;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		    System.out.println("WELCOME TO USER REGISTRATION PORTAL");
		    
		    User user = new User();// creating object of user class
		    
		    user.firstName = "KaTe";
		    user.lastName = "Williams";
		    user.password = "Katty123@";
		    user.phone = "91 3284739372";
		    user.email = "abc@gmail.com.aa.au";
		    //validate firstname
		    try {
		    	user.validateFisrtName();
		    }catch(ValidUserDetailsException e)
		    {
		    	System.out.println(e.getMessage());
		    }catch(InvalidUserDetailsException e) {
		    	System.out.println(e.getMessage());
		    }
		    //validate lastname
		    try {
		    	user.validateLastName();
		    }catch(ValidUserDetailsException e)
		    {
		    	System.out.println(e.getMessage());
		    }catch(InvalidUserDetailsException e) {
		    	System.out.println(e.getMessage());
		    }
		  //validate password
		    try {
		    	user.validatePassword();
		    }catch(ValidUserDetailsException e)
		    {
		    	System.out.println(e.getMessage());
		    }catch(InvalidUserDetailsException e) {
		    	System.out.println(e.getMessage());
		    }
		    //validate phone
		    try {
		    	user.validatePhone();
		    }catch(ValidUserDetailsException e)
		    {
		    	System.out.println(e.getMessage());
		    }catch(InvalidUserDetailsException e) {
		    	System.out.println(e.getMessage());
		    }
		  //validate email
		    try {
		    	user.validateEmail();
		    }catch(ValidUserDetailsException e)
		    {
		    	System.out.println("Valid email");
		    }catch(InvalidUserDetailsException e) {
		    	System.out.println("Invalid email");
		    }

	}

}
