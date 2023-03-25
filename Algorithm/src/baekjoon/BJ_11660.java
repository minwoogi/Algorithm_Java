package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ_11660 {

	// * 백준11660 구간 합 구하기5 // 알고리즘 분류 : 누적합 * //

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 표의 크기 NxN
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

		int[][] prefixSum = new int[N + 1][N + 1];

		for (int i = 1; i < prefixSum.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < prefixSum.length; j++) {
				int val = Integer.parseInt(st.nextToken());
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + val;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sb.append(prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1]
					+ "\n");
		}

		System.out.print(sb);

	}

}