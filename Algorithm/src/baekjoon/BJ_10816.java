package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_10816 {

	// * 백준10816 숫자 카드2 * //

	public static void main(String[] args) throws IOException {

		HashMap<Integer, Integer> map = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (map.containsKey(a)) {
				sb.append(map.get(a) + " ");
			} else {
				sb.append("0 ");
			}
		}
		System.out.print(sb);

	}

}
