package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10986 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long count = 0;
		long[] prefixSum = new long[N + 1];
		long[] cnt = new long[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			prefixSum[i] = (prefixSum[i - 1] + Integer.parseInt(st.nextToken())) % M;
			if (prefixSum[i] == 0) {
				count++;
			}

			cnt[(int) prefixSum[i]]++;
		}

		for (int i = 0; i < M; i++) {
			if (cnt[i] > 1) {
				count += (cnt[i] * (cnt[i] - 1) / 2);
			}
		}
		System.out.println(count);

	}

}
