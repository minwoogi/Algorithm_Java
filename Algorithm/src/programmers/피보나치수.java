package programmers;

public class 피보나치수 {	
	class Solution {
	    public int solution(int n) {
	        
	        if(n ==2){
	            return 1;
	        }
	        
	        long[] sum = new long[n+1];
	        sum[1] = 1L;
	        sum[2] = 1L;
	        for(int i=3; i<=n; i++){
	            sum[i] = (sum[i-1] + sum[i-2]) %1234567L;
	        }
	        
	        int answer = (int)sum[n];
	        return answer;
	    }
	}
}
