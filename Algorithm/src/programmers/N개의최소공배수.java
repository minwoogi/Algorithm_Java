package programmers;

public class N개의최소공배수 {
	
	
	/*
	 * 
	 * 유클리드 호재법
	 * gcd(최대 공약수)
	 * lcm(최소 공배수)
	 * 
	 */

	class Solution {

		public int solution(int[] arr) {
			int answer = arr[0];

			for (int i = 1; i < arr.length; i++) {
				answer = lcm(answer, arr[i]);
			}

			return answer;
		}

		public int gcd(int a, int b) {
			if (a % b == 0) {
				return b;
			}

			return gcd(b, a % b);
		}

		public int lcm(int a, int b) {
			return a * b / gcd(a, b);
		}
	}

}
