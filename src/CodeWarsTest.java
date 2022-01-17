import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWarsTest {

    public static void main(String[] args) {

        Boolean[] bools = {true,  true,  true,  false,
                true,  true,  true,  true ,
                true,  false, true,  false,
                true,  false, false, true ,
                true,  true,  true,  true ,
                false, false, false, null};


        System.out.println(countSheeps(bools));


    }

    public static boolean isIsogram(String str) {
        char[] arr = str.toCharArray();
        System.out.println(arr);
        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Character.toLowerCase(arr[i])==Character.toLowerCase(arr[j])) {
                    counter++;
                }
            }
        }
        if (counter>0)
            return false;
        else return true;
    }

    public static boolean isIsogram2(String str){
        return str.length()==str.toLowerCase().chars().distinct().count();
    }

    public static int duplicateCount(String text){

        char[] chars = text.toLowerCase().toCharArray();
        int counter = 0;
        List<Character> characters = new ArrayList<>();
        for (char c: chars) {
            characters.add(c);

        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
            }
        }
        return 0;
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


}
