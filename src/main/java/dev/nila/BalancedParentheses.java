package dev.nila;
import java.util.Stack;

public class BalancedParentheses {

    public static void main(String[] args) {
        String str1 = "{[(])}";
        String str2 = "((a+b)*c)";
        String str3 = "}(a+b)*c)";
        String str4 = "((()))";
        System.out.println(isBalancedParentheses(str4));
    }

    private static boolean isBalancedParentheses(String str){
        Stack<Character> stack = new Stack<>();

        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            if(ch == ')' || ch == ']' || ch == '}'){
                if(stack.isEmpty()) return false;
                char current = stack.pop();
                if(current == '{' &&  ch != '}' || current == '(' &&  ch != ')' || current == '[' &&  ch != ']' ) return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
