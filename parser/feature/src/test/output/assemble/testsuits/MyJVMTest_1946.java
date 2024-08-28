import java.util.Arrays;

public class MyJVMTest_1946 {

    static String in = "ISD=7\"/Qtf";

    byte[] getBytes(String in) {
        byte[] arr = null;
        if (in.equals("content")) {
            arr = new byte[65536];
            byte j = 32;
            for (int i = 0; i < 65536; i++) {
                arr[i] = j;
                if (++j == 127)
                    j = 32;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_1946().getBytes(in)));
    }
}
