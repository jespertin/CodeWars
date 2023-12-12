public class DebuggerDemo {
    public static void main(String[] args) {

        boolean isogram = isIsogram("Windows");

        System.out.println(isogram);

    }

    // Isogram: A word with no repeating letters. Return true if str is Isogram, else return false. (Ignore case)

    public static boolean isIsogram(String word) {
         String word2 =  word.toLowerCase();

        for (int i = 0; i < word2.length(); i++) {
            for (int j = i + 1; j < word2.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }







    public static boolean isIsogram2(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
