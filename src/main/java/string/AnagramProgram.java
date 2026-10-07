package string;

import java.util.HashMap;

public class AnagramProgram {
    public static void main(String[] args){
        String str1 = "anagram";
        String str2 = "nagaram";
        boolean isValidAnagram = checkAnagramWithoutUsingMap(str1, str2);
        if(isValidAnagram){
            System.out.println("given strings are anagram");
        } else {
            System.out.println("given strings are not anagram");
        }
    }

    private static boolean checkAnagram(String str1, String str2) {
        if(str1.length()!= str2.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch  : str1.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(char ch : str2.toCharArray()){
          if(!map.containsKey(ch)){
              return false;
          }
          int count = map.get(ch)-1;
          if(count==0){
              map.remove(ch);
          }else{
              map.put(ch,count);
          }
        }
        return map.isEmpty();
    }

    private static boolean checkAnagramWithoutUsingMap(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        int[] count = new int[26];
        for(char ch : charStr1){
            count[ch - 'a']++;
        }
        for(char ch : charStr2){
            count[ch - 'a']--;
        }
        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
