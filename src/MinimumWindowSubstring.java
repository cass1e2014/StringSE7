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
 * 当count达到子串长度，说明之前遍历的这些有符合条件的串，用一个leftBound指针帮忙缩短左边的window，
 * leftBound指针帮忙找第一个在HashMap中存过的，
 * 并且找到后给计数加1后的总计数是大于0的，判断是否为全局最小长度，如果是，更新返回字符串result，更新最小长度，如果不是，继续找。
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		String result = "";
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return result;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		int count = 0;
		int prev = 0;
		int minStart = 0;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (map.containsKey(currChar)) {
				// if all T's character are found, each corresponding value
				// should <= 0
				map.put(currChar, map.get(currChar) - 1);
				// stop adding length if S has more currChar than T
				if (map.get(currChar) >= 0) {
					count++;
				}
				// |prev, i| of S contains all T's character, now shift the left
				// pointer(prev)
				while (count == t.length()) {
					char leftBound = s.charAt(prev);
					// if prevChar character exists in T
					if (map.containsKey(leftBound)) {
						// add back
						map.put(leftBound, map.get(leftBound) + 1);

						// |prev, i| is the min substring ending at i
						//如果从map中得到的数是负数，表示维护的这个minLenth中有的字母的出现次数多于T中相对应字母的出现字数
						if (map.get(leftBound) > 0) {
							if (minLength > i - prev + 1) {
								minLength = i - prev + 1;
								minStart = prev;
							}
							count--;// reduce the count to end while loop
						}
					}
					prev++;
				}
			}
		}

		if (minLength == Integer.MAX_VALUE) {
			return "";
		} else {
			return s.substring(minStart, minStart + minLength);
		}
	}

	public static void main(String[] args) {
		String S = "bba";
		String T = "ab";
		MinimumWindowSubstring m = new MinimumWindowSubstring();
		System.out.println(m.minWindow(S, T));
	}
}
