package string;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args){
        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagramOfStr(input);
        System.out.println(result);
    }

    private static List<List<String>> groupAnagramOfStr(String[] input) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for(String str : input) {
            int[] count = new int[26];
            for(char ch : str.toCharArray()){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            groupMap.computeIfAbsent(key,k->  new ArrayList<>()).add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
}
