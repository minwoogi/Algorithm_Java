package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ_21921 {

	// * 백준21921 // 알고리즘 분류 : 누적합 * //

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sum = new int[N + 1];

		for (int i = 1; i < arr.length; i++) {
			sum[i] = arr[i] + sum[i - 1];
		}

		int max = Integer.MIN_VALUE;
		for (int i = X; i < arr.length; i++) {
			max = Math.max(sum[i] - sum[i - X], max);
		}

		int count = 0;

		for (int i = X; i < arr.length; i++) {
			if (max == sum[i] - sum[i - X])
				count++;
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}

	}

}