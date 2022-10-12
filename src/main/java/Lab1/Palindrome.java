package Lab1;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " is palindrome");
            } else {
                    System.out.println(s + " is NOT palindrome");
            }
        }
    }

    public static String reverseString(String s) { //переворачивает строку
        String reversedString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversedString += s.charAt(i);
        }
        return reversedString;
    }

    public static boolean isPalindrome(String s) { //является ли слово палиндромом?
        return s.equals(reverseString(s));
    }
}
