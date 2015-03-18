/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * 1 建立数组，双层循环遍历两个string，把单位的乘积累加到数组相应的位置
 * 2 处理进位并输出
 * 3 注意前导零的corner case
 */
public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		int length = num1.length() + num2.length();
		int[] d = new int[length];

		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int b = num2.charAt(j) - '0';
				d[i + j] += a * b;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			sb.insert(0, digit);
			if (i + 1 < d.length) {
				d[i + 1] += carry;
			}
		}

		// 最后结果前面的0要清掉
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		String num1 = "10";
		String num2 = "100";
		System.out.println(multiply(num1, num2));
	}

}
