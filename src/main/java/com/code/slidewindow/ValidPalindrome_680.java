package com.code.slidewindow;

/**
 * @author zqy on 2022/7/11.
 */
public class ValidPalindrome_680 {
    public boolean validPalindrome(String s) {
        int r = s.length()-1;
        int l = 0;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return check(s, l+1, r) || check(s, l, r-1);
            }
            // System.out.println(l + " " + r);
            l++;
            r--;
        }

        return true;
    }

    private boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
