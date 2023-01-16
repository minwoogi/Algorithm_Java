package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_2468 {

	// * 백준2468 안전 영역 * //

	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		int maxHeight = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}

		int count = 0;
		int max = 0;

		for (int i = 0; i <= maxHeight; i++) {
			visit = new boolean[N][N];
			count = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visit[j][k] && map[j][k] > i) {
						bfs(j, k, i);
						count++;
					}
				}
			}
			max = Math.max(count, max);
		}
		System.out.println(max);

	}

	static void bfs(int x, int y, int height) {

		Queue<Dot> que = new LinkedList<>();
		que.add(new Dot(x, y));
		visit[x][y] = true;

		while (!que.isEmpty()) {
			Dot d = que.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];
				if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visit[nextX][nextY]
						&& map[nextX][nextY] > height) {
					que.add(new Dot(nextX, nextY));
					visit[nextX][nextY] = true;
				}
			}

		}
	}

	static class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
