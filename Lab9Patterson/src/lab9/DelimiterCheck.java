package lab9;

	public class DelimiterCheck {

	
	//Strings {missingLeft, missingRight, not matching}
		
	static String[] toBeChecked = { "j(k)l", "a[b(c)d", "c(d[e]f)g", "c(d}e", "a(d{ed)a"
			, "a(b{c}c)d)"};
	

	static DelimiterCheck checker = new DelimiterCheck();
	
	public static void main(String[] args) {
		
		//checker.check(toBeChecked[1]);
		
		
		for (int i=0; i<toBeChecked.length; i++) {
		
			checker.check(toBeChecked[i]);
			System.out.println();
		
		}
		
	
		
		
	}
	
	
	
	
	

	public boolean check(String s) {
		char[] openDelimiters = { '(', '[', '{' };
		char[] closeDelimiters = { ')', ']', '}' };
		
		StackX myStack = new StackX(s.length());
		
		
		//traverse thru string being checked char by char
		for (int i=0; i<s.length(); i++) {
			
			
			//see open delimiter, push to stack
			for (int j=0; j<openDelimiters.length; j++) {
				if (s.charAt(i) == openDelimiters[j]) {
					myStack.push(s.charAt(i));
				}
			}
			
			//see closing delimiter, pop the matching open delimeter from stack
			for (int j=0; j<closeDelimiters.length; j++) {
				if (s.charAt(i) == closeDelimiters[j]) {		// char is close delimitier
					
					
						if (!myStack.isEmpty() && myStack.peek() != openDelimiters[j]) {
							System.out.println(s + "\nMatching error!");
							return false;
						}
						
						else {	
							if (!myStack.isEmpty()) {
								myStack.pop();		//they match
							}
							else {
								System.out.println(s + "\nMissing LEFT delimiter!");
								return false;
							}
						}
			}
		}
			
		}
			
			//finished traversing string with no issues:
		
		if (!myStack.isEmpty()) {
			System.out.println(s + "\nMissing RIGHT delimiter error!");
			return false;
		}
		
		System.out.println("Hip hip hooray!\n" + s + " is a clean string!");

		return true;
		}
		
		//if they don't match report a MATCHING error
		//if can't pop because stack empty, report missing left delimiter error
		//missing right delimeter error
		
	}
	
	
	