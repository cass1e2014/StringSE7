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
				while (leftbound < i && s.charAt(leftbound) != s.charAt(i)) {
					// 当遇到相同的字符，如果不是重复元素，从set中移除
					set.remove(s.charAt(leftbound));
					leftbound++;
				}
				leftbound ++;//若是重复元素，把左bound右移，不再考虑那个字符
			} else {
				set.add(s.charAt(i));//只要遇到不相同的字符不断加到set中
				max = Math.max(max, i - leftbound + 1);
			}
		}
		return max;
	}
	
	public int lengthOfLongestSubstringII(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        
        boolean[] flag = new boolean[256];//走过的格子，遇到过该字符的，就把格子从true翻到false
        
        char[] charArray = s.toCharArray();
        
        int result = 0;
        int start = 0;
        for(int i = 0; i < charArray.length ; i++){
            char current = charArray[i];
            if(flag[current]){
                result = Math.max(result, i - start);
                for(int j = start; j < i; j++){//过一遍没有重复字符的abc，把start往后移一位，不再考虑重复的a
                    if(charArray[j] == current){
                        start = j + 1;
                        break;
                    }
                    //"abcabcbb" 当遇到第二个a，要把bc的格子从true翻到false
                    flag[charArray[j]] = false;
                }
            }else{
                flag[current] = true;
            }
        }
        result = Math.max (charArray.length - start, result);
        return result;
    }
}
