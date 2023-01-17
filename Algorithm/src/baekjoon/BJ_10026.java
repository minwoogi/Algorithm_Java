package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10026 {

	// * 백준10026 적록색약 * //

	static String[][] map;
	static boolean[][] visited;
	static int[] nx = { -1, 1, 0, 0 };
	static int[] ny = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new String[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		int count1 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count1++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
				if (map[i][j].equals("G")) {
					map[i][j] = "R";
				}
			}
		}

		int count2 = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count2++;
				}
			}
		}

		System.out.print(count1 + " " + count2);

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		String color = map[x][y];

		int dx = 0;
		int dy = 0;
		for (int i = 0; i < 4; i++) {
			dx = nx[i] + x;
			dy = ny[i] + y;
			if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy] && map[dx][dy].equals(color)) {
				dfs(dx, dy);
			}
		}
	}

}
