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
                i++;
                j++;
            }else if(j < p.length() && p.charAt(j) == '*'){
                star = ++j;//遇到*,先把j往后移一位，再用star记录下此时位置
                mark = i;//mark标记i的位置，i不动
            }else if(star != -1){
                //如果在遇到*，j移动后，此刻相同位置的字符还是不同，则移动i，只要在P string范围内i一直往后移看能否找到和*后相同的字符
                j = star;
                i = ++mark;
            }else{
                return false;
            }
        }
        //如果s string已经过完，*在p string末尾，则继续移动j，因为*可对应empty sequence
        while(j < p.length() && p.charAt(j) == '*'){
            j++;
        }
        return j == p.length();
	}
	
	public static void main(String[] args){
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("aa", "?*"));
		System.out.println(isMatch("aabc", "a*c"));
	}
}
