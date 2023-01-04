package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class Baekjoon_2108 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		System.out.println((int) Math.round((double) sum / N)); // 1.»ê¼úÆò±Õ
		Arrays.sort(arr);
		System.out.println(arr[arr.length / 2]); // 2.Áß¾Ó°ª

		int[] minus = new int[4002];
		int[] plus = new int[4001];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				minus[Math.abs(arr[i])]++;
			} else {
				plus[arr[i]]++;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		int max = 0;
		for (int i = 0; i < minus.length; i++) {
			max = Math.max(minus[i], max);
		}
		for (int i = 0; i < plus.length; i++) {
			max = Math.max(plus[i], max);
		}

		for (int i : arr) {
			if (i < 0) {
				if (minus[Math.abs(i)] == max && !(list.contains(i))) {
					list.add(i);
				}
			} else {
				if (plus[i] == max && !(list.contains(i))) {
					list.add(i);
				}
			}
		}

		if (list.size() >= 2) { // 3.ÃÖºó°ª
			System.out.println(list.get(1));
		} else {
			System.out.println(list.get(0));
		}

		System.out.println(arr[N - 1] - arr[0]); // 4.¹üÀ§
	}

}
