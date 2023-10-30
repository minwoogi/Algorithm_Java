package programmers;

public class 카펫 {
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        for(int i=1; i<= yellow; i++){
	            if(yellow%i == 0){
	                if(  i*2 + (yellow/i)*2 + 4  == brown){
	                    return new int[]{ (yellow/i)+2,i+2};
	                }
	            }
	        }
	        return null;
	    }
	}
}
