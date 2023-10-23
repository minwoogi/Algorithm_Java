package programmers;

public class 이진변환반복하기 {

	class Solution {
		public int[] solution(String s) {
			int[] answer = { 0, 0 };

			while (!(s.length() == 1)) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '0') {
						answer[1] += 1;
					}
				}

				s = s.replace("0", "");

				s = Integer.toBinaryString(s.length());
				answer[0] += 1;
			}
			return answer;
		}
	}
}
