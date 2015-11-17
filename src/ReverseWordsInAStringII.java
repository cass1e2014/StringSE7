import java.util.Arrays;

/**
 * Given an input string, reverse the string word by word. A word is defined as
 * a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words
 * are always separated by a single space.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * Could you do it in-place without allocating extra space?
 * 
 * @author cassie9082
 * 
 */
public class ReverseWordsInAStringII {
	//DO IT IN PLACE
	public void reverseWords(char[] s) {
		if (s == null || s.length == 0)
			return;
		int start = 0;
		int end = -1;
		int i = start;
		// reverse every word in the string => "eht yks si eulb"
		while (i < s.length) {
			if (s[i] == ' ' || i == s.length - 1) {
				end = s[i] == ' ' ? i - 1 : i;
				reverse(s, start, end);
				start = i + 1;
			}
			i++;
		}

		// reverse the whole string => "blud is sky the"
		reverse(s, 0, s.length - 1);
	}

	private void reverse(char[] s, int start, int end) {
		while (start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}
}
