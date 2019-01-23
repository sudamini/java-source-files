package com.daily.pratice.concept.recursion;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReverseLines {

        public static void main(String[] args) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(
                        "/E://data//soudamini/filetoreverse1.txt"));
                reverse( reader);
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private static void reverse( BufferedReader reader ) throws Exception {
            String inLine;
            inLine = reader.readLine();
            // base case
            if( inLine == null ) {
                return;
            } else { // recursive case
                reverse( reader );
                System.out.println(inLine);
            }
        }
    }


