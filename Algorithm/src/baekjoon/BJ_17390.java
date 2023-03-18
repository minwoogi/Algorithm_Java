package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ_17390 {

	// * 백준17390 // 알고리즘 분류 : 누적합 * //

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[Integer.parseInt(st.nextToken()) + 1];
		int quiz = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] sum = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < quiz; i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			sb.append(sum[R] - sum[L - 1] + "\n");
		}

		System.out.print(sb);

	}

}