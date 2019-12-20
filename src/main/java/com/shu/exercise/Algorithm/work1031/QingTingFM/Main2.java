package Algorithm.work1031.QingTingFM;

/**
 * 蜻蜓FM 笔试题
 * 输入一个字符串，求该字符中最长的不相同的子串
 * 比如：pwwkew，输出是3（wke）
 */

public class Main2 {

    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int[] dict = new int[256];
        int base = 0;
        int key = 0;
        int i = 0;
        while (key < s.length()) {
            i = s.charAt(key);
            if(dict[i] > base) {
                base = dict[i];
            }
            dict[i] = key + 1;
            maxSize = (maxSize > key - base + 1) ? maxSize : key - base + 1;
            key++;
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.lengthOfLongestSubstring("pwwkew"));
    }
}
