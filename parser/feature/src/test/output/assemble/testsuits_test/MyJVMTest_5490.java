public class MyJVMTest_5490 {

    static String text = "j]}K\\(sk%2";

    static int i = -339176963;

    static short elem = 0;

    static short val = -32768;

    int verify(String text, int i, short elem, short val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5490().verify(text, i, elem, val));
    }
}
