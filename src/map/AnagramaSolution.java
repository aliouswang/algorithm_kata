package map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AnagramaSolution {

    public static void main(String[] args) {
        AnagramaSolution solution = new AnagramaSolution();
//        solution.anagram("ab", "ab");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        HashMap<String, Boolean> existMap = new HashMap<>();
        List<List<String>> resultList = new LinkedList<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (existMap.containsKey(strs[i])) {
                continue;
            }
            LinkedList<String> subList = new LinkedList<>();
            existMap.put(strs[i], true);
            subList.add(strs[i]);
            for (int j  = i+1; j < len; j++) {
                if (anagram(strs[i], strs[j])) {
                    existMap.put(strs[j], true);
                    subList.add(strs[j]);
                }
            }
            resultList.add(subList);
        }
        return resultList;
    }

    public boolean anagram(String s, String t) {
        // write your code here
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        sMap = buildMap(s);
        tMap = buildMap(t);

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char key = entry.getKey();
            int num = entry.getValue();

            if (!tMap.containsKey(key))  {
                return false;
            } else if (tMap.get(key) != num) {
                return false;
            }
        }

        return true;
    }

    private HashMap<Character, Integer> buildMap(String string) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = string.toCharArray();
        for (char ch : charArray) {
            if (map.containsKey(ch)) {
                int num = map.get(ch);
                map.put(ch, num+1);
            } else {
                map.put(ch, 1);
            }
        }
        return map;
    }


}
