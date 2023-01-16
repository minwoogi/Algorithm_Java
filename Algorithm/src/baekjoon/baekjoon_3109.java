package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3109 {

	static String[][] map;
	static int R, C;
	static int[] dx = { -1, 0, 1 };
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new String[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.split("");
		}

		count = 0;
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
		}

		System.out.println(count);
	}

	static boolean dfs(int x, int y) {

		if (y == C - 1) {
			count++;
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + 1;

			if (nx < 0 || ny < 0 || nx == R || ny == C)
				continue;
			if (map[nx][ny].equals("x"))
				continue;
			map[nx][ny] = "x";

			if (dfs(nx, ny))
				return true;

		}

		return false;
	}

}
