import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n). For example, S =
 * "ADOBECODEBANC" T = "ABC" Minimum window is "BANC". Note: If there is no such
 * window in S that covers all characters in T, return the emtpy string "". If
 * there are multiple such windows, you are guaranteed that there will always be
 * only one unique minimum window in S.
 */

/*
 * 先遍历子串，用hashmap来存，再遍历母串
 * 因为这里是要求最短的包含子串的字符串，所以中间是可以允许有非子串字符的，当遇见非子串字符而count又没到子串长度时，可以继续走。
 * 
 * 当count达到子串长度，说明之前遍历的这些有符合条件的串，用一个leftBound指针帮忙缩短左边的window，leftBound指针帮忙找第一个在HashMap中存过的，
 * 并且找到后给计数加1后的总计数是大于0的，判断是否为全局最小长度，如果是，更新返回字符串result，更新最小长度，如果不是，继续找。
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		String result = "";
		if (S == null || S.length() == 0 || T == null || T.length() == 0) {
			return result;
		}

		HashMap<Character, Integer> tCounter = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			Character c = T.charAt(i);
			if (tCounter.containsKey(c)) {
				tCounter.put(c, tCounter.get(c) + 1);
			} else {
				tCounter.put(c, 1);
			}
		}

		int count = 0;
		int leftBound = 0;
		int minWindow = S.length() + 1;

		for (int j = 0; j < S.length(); j++) {
			Character s = S.charAt(j);
			if (tCounter.containsKey(s)) {
				tCounter.put(s, tCounter.get(s) - 1);
				if (tCounter.get(s) >= 0) {
					count++;
				}
				while (count == T.length()) {
					if (tCounter.containsKey(S.charAt(leftBound))) {
						tCounter.put(S.charAt(leftBound),
								tCounter.get(S.charAt(leftBound)) + 1);
						// 下面那个if判断条件必须要加。为了排除2个B都在一个window的情况（B在tcounter中从－1
						// --> 0, 0的话没有>0所以进不去update最小值)
						if (tCounter.get(S.charAt(leftBound)) > 0) {
							if (minWindow > j - leftBound + 1) {
								result = S.substring(leftBound, j + 1);
								minWindow = j - leftBound + 1;
							}
							count--;
						}
					}
					leftBound++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow(S, T));
	}
}
