public class MyJVMTest_4438 {

    static char[] array = {'0','Y',Character.MIN_VALUE,'0',Character.MAX_VALUE,'0','O','0',Character.MAX_VALUE,Character.MIN_VALUE};

    static int LEN = 1024;

    void vectorizeNaNSP() {
        for (int i = 0; i < LEN; ++i) {
            array[i] = 0xff80;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4438().vectorizeNaNSP();
    }
}
