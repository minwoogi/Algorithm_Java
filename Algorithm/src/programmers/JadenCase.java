package programmers;

public class JadenCase {

	class Solution {
	    public String solution(String s) {
	        
	        
			String[] arr = s.split(" ");

			String answer = "";

			for (String str : arr) {
				if (str.length() == 0)
					answer += " ";
				else {
					answer += (str.charAt(0) + "").toUpperCase();
					answer += str.substring(1, str.length()).toLowerCase();
					answer += " ";
				}
			}
			
			if(s.substring(s.length()-1, s.length()).equals(" ")){
	    		return answer;
	    	}
	    	
	        return answer.substring(0, answer.length()-1);
	    }
	}

}
