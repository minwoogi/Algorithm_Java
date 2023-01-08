package baekjoon;

import java.util.Scanner;

public class Baekjoon_25642 {

	// * 백준25642 젓가락 게임 * //

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int yt = sc.nextInt();
		int yj = sc.nextInt();

		while (yt < 5 && yj < 5) {
			yj += yt;
			if (yj >= 5) {
				System.out.println("yt");
				break;
			} else {
				yt += yj;
				if (yt >= 5) {
					System.out.println("yj");
					break;
				}
			}
		}

	}

}
