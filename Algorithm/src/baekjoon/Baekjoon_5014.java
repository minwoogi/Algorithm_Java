package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_5014 {

	// * 백준5014 스타트링크 * //

	static int[] map;
	static int count = 0;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int F = scan.nextInt(); // 총F층
		int S = scan.nextInt(); // 강호 위치 층
		int G = scan.nextInt(); // 스타트링크 위치 층
		int U = scan.nextInt(); // 위로 U층 버튼
		int D = scan.nextInt(); // 아래로 D층 버튼

		map = new int[F + 1];
		bfs(F, S, G, U, D);
	}

	static void bfs(int floor, int start, int end, int up, int down) {
		Queue<Integer> que = new LinkedList<>();

		que.add(start);
		map[start] = 1;

		while (!que.isEmpty()) {
			int temp = que.poll();
			if (temp == end) {
				System.out.print(map[end] - 1);
				return;
			}
			if (temp + up <= floor && map[temp + up] == 0) {
				que.add(temp + up);
				map[temp + up] = map[temp] + 1;
			}
			if (temp - down > 0 && map[temp - down] == 0) {
				que.add(temp - down);
				map[temp - down] = map[temp] + 1;
			}
		}
		System.out.print("use the stairs");
		return;

	}

}
