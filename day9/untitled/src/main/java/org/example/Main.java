/*package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();

        int cnt = 0;
        HashSet<String> hashSet = new HashSet<>();
        for(int i=0; i<in.length(); i++){
            int sub = 1+cnt;

            int start = 0;
            while(sub <= in.length()){
                hashSet.add(in.substring(start++, sub++));
            }
            cnt++;
        }


        System.out.println(hashSet.size());


    }

}*/