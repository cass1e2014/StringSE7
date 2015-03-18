/*
 * Given an input string, reverse the string word by word. 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 */
public class ReverseWordsInAString {
	public static String reverseWords(String s) {
		if (s.length() == 0 || s == null) {
			return "";
		}

		String[] array = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = array.length - 1; i >= 0; i--) {
			//如果不为空的话
			if (!array[i].equals("")) {
				sb.append(array[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1); //注意这里要去掉最后一个单词后append上去的那个空格
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
	}
}
