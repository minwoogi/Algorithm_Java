package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11724 {

	// * ����11724 ���� ����� ���� * //

	static int[][] map = new int[1001][1001];

	static boolean[] visit = new boolean[1001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // ������ ����
		int M = Integer.parseInt(st.nextToken()); // ������ ����

		map = new int[1001][1001];
		visit = new boolean[1001];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = map[v][u] = 1;
		}

		int count = 0;

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);

	}

	static void dfs(int i) {
		visit[i] = true;
		for (int j = 0; j < 1001; j++) {
			if (!visit[j] && map[i][j] == 1) {
				dfs(j);
			}
		}

	}

}
