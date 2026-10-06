package array;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElement {
    public static void main(String[] args){
        int[] input = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean isDuplicate = containsDuplicate1(input);
        System.out.println(isDuplicate);
    }

    private static boolean containsDuplicate(int[] input) {
        Set<Integer> set = new HashSet<>();
        for(int num : input){
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

    private static boolean containsDuplicate1(int[] input) {
        int[] result = sortArray(input);
        for(int i=0;i<=result.length-1;i++){
            if(result[i]==result[i+1]){
                return true;
            }
        }
        return false;
    }

    private static int[] sortArray(int[] input) {
        for(int i=0;i<input.length;i++){
            for(int j=input.length-1;j>0;j--){
                if(input[i]>input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }
}
