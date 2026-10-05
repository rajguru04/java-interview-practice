package string;

import java.util.HashMap;

public class AnagramProgram {
    public static void main(String[] args){
        String str1 = "anagram";
        String str2 = "nagaram";
        boolean isValidAnagram = checkAnagram(str1, str2);
        if(isValidAnagram){
            System.out.println("given strings are anagram");
        } else {
            System.out.println("given strings are not anagram");
        }
    }

    private static boolean checkAnagram(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray1 = str1.toCharArray();
        for(char ch  : charArray1){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch, 1);
            }
        }

        for(char ch : str2.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            } else {
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
            }
        }
        return map.isEmpty();
    }
}
