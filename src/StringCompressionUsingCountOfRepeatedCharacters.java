/**
 * Write an algo­rithm to com­press the given string by using the count of
 * repeated char­ac­ters and if new com­pressed string length is not smaller
 * than the orig­i­nal string then return the orig­i­nal string.
 * 
 * 
 * Example: 
 * Input String : sss­su­u­u­um­m­m­m­m­mi­i­i­ittttttttttttt
 * Com­pressed String : s4u4m6i4t13
 * 
 * Input String : Jaain
 * Com­pressed String : Jaain
 * 
 * @author cassie9082
 * 
 */
public class StringCompressionUsingCountOfRepeatedCharacters {
	public String compression(String s) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		char prev = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == prev) {
				count++;
			} else {
				sb.append(prev);
				sb.append(count);
				prev = c;
				count = 1;
			}
		}
		sb.append(prev);
		sb.append(count);

		if (s.length() < sb.length()) {
			return s;
		} else {
			return sb.toString();
		}
	}
}
