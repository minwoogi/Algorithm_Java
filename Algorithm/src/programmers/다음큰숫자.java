package programmers;

public class 다음큰숫자 {

	class Solution {
		public int solution(int n) {

			int cnt = Integer.bitCount(n);

			boolean flag = true;
			while (flag) {
				n++;
				if (cnt == Integer.bitCount(n)) {
					flag = false;
				}
			}
			return n;
		}
	}

}
