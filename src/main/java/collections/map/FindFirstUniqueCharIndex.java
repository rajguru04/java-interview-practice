package collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FindFirstUniqueCharIndex {
    public static void main(String[] args){
        String str = "leetcodelt";
        int uniqueIndex = findUniqueCharIndexWithoutMap(str);
        System.out.println("first unique character index is: "+uniqueIndex);
    }

    private static int findUniqueCharIndex(String str) {
        char[] charStr = str.toCharArray();
        Map<Character,Integer> charMap = new HashMap<>();
        for(char ch : charStr){
            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);
        }
        for(int i=0;i< str.length();i++){
            if (charMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int findUniqueCharIndexWithoutMap(String str){
        char[] charStr = str.toCharArray();
        int[] count = new int[26];
        for (char ch : charStr){
            count[ch - 'a']++;
        }
        for(int i=0;i<str.length();i++){
            if( count[str.charAt(i) - 'a']==1){
                return i;
            }
        }
        return -1;
    }
}
