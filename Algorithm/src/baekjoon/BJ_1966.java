package baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<Integer>();
		Queue<String> q = new LinkedList<String>();

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			que = new LinkedList<Integer>();
			q = new LinkedList<String>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (j == M) {
					que.add(Integer.parseInt(st.nextToken()));
					q.add("target");
				} else {
					que.add(Integer.parseInt(st.nextToken()));
					q.add("not target");
				}
			}

			int count = 0;
			while (!que.isEmpty()) {
				int max = Collections.max(que);

				int val = que.poll();
				String tar = q.poll();

				if (val == max && tar.equals("target")) {
					count ++;
					System.out.println(count);
					break;
				} else if (val == max) {
					count++;
				} else {
					que.add(val);
					q.add(tar);
				}
			}
		}

	}

}
