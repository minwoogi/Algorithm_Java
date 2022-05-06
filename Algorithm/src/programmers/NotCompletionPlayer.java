package programmers;

import java.util.HashMap;
import java.util.Map;

public class NotCompletionPlayer {

	/**
	 * Created by minwoogi on 2022/05/02 완주하지 못한 선수
	 ** https://programmers.co.kr/learn/courses/30/lessons/42576
	 */

	public static void main(String[] args) {
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };
		System.out.println(new Solution().solution(participant, completion));

	}

	static class Solution {
		public String solution(String[] participant, String[] completion) {
			String answer = "";
			HashMap<String, Integer> map = new HashMap<>();
			for (String name : participant) {
				map.put(name, map.getOrDefault(name, 0) + 1);
			}

			for (String name : completion) {
				map.put(name, map.get(name) - 1);
			}
			answer = getKey(map, 1);
			return answer;
		}

		public <K, V> K getKey(Map<K, V> map, V value) {

			for (K key : map.keySet()) {
				if (value.equals(map.get(key))) {
					return key;
				}
			}
			return null;
		}
	}
}
