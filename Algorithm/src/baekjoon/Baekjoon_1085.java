package baekjoon;

import java.util.Scanner;

public class Baekjoon_1085 {

	// * ����1085 ���簢������ Ż�� * //

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int w = scan.nextInt();
		int h = scan.nextInt();

		int min = Integer.MAX_VALUE;

		min = Math.min(Math.abs(x - w), Math.abs(y - h));
		min = Math.min(y, Math.min(x, min));
		
		System.out.println(min);

	}

}
