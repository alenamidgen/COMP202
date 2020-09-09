//By Alena Midgen 
public class EmailValidation {

	public static void main(String[] args) {
		
	
	}
	//this method determines wheather a character is alphanumeric
	public static boolean isAlphanumeric(char input) {
		
		//the if statement starts by checking weather the character is between 'a' and 'z'
		if ((input>= 'a')&& (input<= 'z')) {
			return true;
			
		//it then checks to see if it is in the uppercase alphabet	
		} else if ((input >= 'A') && (input <= 'Z')) {
			return true;
			
		//finally, it checks if it is a digit between 0 and 9	
		} else if ((input >='0') && (input<='9')) {
			return true;
		
		// if none of the above are true, the method returns false for the character being alphanumeric	
		} else {
			return false;
		}
		
	}

	//this method checks if a given character is valid to be in the prefix of an email
	public static boolean isValidPrefixChar(char prefixChar) {
		
		//the first if statement checks if the character is a period, dash or underscore, if so, it returns that it is valid to be in a prefix
		if ((prefixChar == '.') || (prefixChar == '-') || (prefixChar == '_')) {
			return true;
		
		//the second if statement checks to see if the character is alphanumeric by calling the previous method and using the character as input	
		} else if (isAlphanumeric(prefixChar) == true) {
			return true;
		
		// if the conditions of the previous if statements were both not met, then the character is not valid to be in a prefix	
		} else {
			return false; 
		}
	}
	
	//this method checks to see if a given character is valid to be in a domain
	public static boolean isValidDomainChar(char domainChar) {
		
		// the first if statement checks to see if the character is a period or dash, both of which being valid for a domain
		if ((domainChar == '.') || (domainChar == '-')) {
			return true;
	
		// second, it calls the isAlphanumeric method using the character as input, if it is true, the character is valid to be in a domain	
		} else if (isAlphanumeric(domainChar) == true) {
			return true;
			
		// finally, if the code is run this far, the character must not be able to belong in a domain	
		} else {
			return false;
		}
	}
	 
	// this method tests to see if a proposed email address has only one @ symbol
	public static boolean exactlyOneAt(String emailAddress) {
		
		//the variables correspoding to the length of the email address and the number of @ symbols found are stored as integer variables
		int length = emailAddress.length();
		int counter = 0;
		
		//the program loops through the string, with the counter variable increasing by one for every @ symbol
		for (int index = 0; index <= length - 1; index++) {
			if (emailAddress.charAt(index) == '@') {
				counter++;
			}
		}
		
		//if the count of the @ symbols is 1, the method returns true
		if (counter == 1) {
			return true;
	 
		//otherwise, the method returns false	
		} else {
			return false;
		}
	}		
	
	
	//this method isolates the prefix for a given potential email address
	public static String getPrefix(String emailAddress) {
		
		//the method loops through the string, using charAt to look at each variable, until it reaches the end of the string (found using the length)
		int length = emailAddress.length();
		String prefix= "";
		for (int index=0; index <= length-1; index++) {
			
			// when the loop encounters the @ symbol, it returns the prefix it rebuilt
			if(emailAddress.charAt(index) == '@') {
				return prefix; 
			
			// for every character that isn't the @ symbol, the method adds each to an empty string previously declared
			// these characters are what makes up the prefix which is returned later	
			} else {
				prefix = prefix + emailAddress.charAt(index); 
			}
			
		} 
		return prefix;
			
	}
	
	// this method extracts the domain from a potential email address
	public static String getDomain(String emailAddress) {
		
		// similar to the previous method, it loops through the string adding characters to an empty string
		int length = emailAddress.length();
		String domain = "";
		
		//this time, the loop starts by looking at the last character of the string and works backwards until the @ symbol
		for (int index=(length-1); index >= 0; index --) {
			if (emailAddress.charAt(index)== '@') {
				return domain;
			
			} else {
				// the new character the loop finds is added before the previous ones so the word doesn't come out backwards
				domain = emailAddress.charAt(index) + domain;
			}
			
		}
		return domain;
	}
		
	//this method checks weather a potential prefix is valid
	public static boolean isValidPrefix(String possiblePrefix) {
		int length = possiblePrefix.length();
		
		//returns false if the length isn't at least 1
		if (length < 1) {
			return false;
		}
		
		//if the first character of the string is not alphanumeric, the string is not a valid prefix
		if (isAlphanumeric(possiblePrefix.charAt(0)) == false){
			return false;
		}
		
		//the method loops through the string, checking to ensure that each character is a valid to be in a prefix using the previous method
		for (int index = 0; index <= length-1; index++) {
			if (isValidPrefixChar(possiblePrefix.charAt(index))== false) {
				return false;
			
			// this if statement shows that if the character at a position is a period, dash or underscore and the following character is not alphanumeric, the string isn't a valid prefix
			}else if ((possiblePrefix.charAt(index) == '.' || possiblePrefix.charAt(index)== '-'|| possiblePrefix.charAt(index) == '_') && isAlphanumeric(possiblePrefix.charAt(index + 1))== false) {
				return false;
			}
		}
		// if the loop is completed without returning false, then the outcome must be true
		return true;	
	}
	
	// this method checks if a possible domain is valid
	public static boolean isValidDomain(String possibleDomain) {
		
		// the length is found and stored as an integer
		int domainLength = possibleDomain.length();
		
		// empty strings are stored, will later be filled with the first and second parts of the domain
		String secondPart = "";
		String firstPart = "";
		
		if(domainLength < 1) {
			return false;
		}
		
		// the method loops through the string backwards, examining each character and stopping at the first period
		for (int index = domainLength-1; possibleDomain.charAt(index)!='.'; index--) {
				
				// each character the program encounters before the period is added to the empty string representing the second half of the domain
				secondPart= possibleDomain.charAt(index) + secondPart;	
			
				// the progran returns false if any of the characters are not in the lower case alphabet
				if ((possibleDomain.charAt(index) < 'a') || (possibleDomain.charAt(index) > 'z')){
					return false;
			
				// the program also returns false if he loop reaches the beginning of the string, as this would mean it did not encounter a period which splits the domain
				} else if (index == 0) {
				return false;
			}
			
		}
		int secondLength = secondPart.length();
		
		//another  loop is created which examines the characters in the string starting from the beginning and ending before the '.' which splits the first and second parts of the domain
		for(int index = 0; index<= domainLength - secondLength - 2; index ++) {
			
			//the program adds each character to the string so it contains only the first part of the domain
			firstPart = firstPart + possibleDomain.charAt(index);
			
			// this if statement is set up so the program returns false if a character come across in the loop isn't a period, dash or alphanumeric character
			if ((possibleDomain.charAt(index) != '.') && (possibleDomain.charAt(index) != '-') && isAlphanumeric(possibleDomain.charAt(index)) == false ){
				return false;
			
			// this if statement ensure that false is returned if the character following a period or dash isn't alphanumeric	
			} else if ((possibleDomain.charAt(index) == '.' || possibleDomain.charAt(index) == '-') && isAlphanumeric(possibleDomain.charAt(index+1)) == false) {
				return false;
			}
		}
		
		// if the length of the first part of the domain is less than one, the string isn't valid
		int firstLength = firstPart.length();
		
		if (firstLength < 1) {
			return false;
		
		// if the second part is less than two characters, the domain also isn't valid
		} else if (secondLength < 2) {
			return false;
		}
		
		// if the program reaches this point, the domain must be valid
		return true;
	}
	
	// this final method checks to see if an email address is valid
	public static boolean isValidEmail(String possibleEmail) {
		
		// the email address must have exactly one @ symbol, therefore it isn't valid if the method "exactlyOneAt" returns false
		if (exactlyOneAt(possibleEmail)== false) {
			return false;
		
		// the email is also invalid if it doesn't have a valid prefix and domain, which can be checked using the resective methods
		}else if (isValidPrefix(getPrefix(possibleEmail)) == false) {
			return false;
		} else if (isValidDomain(getDomain(possibleEmail)) == false) {
			return false;
		
		// if those three methods all returned true, then the email address must be valid
		} else {
			return true;
		}
			
	}
}