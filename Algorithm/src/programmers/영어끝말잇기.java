package programmers;

public class 영어끝말잇기 {

	class Solution {
		public int[] solution(int n, String[] words) {

			String[] wordArr = new String[words.length];
			wordArr[0] = words[0];

			for (int i = 1; i < words.length; i++) {
				if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
					if ((i + 1) % n == 0) {
						return new int[] { n, (i + 1) / n };
					}
					return new int[] { (i + 1) % n, (i + 1) / n + 1 };
				}
				if (isExists(words[i], i, wordArr)) {

					if ((i + 1) % n == 0) {
						return new int[] { n, (i + 1) / n };
					}
					return new int[] { (i + 1) % n, (i + 1) / n + 1 };

				}

				wordArr[i] = words[i];
			}
			return new int[] { 0, 0 };
		}

		public boolean isExists(String word, int index, String[] arr) {
			boolean flag = false;

			for (int i = 0; i < index; i++) {
				if (arr[i].equals(word)) {
					return true;
				}
			}
			return flag;
		}
	}

}
