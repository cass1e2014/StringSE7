import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * 
 * 基本思路是维护一个窗口，每次关注窗口中的字符串，在每次判断中，左窗口和右窗口选择其一向前移动。 同样是维护一个HashSet,
 * 正常情况下移动右窗口，如果没有出现重复则继续移动右窗口，如果发现重复字符，
 * 则说明当前窗口中的串已经不满足要求，继续移动有窗口不可能得到更好的结果，此时移动左窗口，直到不再有重复字符为止，
 * 中间跳过的这些串中不会有更好的结果，因为他们不是重复就是更短。因为左窗口和右窗口都只向前，
 * 所以两个窗口都对每个元素访问不超过一遍，因此时间复杂度为O(2*n)=O(n),是线性算法。 空间复杂度为HashSet的size,也是O(n).
 * 代码如下：
 * 
 * @author cassie9082
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		HashSet<Character> set = new HashSet<Character>();
		int max = 0;
		int leftbound = 0;
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				// 只要左右bound不相等
				while (leftbound < i && s.charAt(leftbound) != s.charAt(i)) {
					// 因为出现重复元素，所以现在窗口内的东西实效，左窗口移动，且记得把该元素从set中remove掉！
					set.remove(s.charAt(i));
					leftbound++;
				}
				leftbound ++;
			} else {
				set.add(s.charAt(i));
				max = Math.max(max, i - leftbound + 1);
			}
		}
		return max;
	}
}
