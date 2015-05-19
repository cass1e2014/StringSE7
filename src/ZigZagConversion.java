/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

/*
 * The number of rows is variable. So we need to find the rule of each row. 
 * For example, when nRows = 4, we know the ZigZag should be like the following.
 * 0        6       12       18
 * 1     5  7    11 13    17 19
 * 2  4     8 10    14 16    20
 * 3        9       15       21
 * 
 * It’s easy to find that the step of 4-number column is 6. In fact, the step is just two times of nRows minus 2, 
 * in which 2 indicating there  are no numbers between the 4-number column in the first line and last line.
 * 
 * And there is only one number between 4-number column in other lines. Take the second line as an example. 
 * The second line is “1 5 7 11 13 17 19″. We can take a look at “1 5 7″. The step between “1” and “5” is (nRows – 1 – 1) * 2, which is 4. 
 * And the step of “5” and “7” is 6 – 4 = 2. 
 * In fact, assuming we are at line i (starting at 0), the first step is (nRows – 1 – i) * 2.
 * 
 * 时间复杂度是O(n),空间复杂度是O(1)
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(s == null || s.length() == 0 || nRows <= 0){
			return "";
		}
		
		if(nRows == 1){
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		int step = 2 * nRows - 2;
		for(int i = 0; i < nRows; i ++){
			if(i ==  0 || i == nRows - 1){  //第一行和最后一行，间隔是6(如果以n = 4为例子的话）
				for(int j = i; j < s.length(); j = j + step){
					sb.append(s.charAt(j));
				}
			}else{
				int j = i;
				boolean flag = true;
				int step1 = 2 * (nRows - 1 -i);
				int step2 = step - step1;
				while(j < s.length()){
					sb.append(s.charAt(j));
					if(flag){
						j = j + step1;
					}else{
						j = j + step2;
					}
					flag = !flag;
				}
			}
		}
		return sb.toString();
	}
}
