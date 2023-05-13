package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_1049 {

	// * 백준1049 기타줄 * //

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int six = Integer.MAX_VALUE;
		int one = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			six = Math.min(six, Integer.parseInt(st.nextToken()));
			one = Math.min(one, Integer.parseInt(st.nextToken()));
		}

		if (six > one * 6) {
			System.out.println(N * one);
			return;
		}

		int total = six * (N / 6);
		total += Math.min(N % 6 * one, six);
		System.out.println(total);

	}

}