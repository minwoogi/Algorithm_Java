package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneNumberList {

	/**
	 * Created by minwoogi on 2022/05/15 전화번호 목록
	 ** https://programmers.co.kr/learn/courses/30/lessons/42577
	 */

	public static void main(String[] args) {

		// String[] phone_book = { "119", "97674223", "1195524421" };
		String[] phone_book = { "123", "456", "789" };
		// String[] phone_book = {"12","123","1235","567","88"};

		System.out.println(new Solution().solution(phone_book));
		System.out.println(new Solution2().solution(phone_book));
	}

	static class Solution {
		public boolean solution(String[] phone_book) {
			boolean answer = true;
			Arrays.sort(phone_book);

			for (int i = 0; i < phone_book.length - 1; i++) {
				if (phone_book[i + 1].startsWith(phone_book[i]))
					return false;
			}
			return answer;
		}
	}

	static class Solution2 {
		public boolean solution(String[] phone_book) {
			boolean answer = true;

			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < phone_book.length; i++) {
				map.put(phone_book[i], i);
			}

			for (int i = 0; i < phone_book.length; i++) {
				for (int j = 0; j < phone_book[i].length(); j++) {
					if (map.containsKey(phone_book[i].substring(0, j)))
						return false;
				}
			}

			return answer;
		}
	}

}
