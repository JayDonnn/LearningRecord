package Algorithm.work1101;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效：括号成对且关闭顺序正确
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if(c == ')') {
                if(!stack.isEmpty()) {
                    char topChar = stack.pop();
                    if(topChar != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            if(c == '}') {
                if(!stack.isEmpty()) {
                    char topChar = stack.pop();
                    if(topChar != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            }

            if(c == ']') {
                if(!stack.isEmpty()) {
                    char topChar = stack.pop();
                    if(topChar != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(validParentheses.isValid(input));
    }
}
