/*
Claire Winogrodzki
This program takes a string and returns the character value which appears
the most in the string, and its count.
3/10/2021
 */
import java.util.HashMap;

public class MaxOccurrence {

    public static void main(String[] args) {
        String s = "AbAsdTAiiiAm";
        HashMap<Character, Integer> m = new HashMap<>();

        //count chars
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (m.containsKey(c) == true) {
                //increase value
                int j = m.get(c) + 1;
                m.put(c, j);
            }
            else {
                //add to hashmap
                m.put(c, 1);
            }
        }
        //get maximum
        int maxNum = 0;
        char maxChar = ' ';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int j = m.get(c);
            //update max
            if(j > maxNum){
                maxNum = j;
                maxChar = c;
            }
            //compare ASCII values if ==
            else if(j == maxNum){
                int c1 = (int) maxChar;
                int c2 = (int) c;
                if(c2 <= c1){
                    maxNum = j;
                    maxChar = c;
                }
            }
        }
        System.out.println(maxChar + " " + maxNum);
    }
}

