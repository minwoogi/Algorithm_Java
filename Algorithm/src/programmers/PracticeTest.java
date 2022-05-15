package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticeTest {

	/**
	 * Created by minwoogi on 2022/05/02 모의고사
	 ** https://programmers.co.kr/learn/courses/30/lessons/42840
	 */

	static class Solution {
		public int[] solution(int[] answers) {
			int[] a = { 1, 2, 3, 4, 5 };
			int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
			int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

			int[] score = new int[3];

			for (int i = 0; i < answers.length; i++) {
				if (a[i % 5] == answers[i])
					score[0]++;
				if (b[i % 8] == answers[i])
					score[1]++;
				if (c[i % 10] == answers[i])
					score[2]++;
			}

			int[] arr = new int[3];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = score[i];
			}

			Arrays.sort(arr);
			ArrayList<Integer> list = new ArrayList<>();

			for (int i = 0; i < score.length; i++) {
				if (score[i] == arr[2]) {
					list.add(i + 1);
				}
			}
			int[] answer = new int[list.size()];

			for (int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}

			return answer;

		}
	}
}
