package programmers;

import java.util.Arrays;

public class 가장큰수 {
	
	/*
	 *  stream을 이용해  int[] to String[]
	 *  
	 *  compareTo()를 이용해 문자열 비교 연산 
	 * 
	 */

	class Solution {
		public String solution(int[] numbers) {
			String[] arr = Arrays.stream(numbers).mapToObj(Integer::toString).toArray(String[]::new);

			Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

			if (arr[0].equals("0")) {
				return "0";
			}

			StringBuilder answer = new StringBuilder();

			for (int i = 0; i < arr.length; i++) {
				answer.append(arr[i]);
			}

			return answer.toString();
		}
	}

}
