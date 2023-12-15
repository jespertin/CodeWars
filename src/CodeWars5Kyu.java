public class CodeWars5Kyu {

    public static void main(String[] args) {

    }

    /**
     * The rgb function is incomplete. Complete it so that passing in RGB decimal values will result in
     * a hexadecimal representation being returned.
     * Valid decimal values for RGB are 0 - 255.
     * Any values that fall out of that range must be rounded to the closest valid value.
     *
     * Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
     * */
    public static String rgb(int r, int g, int b) {
        r = Math.min(Math.max(0, r), 255);
        g = Math.min(Math.max(0, g), 255);
        b = Math.min(Math.max(0, b), 255);

        String hexR = Integer.toHexString(r).toUpperCase();
        String hexG = Integer.toHexString(g).toUpperCase();
        String hexB = Integer.toHexString(b).toUpperCase();

        hexR = hexR.length() < 2 ? "0" + hexR : hexR;
        hexG = hexG.length() < 2 ? "0" + hexG : hexG;
        hexB = hexB.length() < 2 ? "0" + hexB : hexB;

        return hexR + hexG + hexB;
    }
}
