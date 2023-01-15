package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_2583 {

	// * 백준2583 영역 구하기 * //

	static int M, N, K, count;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k] = 1;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					count = 0;
					dfs(i, j);
					list.add(count);
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for (Integer i : list) {
			System.out.print(i + " ");
		}

	}

	static void dfs(int i, int j) {
		map[i][j] = 1;
		count++;

		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int ny = j + dy[k];

			if (nr >= 0 && ny >= 00 && nr < M && ny < N) {
				if (map[nr][ny] == 0) {
					dfs(nr, ny);
				}
			}
		}

	}

}
