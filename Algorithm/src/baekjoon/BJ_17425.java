package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_17425 {

	// * 백준17425 약수의합 알고리즘 분류 : 누적합 * //

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		long[] fx = new long[1000001];
		long[] prefixSum = new long[1000001];

		Arrays.fill(fx, 1);
		for (int i = 2; i < fx.length; i++) {
			for (int j = 1; j * i < fx.length; j++) {
				fx[i * j] += i;
			}
		}

		for (int i = 1; i < prefixSum.length; i++) {

			prefixSum[i] += prefixSum[i - 1] + fx[i];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= T; i++) {

			sb.append(prefixSum[Integer.parseInt(br.readLine())] + "\n");
		}

		System.out.print(sb);

	}

}
