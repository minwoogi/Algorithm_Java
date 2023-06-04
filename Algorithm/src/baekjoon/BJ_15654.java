package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654 {

	// * πÈ¡ÿ15654 N∞˙M(5) * //

	static int N;
	static int M;
	static StringBuilder sb;
	static int[] arr;
	static int[] ans;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];

		arr = new int[N];
		ans = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		sb = new StringBuilder();
		backTracking(0);
		System.out.println(sb);

	}

	static void backTracking(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(ans[i] + " ");
			}
			sb.append("\n");
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[count] = arr[i];
				backTracking(count + 1);
				visited[i] = false;
			}
		}
	}

}
