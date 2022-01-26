import java.util.Arrays;

public class CodeWars6Kyu {

    public static void main(String[] args) {
        String[] arrTest = splitStringIntoPairsOfTwo("abc");

        System.out.println(Arrays.toString(arrTest));

    }


    public static String[] splitStringIntoPairsOfTwo(String s) {
       // StringBuilder sb = new StringBuilder(s);
        if (s.length()%2 != 0){
            s += "_";
        }
        return s.split("(?<=\\G.{2})");
    }

    /**
     * Break up String if camelcased, ex: camelCase to camel Case
     */
    public static String camelCase(String input) {
        String cleanText = input.replaceAll("(.)([A-Z])", "$1 $2");
        return cleanText;
    }

    public static String camelCase3(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(' ');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String camelCase2(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            if (Character.isUpperCase(x) && i != 0) {
                result = input.substring(0, i) + " " + input.substring(i);
            }
        }
        return result;
    }
}
