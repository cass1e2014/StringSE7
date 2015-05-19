import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. The brackets must close in the
 * correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author cassie9082
 * 
 */

public class ValidParentheses {
	public boolean isValid(String s){
		Stack<Character> stack = new Stack<Character>();
		for(Character c : s.toCharArray()){
			if("({[".contains(String.valueOf(c))){
				stack.push(c);
			}else{
				if(!stack.isEmpty() && is_valid(stack.peek(), c)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public boolean is_valid(Character c1, Character c2){
		return (c1 == '(' && c2 == ')' || c1 == '{' && c2 == '}' || c1 == '[' && c2 == ']');
	}
	
	public static void main(String[] args){
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("(({}))"));
	}
}
