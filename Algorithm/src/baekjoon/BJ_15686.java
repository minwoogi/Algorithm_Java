package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BJ_15686 {

	// * 백준 15686 치킨배달 * //

	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	static boolean[] chickenVisited;
	static int M, N;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					home.add(new Point(i, j));
				else if (map[i][j] == 2)
					chicken.add(new Point(i, j));
			}
		}

		chickenVisited = new boolean[chicken.size()];
		ans = Integer.MAX_VALUE;

		back(0, 0);
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	public static void back(int start, int cnt) {
		if (cnt == M) {
			int total = 0;

			for (int i = 0; i < home.size(); i++) {
				int sum = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (chickenVisited[j]) {
						int dist = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);

						sum = Math.min(sum, dist);
					}
				}
				total += sum;
			}
			ans = Math.min(ans, total);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			chickenVisited[i] = true;
			back(i + 1, cnt + 1);
			chickenVisited[i] = false;
		}

	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}