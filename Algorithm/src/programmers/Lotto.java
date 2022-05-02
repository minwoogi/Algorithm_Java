package programmers;
import java.util.Arrays;

public class Lotto {

	/**
	 * Created by minwoogi on 2022/05/02 로또의 최고 순위와 최저 순위
	 * https://programmers.co.kr/learn/courses/30/lessons/77484
	 */

	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		System.out.println(Arrays.toString(new Solution().solution(lottos, win_nums)));

	}

	static class Solution {
		public int[] solution(int[] lottos, int[] win_nums) {
			int maxCount = 0;
			int minCount = 0;
			for (int i = 0; i < lottos.length; i++) {
				if (lottos[i] == 0) {
					maxCount++;
					continue;
				}
				for (int j = 0; j < lottos.length; j++) {
					if (lottos[i] == win_nums[j]) {
						maxCount++;
						minCount++;
					}
				}
			}
			if (minCount == 0) {
				minCount = 1;
			}
			if (maxCount == 0) {
				maxCount = 1;
			}
			int[] answer = new int[2];
			answer[0] = 7 - maxCount;
			answer[1] = 7 - minCount;
			return answer;
		}
	}

}
