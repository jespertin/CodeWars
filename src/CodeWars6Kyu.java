import java.lang.reflect.Array;
import java.util.*;

public class CodeWars6Kyu {

    public static void main(String[] args) {

        System.out.println(gaussMethodOfAdding(5));
    }

    public static int presses(String phrase){

        //How to do this without hardcoding int value to each letter/number?
        for (int i = 0; i < phrase.length(); i++) {
        }

        return 0;
    }

    public static int gaussMethodOfAdding(int i){

        return i*(i+1)/2;
    }

    public static int digital_root(int n){
        int result = 0;
        String s = Integer.toString(n);
        do {
            result = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i==s.length()-1) {
                    result += Integer.parseInt(s.substring(i));
                    break;
                }
                result+= Integer.parseInt(s.substring(i,i+1));
            }
            s = Integer.toString(result);
        } while (result>=10);

        return result;
    }
        public static int digital_root2(int n) {
        return (n != 0 && n%9 == 0) ? 9 : n % 9;
    }


    // Phonenumber always has this format: (123) 456-7890
    public static String createPhoneNumber(int[] numbers){
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (int i = 0; i < numbers.length; i++) {
            if (i==3)
                sb.append(") ");
            if (i==6)
                sb.append("-");

            sb.append(numbers[i]);
        }

        return sb.toString();
    }

    public static String createPhoneNumber2(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");

        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }

    public static boolean isAValidMessage(String message){
        String[] splitStrings = message.split("((?=\\d+)|(?<=[0-9]))");
        for (String splitString : splitStrings) {
            System.out.println(splitString);
        }

        return false;
    }

    public static int amountOfPages(int summary){
        if (summary <= 9)
            return summary;
        int count = 0;

        for (int i = 0; i < summary; i++) {
            count+= String.valueOf(i).length();
            if (count>=summary)
                return i;
        }
        throw new IllegalArgumentException();
    }

    public static int[] twoSumWithHashMap(int[] numbers, int target){
        Map<Integer,Integer> complements = new HashMap<>(numbers.length);

        for (int i = 0; i < numbers.length; i++) {
            if (complements.containsKey(target-numbers[i])){
                return new int[] {i, complements.get(target-numbers[i])};
            }
            else{
                complements.put(numbers[i],i);
            }
        }

        throw new IllegalArgumentException();
    }

    public static int[] twoSum(int[] numbers, int target){

        for (int numberOne = 0; numberOne < numbers.length; numberOne++) {
            for (int numberTwo = 1; numberTwo < numbers.length; numberTwo++) {
                if (numbers[numberOne]+numbers[numberTwo]==target){
                    return new int[] {numberOne,numberTwo};
                }
            }
        }

        throw new IllegalArgumentException();
    }




    /**
     * There is a queue for the self-checkout tills at the supermarket.
     * Your task is write a function to calculate the total time required for all the customers to check out!
     * input
     * customers: an array of positive integers representing the queue.
     * Each integer represents a customer, and its value is the amount of time they require to check out.
     * n: a positive integer, the number of checkout tills.
     * Return total amount required
     */
    public static int SolveSuperMarketQueue(int[] customers, int n) {
        int sum = 0;

        if (n == 1) {
            for (int i = 0; i < customers.length; i++) {
                sum += customers[i];
            }
        }else {
            int i=0;
            while (i< customers.length){
                int[] times;
                if (i+n-1 > customers.length){
                    times = Arrays.copyOfRange(customers,i,customers.length-1);
                }else {
                    times = Arrays.copyOfRange(customers,i,i+n-1);
                }
                int max = times[0];
                for (int time : times) {
                    if (max < time){
                        max = time;
                    }
                }
                i=i+n;
                sum += max;
            }
        }
        return sum;
    }

    /**
     * Your task is to sort a given string. Each word in the string will contain a single number.
     * This number is the position the word should have in the result. If empty string, return ""
     */
    public static String order(String words) {
        if (words.length() == 0)
            return "";

        String[] arr = words.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].contains("" + i)) {
                    sb.append(arr[j] + " ");
                    break;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String[] splitStringIntoPairsOfTwo(String s) {
        if (s.length() % 2 != 0) {
            s += "_";
        }
        return s.split("(?<=\\G.{2})");
    }

    public static String[] splitStringIntoPairsOfTwo2(String s) {
        if (s.length() % 2 == 1) s += "_";
        int n = s.length() / 2;

        //Because we want pairs of two, we can iterate through s.length/2. And *2 our index
        String[] sub = new String[n];
        for (int i = 0; i < n; ++i)
            sub[i] = "" + s.charAt(i * 2) + s.charAt(1 + i * 2);

        return sub;
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


    /**
     * If char appears once, swap it to '('. swap to ')' if it appears more than once. Ignore case
     */
    static String encode(String word) {
        String result = "";
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            word.lastIndexOf(x);

            for (int j = 0; j < word.length(); j++) {
                int count = 0;

                if (j != i && x == word.charAt(j)) {
                    result += ")";
                    break;
                }
                if (j == word.length() - 1) {
                    result += "(";
                }
            }
        }
        return result;
    }

    /**
     * checks if the first occurrence of char c within the string is the same as the last occurrence of char c. If
     * this is true then there is only one occurrence, if it's not true then there must be at least 2 occurrence of char c
     */

    public class encoderV2 {
        static String encode(String word) {
            word = word.toLowerCase();
            String result = "";
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
            }
            return result;
        }
    }

    static String encodeWithHashMap(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (map.get(c) > 1)
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }

    public static int findIt(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int counter = 1;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j] && i != j)
                    counter++;
            }

            if (counter % 2 != 0)
                return a[i];
        }
        return -1;
    }

    public static int findItBitwiseOperator(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        return xor;
    }

    /**
     * Reverse words with 5 or more letters
     */
    public static String spinWords(String sentence) {
        String[] arr = sentence.split(" ");
        StringBuilder reverser = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            if (s.length() > 4) {
                reverser.append(s).reverse();
                result.append(reverser.toString() + " ");
                reverser.setLength(0);
            } else
                result.append(s + " ");
        }

        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }


    /**
     * Remove all values from array a, which are present in array b. a - b
     */

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>(a.length);

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (b[i] != a[j])
                    result.add(a[j]);

            }
        }
        return a;
    }

    /**
     * Digital root is the recursive sum of all the digits in a number.
     *
     * Given n, take the sum of the digits of n. If that value has more than one digit,
     * continue reducing in this way until a single-digit number is produced.
     * The input will be a non-negative integer.
     * */
    public static int digital_rootV3(int n) {
        while (n > 9) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
        }
        return n;
    }

    /**
     * Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
     * For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3],
     * you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times,
     * and then take 3, which leads to [1,2,3,1,2,3].
     * With list [20,37,20,21] and number 1, the result would be [20,37,21].
     * */

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : elements) {
            int count = occurrences.getOrDefault(num, 0);
            if (count < maxOccurrences) {
                resultList.add(num);
                occurrences.put(num, count + 1);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}
