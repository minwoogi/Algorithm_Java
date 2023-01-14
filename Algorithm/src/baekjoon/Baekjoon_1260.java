package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_1260 {

	// * 백준1260 DFS와 BFS * //

	static boolean[] visit;
	static int[][] map;
	static int N, M, V;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		visit = new boolean[N + 1];
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}

		dfs(V);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(V);

	}

	static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");

		for (int i = 1; i <= N; i++) {
			if (visit[i] == false && map[v][i] == 1) {
				dfs(i);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(v);
		visit[v] = true;

		while (!que.isEmpty()) {
			int temp = que.poll();
			System.out.print(temp + " ");

			for (int i = 1; i <= N; i++) {
				if (map[temp][i] == 1 && !visit[i]) {
					que.add(i);
					visit[i] = true;
				}
			}
		}

	}

}
