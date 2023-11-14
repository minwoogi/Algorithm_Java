package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주마시면서걸어가기 {

    static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int cu = Integer.parseInt(br.readLine());
			ArrayList<Point> ps = new ArrayList<>();
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

			for (int i = 0; i < cu + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				ps.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			for (int i = 0; i < cu + 2; i++) {
				graph.add(new ArrayList<Integer>());
			}

			for (int i = 0; i < cu + 2; i++) {
				for (int j = i + 1; j < cu + 2; j++) {
					if (Manhattan(ps.get(i), ps.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			sb.append((bfs(graph, cu) ? "happy" : "sad") + '\n');

		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

	public static int Manhattan(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

	public static boolean bfs(ArrayList<ArrayList<Integer>> graph, int N) {

		Queue<Integer> que = new LinkedList<>();
		que.offer(0);

		boolean[] visited = new boolean[N + 2];
		visited[0] = true;

		while (!que.isEmpty()) {

			int now = que.poll();

			if (now == N + 1) {
				return true;
			}

			for (int next : graph.get(now)) {
				if (!visited[next]) {
					visited[next] = true;
					que.offer(next);
				}
			}

		}

		return false;

	}

	static class Point {

		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}


}
