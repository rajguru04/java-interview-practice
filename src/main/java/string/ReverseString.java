package string;

public class ReverseString {
    public static void main(String[] args){
        String str = "java concept of the day";
        String revStr = recursiveRevString(str);
        System.out.println(revStr);
    }

    private static String recursiveRevString(String str) {
        if (str==null || str.length()<=1){
            return str;
        }
        return recursiveRevString(str.substring(1)) + str.charAt(0);
    }
}
