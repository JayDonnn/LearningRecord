package Algorithm.work1102;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串s,t 判断t是否是s的字母异位词
 * leetcode242
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int times = map.get(c);
                map.put(c, times + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            } else {
                int times = map.get(c);
                map.put(c, times - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

}


