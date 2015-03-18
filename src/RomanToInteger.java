import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * @author cassie9082
 * 
 */
public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		int result = rti.romanToInt("VII");
		System.out.println("result is : " + result);

	}

	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int length = s.length();
		int result = map.get(s.charAt(length - 1));// 从右往左读
		/*
		 * 如果Roman字符，从右往左读，右边小于左边，则result是加上去，若右边大于左边，则要从result中减去。
		 */
		for (int i = length - 2; i >= 0; i--) {
			if (map.get(s.charAt(i + 1)) <= map.get(s.charAt(i))) {
				result += map.get(s.charAt(i));
			} else {
				result -= map.get(s.charAt(i));
			}
		}
		return result;
	}

}
