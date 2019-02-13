package com.daily.pratice.hackerrank;

public class RepeatedStrings {

    public static void main( String args[] ) {
        repeatedString("aba",10);
    }

    static long repeatedString(String s, long n) {
        int str_len = s.length()-1;
        char[] str_chars = s.toCharArray();
        int j = 0;
        int num_of_a = 0;
        StringBuilder targetString = new StringBuilder("");
        while(targetString.length() < n ) {
            if (j > str_len) {
                j = 0;
            }
            if( String.valueOf(str_chars[j]).equals("a")){
                ++num_of_a;
            }
            targetString.append(str_chars[j]);
            ++j;
            ++n;
        }

        System.out.println("Target string " + targetString);
        System.out.println("No of a's" + num_of_a );
        return num_of_a;
    }
}
