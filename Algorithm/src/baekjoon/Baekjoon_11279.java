package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baekjoon_11279 {

	// * 백준11279 최대 힙 * //

	public static void main(String[] args) throws IOException {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(pq.size() == 0 ? "0\n" : pq.poll() + "\n");
			} else {
				pq.add(x);
			}
		}
		System.out.println(sb);

	}

}
