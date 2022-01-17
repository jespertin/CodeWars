import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        boolean check = isValid2("({)");
        System.out.println(check);
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if (c==')'&& !stack.isEmpty()&&stack.peek()=='('){
                stack.pop();
            }else if (c=='}'&& !stack.isEmpty()&&stack.peek()=='{'){
                stack.pop();
            }else if (c==']'&& !stack.isEmpty()&&stack.peek()=='['){
                stack.pop();
            }
            else{
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static boolean isValid(String s) {
        // [] true, {[]} true, ([)] false
        if (s.charAt(0) == ']' || s.charAt(0) == ')' || s.charAt(0) == '}')
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' && s.charAt(i + 1) == ')' || s.charAt(i + 1) == '}')
                return false;
            else if (s.charAt(i) == '{' && s.charAt(i + 1) == ')' || s.charAt(i + 1) == ']')
                return false;
            else if (s.charAt(i) == '(' && s.charAt(i + 1) == ']' || s.charAt(i + 1) == '}')
                return false;
        }
        int middle = s.length() - (s.length() / 2) - 1;

        String[] partsCurly = null;
        String[] partsBracket = null;
        String[] partsParenthesis = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                partsCurly = s.split("(?<=})");
            }
            if (s.charAt(i) == '[') {
                partsBracket = s.split("(?<=])");
            }
            if (s.charAt(i) == '(') {
                partsParenthesis = s.split("(?<=)");
            }
        }

        System.out.println(partsBracket.getClass().toGenericString());

        return true;
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[i];
                if (complement == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("failed to find match");
    }

    public static boolean isPalindrome(int x) {
        String x2 = String.valueOf(x);
        StringBuffer sb = new StringBuffer(x2);
        if (x2.equals(sb.reverse().toString()))
            return true;
        else
            return false;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                result += map.get(s.charAt(i));

            }
        }
        return result;
    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int totalSum = 0;
        for (int j = 0; j < chars.length; j++) {
            switch (chars[j]) {
                case 'I' -> {
                    if (chars[j + 1] == 'v' || chars[j + 1] == 'x')
                        totalSum = totalSum - 1;
                    else
                        totalSum = totalSum + 1;
                }

                case 'V' -> totalSum = totalSum + 5;

                case 'X' -> {

                    if (chars[j + 1] == 'l' || chars[j + 1] == 'c')
                        totalSum = totalSum - 10;
                    else
                        totalSum = totalSum + 10;
                }

                case 'L' -> totalSum = totalSum + 50;

                case 'C' -> {
                    if (chars[j + 1] == 'd' || chars[j + 1] == 'm')
                        totalSum = totalSum - 100;
                    else
                        totalSum = totalSum + 100;
                }

                case 'D' -> totalSum = totalSum + 500;
                case 'M' -> totalSum = totalSum + 1000;

            }
        }
        return totalSum;
    }
}

