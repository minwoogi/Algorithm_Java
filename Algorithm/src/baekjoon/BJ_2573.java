package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2573 {

	// * ¹éÁØ2573 ºù»ê * //

	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int piece;
	static int N, M;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int height = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, height);
				map[i][j] = height;
			}
		}

		int year = 0;

		while (true) {
			piece = 0;
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) { // Á¶°¢ È®ÀÎ
				for (int j = 0; j < M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						piece++;
						dfs(i, j);
					}
				}
			}

			if (piece == 0) {
				System.out.println(0);
				break;
			}
			if (piece >= 2) {
				System.out.print(year);
				break;
			}

			visited = new boolean[N][M];
			for (int i = 1; i < N - 1; i++) { // ºù»ê ³ìÀÌ±â
				for (int j = 1; j < M - 1; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						visited[i][j] = true;
						for (int k = 0; k < 4; k++) {
							int nx = dx[k] + j;
							int ny = dy[k] + i;
							if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 0 && !visited[ny][nx]) {
								if (map[i][j] - 1 < 0) {
									map[i][j] = 0;
								} else {
									map[i][j] -= 1;
								}
							}
						}
					}
				}
			}
			year++;

		}

	}

	static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int k = 0; k < 4; k++) {
			int nx = dx[k] + x;
			int ny = dy[k] + y;
			if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx] && map[ny][nx] > 0) {
				dfs(ny, nx);
			}
		}

	}

}
