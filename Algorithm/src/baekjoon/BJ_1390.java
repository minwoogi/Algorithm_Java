package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1390 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row - 1][col - 1] = 2;
		}
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, String> map = new HashMap<>();
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			map.put(X, C);
		}

		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(0, 0));
		int x = 0;
		int y = 0;
		int time = 0;
		String[] C = { "E", "S", "W", "N" };
		int d = 0;
		board[0][0] = 1;

		while (true) {
			time++;
			if (C[d] == "N") {
				x--;
			} else if (C[d] == "E") {
				y++;
			} else if (C[d] == "S") {
				x++;
			} else if (C[d] == "W") {
				y--;
			}
			que.add(new Point(x, y));

			if (x < 0 || x >= N || y < 0 || y >= N) {
				break;
			}
			if (board[x][y] == 1) {
				break;
			} else if (board[x][y] == 0) {
				Point p = que.poll();
				board[p.x][p.y] = 0;
			}
			board[x][y] = 1;
			if (map.getOrDefault(time, "X").equals("L")) {
				d--;
				if (d == -1) {
					d = 3;
				}
			} else if (map.getOrDefault(time, "X").equals("D")) {
				d++;
				if (d == 4) {
					d = 0;
				}
			}

		}

		System.out.println(time);

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
