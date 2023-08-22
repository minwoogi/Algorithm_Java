package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String board = br.readLine();

		String A = "AAAA";
		String B = "BB";

		board = board.replaceAll("XXXX", A);
		String anw = board.replaceAll("XX", B);

		if (anw.contains("X")) {
			System.out.print("-1");
			return;
		}else {
			System.out.println(anw);
		}

	}

}
