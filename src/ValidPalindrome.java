/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
public class ValidPalindrome {
	public static boolean isPalindrome1(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]", "");
		String sReversed = new StringBuilder(s).reverse().toString();
		return s.compareTo(sReversed) == 0 ? true : false;

	}

	public static boolean isPalindrome2(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		// 两个指针，一个从前往后走，一个从后往前走
		int front = 0;
		int end = s.length() - 1;

		while (front < end) {
			//当碰到非法字符当时候
			while (front < s.length() && !isValid(s.charAt(front))) {
				front++;
			}

			if(front == s.length()){
                return true;//for empty String ".,,,"
            }
			
			while (end >= 0 && !isValid(s.charAt(end))) {
				end--;
			}
			
			//当遇到front和end所指的字符不相等的时候
			if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
				break;
			} else {
				front++;
				end--;
			}
		}
		return end <= front;
	}

	// 判断字符是否valid
	public static boolean isValid(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome1(s));
		System.out.println(isPalindrome2(s));
	}
}
