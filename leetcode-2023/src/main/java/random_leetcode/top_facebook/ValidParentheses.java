package random_leetcode.top_facebook;

import java.util.Stack;

public class ValidParentheses {

    // Intuition:
    // Idea is that all opening and closing brackets should be in proper order and should be adjacent to each other
    // So, we can make use of stack data structure to store the opening brackets
    // iterate over the input string - check for the type of character and either insert it / or pop it based on required conditions

    // TC - O(N) where N is the length of input string
    // SC - O(N) - It could be in worst case O(N) where we end up storing all the characters of input string into the stack
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}