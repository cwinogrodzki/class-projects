/*
Author: Claire Winogrodzki
This program takes a string ("123456" in this case), enumerates all
permutations of that string, prints all derangements (where no element
appears in its original position), and counts the number of derangements.

 */

public class Derangements {
    static int count = 0;
    public static void enumerate(String str, String ans){

        // If string is empty, check for derangement, then print
        if (str.length() == 0) {
            if(ans.charAt(0) != '1' && ans.charAt(1) != '2' && ans.charAt(2) != '3' && ans.charAt(3) != '4'
                    && ans.charAt(4) != '5' && ans.charAt(5) != '6') {
                System.out.print(ans + "      ");
                count++;
                if(count % 11 == 0) System.out.println();
            }
            else return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            enumerate(ros, ans + ch);
        }
    }

    public static void main(String[] args){
        String s = "123456";
        enumerate(s, "");
        System.out.println("\nNumber of derangements: " + count);
    }
}
