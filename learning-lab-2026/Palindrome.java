public class Palindrome {
    public static boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase();
        return normalized.contentEquals(new StringBuilder(normalized).reverse());
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(String.join(" ", args)));
    }
}