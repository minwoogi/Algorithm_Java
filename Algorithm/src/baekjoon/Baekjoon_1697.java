package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_1697 {

	// * 백준1697 숨바꼭질 * //

	static int[] visit = new int[100001];
	static int time;
	static int N, K;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		K = scan.nextInt();
		visit[N] = 1;
		bfs(N);
		System.out.print(visit[K] - 1);

	}

	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();

		que.add(x);

		while (!que.isEmpty()) {

			int temp = que.poll();

			if (temp == K) {
				return;
			}
			if (temp + 1 >= 0 && temp + 1 <= 100000 && visit[temp + 1] == 0) {
				que.add(temp + 1);
				visit[temp + 1] = visit[temp] + 1;

			}
			if (temp - 1 >= 0 && visit[temp - 1] == 0) {
				que.add(temp - 1);
				visit[temp - 1] = visit[temp] + 1;

			}
			if (2 * temp >= 0 && 2 * temp <= 100000 && visit[2 * temp] == 0) {
				que.add(2 * temp);
				visit[2 * temp] = visit[temp] + 1;
			}

		}

	}
}
