public class MyJVMTest_13821 {

    static char[] array = {Character.MIN_VALUE,Character.MAX_VALUE,'0','S',Character.MIN_VALUE,':',Character.MIN_VALUE,'}',Character.MAX_VALUE,Character.MAX_VALUE};

    static int LEN = 1024;

    void vectorizeNaNSP() {
        for (int i = 0; i < LEN; ++i) {
            array[i] = 0xff80;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13821().vectorizeNaNSP();
    }
}
