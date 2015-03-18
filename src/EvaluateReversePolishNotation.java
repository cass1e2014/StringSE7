import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author cassie9082
 * 
 */

public class EvaluateReversePolishNotation {
	// stack， 每次把非＋－＊／的push到stack，
	public int evalRPN(String[] tokens) {
		if (tokens == null) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		String operators = "+-*/";
		for (String token : tokens) {
			if (!operators.contains(token)) {
				stack.push(Integer.valueOf(token));
				continue;//没有operator的话就不必要做无谓的判断，可以用continue跳过
			}
			int num1 = stack.pop();
			int num2 = stack.pop();
			if (token.equals("+")) {
				stack.push(num1 + num2);
			} else if (token.equals("-")) {
				stack.push(num1 - num2);
			} else if (token.equals("*")) {
				stack.push(num1 * num2);
			} else if (token.equals("/")) {
				stack.push(num1 / num2);
			}
		}
		return stack.pop();
	}
}
