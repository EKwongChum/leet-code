package ekwong.question13;

import java.util.HashMap;

/**
 * @author ekwong
 */
public class Solution {

    public int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        for (int i = 0; i < s.length(); i++) {
            result += map.get(s.substring(i, i + 1));
        }
        if (s.length() != 1) {
            for (int i = 1; i < s.length(); i++) {
                String formerString = s.substring(i - 1, i);
                String currentString = s.substring(i, i + 1);
                int formerValue = map.get(formerString);
                int currentValue = map.get(currentString);
                if (formerValue < currentValue) {
                    result = result - (formerValue * 2);
                }
            }
        }
        return result;
    }
}
