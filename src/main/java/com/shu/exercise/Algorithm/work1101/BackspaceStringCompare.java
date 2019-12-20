package Algorithm.work1101;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入两个含有“#（表示退格）”字符的字符串，比较他们是否相等
 * 比如S="ab##" T="c#d#"  输出true， 因为S==T==""
 * https://leetcode-cn.com/problems/backspace-string-compare/description
 */

public class BackspaceStringCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String S = scanner.nextLine();
            String T = scanner.nextLine();
            boolean res = compare(S, T);
            System.out.println(res);
        }
    }


    // 方法1 栈
    private static boolean compare(String s, String t) {
        if(s == null || (s.length() < 1 && s.length() > 200) || t ==null || (t.length() < 1 && t.length() > 200)) {
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < sLength; i++) {
            Character c = s.charAt(i);
            if (c == '#') {
                if(!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.push(c);
            }
        }

        for (int i = 0; i < tLength; i++) {
            Character c = t.charAt(i);
            if (c == '#') {
                if(!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.push(c);
            }
        }

        if(sStack.isEmpty() && tStack.isEmpty()) {
            return true;
        } else if(!sStack.isEmpty() && !tStack.isEmpty()) {
            while (!sStack.isEmpty() && !tStack.isEmpty()) {
                char c1 = sStack.pop();
                char c2 = tStack.pop();
                if(c1 != c2) {
                    return false;
                }
            }
            if(!sStack.isEmpty() || !tStack.isEmpty()) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    /*
     方法2 从字符串从后往前读
     1.用count记录#的个数，每次遍历到#，则count++，跳过此次遍历
     2.不是#同时count>0，count--，同时跳过此次遍历
     3.不是#同时count==0（代表没有退格键不用删除前面字符），这时将字符加入一个StringBuilder中
     */
    public boolean backspaceCompare(String S, String T) {
        StringBuilder SS = new StringBuilder();
        StringBuilder TT = new StringBuilder();
        int count=0;
        for(int i=S.length()-1;i>=0;i--){
            char t = S.charAt(i);
            if(t=='#'){
                count++;
                continue;
            }
            if(count>0){
                count--;
                continue;
            }else{
                SS.append(t);
            }
        }
        count=0;
        for(int i=T.length()-1;i>=0;i--){
            char t = T.charAt(i);
            if(t=='#'){
                count++;
                continue;
            }
            if(count>0){
                count--;
                continue;
            }else{
                TT.append(t);
            }
        }
        if(SS.toString().equals(TT.toString())){
            return true;
        }else
            return false;
    }

}
