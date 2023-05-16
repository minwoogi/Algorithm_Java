package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_2212 {

	// * 백준2212 센서 * //

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		if (K >= N) {
			System.out.println(0);
			return;
		}

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		Integer[] sub = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			sub[i] = arr[i + 1] - arr[i];
		}

		Arrays.sort(sub, Collections.reverseOrder());

		int sum = 0;
		for (int i = K - 1; i < N - 1; i++) {
			sum += sub[i];
		}

		System.out.println(sum);

	}

}
