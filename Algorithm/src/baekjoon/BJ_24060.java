package baekjoon;

import java.io.*;
import java.util.*;

public class BJ_24060 {

	/**
	 * Created by minwoogi on 2022/12/26 알고리즘 수업 -병합 정렬 1
	 * https://www.acmicpc.net/problem/24060
	 */

	static int[] temp;
	static int count = 0;
	static int result = -1;
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 배열의 크기
		K = Integer.parseInt(st.nextToken()); // 저장 횟수

		int[] arr = new int[N];
		temp = new int[N];

		StringTokenizer stt = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(stt.nextToken());
		}

		mergeSort(arr, 0, arr.length - 1);
		System.out.println(result);

	}

	public static void mergeSort(int arr[], int p, int r) {

		if (p < r) {
			int mid = (p + r) / 2;
			mergeSort(arr, p, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, p, mid, r);
		}
	}

	public static void merge(int arr[], int p, int q, int r) {

		int i = p;
		int j = q + 1;
		int t = 0;

		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}

		while (i <= q) {
			temp[t++] = arr[i++];
		}

		while (j <= r) {
			temp[t++] = arr[j++];
		}

		t = 0;
		i = p;

		while (i <= r) {
			count++;
			if (count == K) {
				result = temp[t];
				break;
			}
			arr[i++] = temp[t++];
		}

	}

}
