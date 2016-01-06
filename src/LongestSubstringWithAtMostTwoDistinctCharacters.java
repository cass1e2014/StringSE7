import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 * 
 * @author cassie9082
 * 
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public static void main(String[] args){
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();//放字母和位置！

		int leftBound = 0;
		int i = 0;
		int len = 0;
		for (i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, i);

			if (map.size() > 2) {
				len = Math.max(len, i - leftBound);
				while (map.size() > 2) {
					if (map.containsKey(s.charAt(leftBound)) && map.get(s.charAt(leftBound)) == leftBound) { //之后没有再出现重复元素，则移除
						map.remove(s.charAt(leftBound));
					}
					leftBound++;
				}
			}
		}
		if (leftBound < s.length()) {
			len = Math.max(len, i - leftBound);
		}
		return len;
	}
}
