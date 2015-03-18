/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author cassie9082
 * 
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}

		int length = 0;
		char[] chars = s.toCharArray();
		//判断length为0和length不为0的时候遇到空格的情况。第一种是在结尾，所以continue；第二种在中间，即为我们要找的break point！
		for (int i = s.length() - 1; i > 0; i--) {
			if (length == 0) {
				if (chars[i] == ' ') {
					continue;
				} else {
					length++;
				}
			} else {
				if (chars[i] == ' ') {
					break;
				} else {
					length++;
				}
			}
		}
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
