package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815 {

	// * 백준10815 숫자 카드 * //

	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(Integer.parseInt(st.nextToken())) + " ");
		}
		System.out.println(sb);

	}

	public static int binarySearch(int num) {

		int low = 0;
		int high = N - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == num) {
				return 1;
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return 0;
	}

}
