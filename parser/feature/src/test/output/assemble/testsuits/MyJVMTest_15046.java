public class MyJVMTest_15046 {

    static char[] array = {Character.MIN_VALUE,Character.MAX_VALUE,'U',Character.MIN_VALUE,Character.MAX_VALUE,'0','0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE};

    static int LEN = 1024;

    void vectorizeNaNDP() {
        for (int i = 0; i < LEN; ++i) {
            array[i] = 0xfff7;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15046().vectorizeNaNDP();
    }
}
