package com.daily.pratice.concept.recursion;

class Palindrome {

    public static void main(String[] args) {
        String testStr = "toyrobot";
        System.out.println(isPalindrome(testStr));
    }

    private static boolean isPalindrome(String s) {
        boolean isPalindrome = false;
        System.out.println("isPalindrome " + s);
        // base case
        if (s.length() <= 1) {
            isPalindrome = true;
            return isPalindrome;
        }
        // recursive case
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        String middle = s.substring(1, s.length() - 1);
        if (first == last && isPalindrome(middle)) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
