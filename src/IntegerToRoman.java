/**
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * @author cassie9082
 * 
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman itr = new IntegerToRoman();
		String result = itr.intToRoman(7);
		System.out.println("Integer to Roman: " + result);
	}

	public String intToRoman(int num) {
		if (num <= 0) {
			return "";
		}
		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		int digit = 0;

		while (num > 0) {
			int times = num / nums[digit];
			System.out.println("digit = " + digit + ", nums[digit] ="+ nums[digit] + ", num=" + num + ", times =" + times);
			num -= nums[digit] * times;
			System.out.println("After num -= nums[digit] * times, num = " + num);
			for (; times > 0; times--) {
				sb.append(symbols[digit]);
			}
			digit++;
		}
		return sb.toString();
	}
}
