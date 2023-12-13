import java.util.*;
import java.util.stream.Stream;


public class CodeWars8and7Kyu {

    public static void main(String[] args) {

       List<Boolean> list = new ArrayList<>();
       list.add(true);
       list.add(Boolean.parseBoolean("Fa1Se"));
       list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list.get(1) instanceof Boolean);

    }


    public static boolean isIsogramv2(String str) {
        int counter = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j))) {
                    counter++;
                }
            }
        }
        if (counter > 0)
            return false;
        else return true;
    }

    public static boolean isIsogramv3(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }
        }

        return true;
    }



    /**
     * p0: Current population
     * percent: increase of population in %
     * aug: additional population changes (- or + )
     * p: the endpoint population number
     * ex: p0 = 1000, percent = 2, aug = 20, p = 2000
     * p0 + p0*percent + aug >= p , How many years until this is true?
     */

    public static int nbYear(int p0, double percent, int aug, int p) {
        int yearCount = 0;
        percent /= 100;

        while (p0 < p) {
            yearCount++;
            p0 += percent * p0 + aug;
        }
        return yearCount;

    }

    public static int duplicateCount(String text) {

        char[] chars = text.toLowerCase().toCharArray();
        int counter = 0;
        List<Character> characters = new ArrayList<>();
        for (char c : chars) {
            characters.add(c);

        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
            }
        }
        return 0;
    }

    public static String numberToString(int num) {
        return String.valueOf(num);
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        int counter = 0;
        for (Boolean sheep : arrayOfSheeps) {
            if (sheep != null && sheep.equals(true))
                counter++;
        }
//            Arrays.stream(arrayOfSheeps).filter(s -> s != null).filter(s -> s == true).toList().size();
        return counter;
    }

    public static String areYouPlayingBanjo(String name) {
        if (name.startsWith("R") || name.startsWith("r"))
            return name + " plays banjo";
        else
            return name + " doesn not play banjo";
    }

    public static String accum(String s) {
        //First letter after a  - should be UpperCase, Also last "-" needs to be removed
        String result = "";
        for (int i = 0; i < s.toCharArray().length; i++) {
            result = result + s.substring(i, i + 1).repeat(i + 1) + "-";
        }

        return result;
    }

    /**
     * Saves a lowercase and uppercase version of each letter. Second for loop adds the repeated letters
     * based on what position it has in the string.
     */
    public static String accumSolution(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String lower = s.substring(i, i + 1).toLowerCase();
            String upper = s.substring(i, i + 1).toUpperCase();
            res += upper;
            for (int j = 1; j <= i; j++) {
                res += lower;
            }
            if (i != s.length() - 1) {
                res += "-";
            }
        }
        return res;
    }

    public static int rentalCarCost(int d) {
        int rentCost = d * 40;

        if (d >= 7)
            return rentCost - 50;
        else if (d >= 3 && d < 7)
            return rentCost - 20;
        else
            return rentCost;
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String s = "";
        for (Integer integer : binary) {
            s += integer.toString();
        }
        return Integer.parseInt(s, 2);
    }

    public static String evenOrOdd(int number) {
        if (number % 2 == 0)
            return "even";
        else
            return "Odd";
    }

    public static String evenOrOddOneLiner(int number) {
        return (number % 2 == 0) ? "Even" : "Odd";
    }

    public static boolean validatePin(String pin) {
        // regex checks if digit betweeen 0 and 9
        if (pin.matches("[0-9]+")) {
            return (pin.length() == 4 || pin.length() == 6) ? true : false;
        } else return false;
    }

    public static int countPassengers(ArrayList<int[]> stops) {
        //An arraylist of int[], 2 ints in each array. First int== n ppl got on the bus, Second int == n ppl got off bus
        int n = 0;

        for (int i = 0; i < stops.size(); i++) {
            n += stops.get(i)[0];
            n -= stops.get(i)[1];
        }

        return n;

    }

    /**
     * Returns the vowel count of a string, a e i o u count as vowels.
     */
    public static int getVowelCount(String str) {
        int vowelsCount = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowelsCount++;
        }
        return vowelsCount;
    }

    public static int getvowelCountWithLamdba(String str) {
        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public static int getVowelCountWithRegex(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }


    /**
     * Takes int as input an squares each individual digit and then concats them, return the concated int
     */

    public static int squareDigits(int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : Integer.toString(n).toCharArray()) {
            int sqrd = Character.getNumericValue(c) * Character.getNumericValue(c);
            sb.append(sqrd);
        }
        return Integer.valueOf(sb.toString());
    }

    /**
     * Remove every vowel from String
     */

    public static String disemvowel(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'))
                sb.append(c);
        }
        return sb.toString();
    }

    public static String disemvowelWithRegex(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    /**
     * ?i makes the next part of the regex case insensitive
     */
    public static String disemvowelWithRegex2(String Z) {
        return Z.replaceAll("(?i)[aeiou]", "");
    }

    public static String highAndLow(String numbers) {
        //String[] numbersArray = numbers.split(" "); splits the string into multiple strings with space as split target
        int[] ints = Stream.of(numbers.split("\\s")).mapToInt(Integer::parseInt).sorted().toArray();

        return ints[ints.length - 1] + " " + ints[0];
    }


    public static String reverseString(String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            res += str.charAt(i);
        }
        return res;
    }

    public static String reverseString2(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static List<String> addNumberingToStringInArray(List<String> lines) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String str = i + 1 + ": " + lines.get(i);
            arr.add(str);
        }
        return arr;
    }

    public static List<String> addNumberingToStringInArray2(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, (i + 1) + ": " + lines.get(i));
        }
        return lines;
    }

    public static int findShortestWord(String s) {
        String[] arr = s.split("\\s");
        int shortestWord = arr[0].length();

        for (int i = 1; i < arr.length; i++) {
            if (shortestWord > arr[i].length())
                shortestWord = arr[i].length();
        }
        return shortestWord;
    }

    public static int findShortestWordWithStreams(String s) {
        return Stream.of(s.split(" "))
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

    public static String highAndLowWithForLoop(String numbers) {
        String[] numbersArray = numbers.split(" ");

        int biggestNumber = Integer.valueOf(numbersArray[0]);
        int smallestNumber = Integer.valueOf(numbersArray[0]);

        for (String numberString : numbersArray) {
            Integer numberInteger = Integer.valueOf(numberString);
            if (numberInteger < smallestNumber) {
                smallestNumber = numberInteger;
            }
            if (biggestNumber < numberInteger) {
                biggestNumber = numberInteger;
            }
        }
        return biggestNumber + " " + smallestNumber;
    }

    public static String highAndLow2(String numbers) {
        int[] arr = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        return arr[arr.length - 1] + " " + arr[0];
    }


    public static String getMiddle(String word) {
        int length = word.length();
        StringBuilder sb = new StringBuilder();

        if (length % 2 == 0) {
            sb.append(word.charAt(length / 2 - 1));
            sb.append(word.charAt(length / 2));
        } else {
            sb.append(word.charAt(length / 2));
        }
        return sb.toString();
    }

    public static boolean isSquare(int n) {
        long sqrtRounded = Math.round(Math.sqrt(n));

        return sqrtRounded * sqrtRounded == n;

    }
    
    /** Multiply every digit in integer continuously until left with a single digit, return count */

    public static int persistence(long n) {

        String s = Long.toString(n);
        int counter = 0;
        int x = 20;


        return counter;
    }
}





