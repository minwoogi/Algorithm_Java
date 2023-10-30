package programmers;

import java.util.Arrays;

public class 정수삼각형 {
	class Solution {
		
		// 나의 풀이 
		public int solution(int[][] triangle) {
			int answer = 0;

			int height = triangle.length;

			if (height == 1) {
				return triangle[0][0];
			}

			if (height == 2) {
				return Math.max(triangle[1][0] + triangle[0][0], triangle[1][1] + triangle[0][0]);
			}

			int[][] dp = new int[height][height];
			dp[0][0] = triangle[0][0];
			dp[1][0] = dp[0][0] + triangle[1][0];
			dp[1][1] = dp[0][0] + triangle[1][1];

			for (int i = 2; i < height; i++) {
				dp[i][0] = dp[i - 1][0] + triangle[i][0];
				dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
			}

			for (int i = 2; i < height; i++) {
				for (int j = 1; j < i; j++) {
					dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
				}
			}

			for (int i = 0; i < height; i++) {
				answer = Math.max(dp[height - 1][i], answer);
			}

			return answer;
		}
	}

	
	// best 풀이 
	class Best {

		public int solution(int[][] triangle) {
			for (int i = 1; i < triangle.length; i++) {
				triangle[i][0] += triangle[i - 1][0];
				triangle[i][i] += triangle[i - 1][i - 1];
				for (int j = 1; j < i; j++)
					triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
			}

			return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
		}

	}

}
