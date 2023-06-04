package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class BJ_1446 {

	// * 백준1446 지름길 * //

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		ArrayList<Road> list = new ArrayList<>();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			if (end > D)
				continue;
			if (end - start <= value)
				continue;

			list.add(new Road(start, end, value));

		}

		Collections.sort(list, new Comparator<Road>() {
			public int compare(BJ_1446.Road o1, BJ_1446.Road o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});

		int idx = 0, move = 0;
		int[] dist = new int[10001];
		Arrays.fill(dist, 10001);
		dist[0] = 0;

		while (move < D) {
			if (idx < list.size()) {
				Road r = list.get(idx);
				if (move == r.start) {
					dist[r.end] = Math.min(dist[move] + r.value, dist[r.end]);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
					move++;
				}

			} else {
				dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
				move++;
			}
		}
		System.out.println(dist[D]);

	}

	static class Road {

		int start;
		int end;
		int value;

		public Road(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
	}

}