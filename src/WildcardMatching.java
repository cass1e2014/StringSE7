/*
 * Implement wildcard pattern matching with support for '?' and '*'.
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).
 The function prototype should be:
 bool isMatch(const char *s, const char *p)
 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */

////////和RegularExpressionMatching一起记!!! /////////

/*
 * 贪心的策略，能匹配就一直往后遍历，匹配不上了就看看前面有没有'*'来救救场，再从'*'后面接着试。
 */
public class WildcardMatching {
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		
		while(i < s.length()){
			if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
				++i;
				++j;
			}else if(j < p.length() && p.charAt(j) == '*'){
				star = ++j;
				mark = i;
				/*此种情况是，当遇到*的时候，j移动到*后一个，和i比较。
				 * 因为*可以代表一连串到任意字符，所以这个时候就要看i
				 * i一直往后找，看能不能找到一个字符和p在*后的第一个字符正好一样，剩下的再继续比较下去
				*/
			}else if(star != -1){
				j = star + 1;
				i = ++mark;
			}else{
				return false;
			}
		}
		//判断*在p的最末尾的情况
		while(j < p.length() && p.charAt(j) == '*'){
			++j;
		}
		
		return j == p.length();//***important!
	}
	
	public static void main(String[] args){
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aabc", "a*c"));
	}
}
