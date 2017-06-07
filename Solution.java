import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static String insertPeriodically(int text, String insert, int period) {
        String text1 = Integer.toString(text);
        StringBuilder builder = new StringBuilder(
        text1.length() + insert.length() * (text1.length()/period)+1);

    int index = 0;
    String prefix = "";
    while (index < text1.length())
    {
        builder.append(prefix);
        prefix = insert;
        builder.append(text1.substring(index, Math.min(index + period, text1.length())));
        index += period;
    }
    return builder.toString();
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        String AMorPM = time.replaceAll("[^a-zA-Z]", "");
        int digits = Integer.parseInt(time.replaceAll("[^0-9.]", ""));
        
        if (AMorPM.equalsIgnoreCase("AM")) {
            System.out.println(insertPeriodically(digits, ":", 2));
        }
        else {
            digits += 120000;
            System.out.println(insertPeriodically(digits, ":", 2));
        }
    }
}
