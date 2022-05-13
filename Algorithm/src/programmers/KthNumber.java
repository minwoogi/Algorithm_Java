package programmers;

import java.util.Arrays;

public class KthNumber {

	/**
	 * Created by minwoogi on 2022/05/13 K¹øÂ°¼ö
	 ** https://programmers.co.kr/learn/courses/30/lessons/42748
	 */

	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = { {2,5,3} , {4,4,1},{1,7,3}};
		System.out.println( Arrays.toString(new Solution().solution(array, commands)));
	}

	static class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];
			for (int i = 0; i < commands.length; i++) {
				int start = commands[i][0];
				int end = commands[i][1];
				int cut = commands[i][2];
				
				System.out.println(start+" "+end+" "+cut);

				int[] arr = new int[end - start+1];
				int temp = 0;
				for (int j = start - 1; j <= end - 1; j++) {
					arr[temp] = array[j];
					temp++;
				}

				Arrays.sort(arr);
				answer[i] = arr[cut - 1];
			}
			return answer;
		}
	}

}
