package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class BJ_9465 {

	// * 백준9465 스티커 * //

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][n + 1];
			int[][] dp = new int[2][n + 1];

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int a = 2; a <= n; a++) {
				dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
				dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
			}

			bw.write(Math.max(dp[1][n], dp[0][n]) + "\n");
		}

		bw.flush();

	}

}
