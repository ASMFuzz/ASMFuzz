public class MyJVMTest_5610 {

    static char[] array = {Character.MAX_VALUE,'Q',Character.MAX_VALUE,'0','U','0',Character.MIN_VALUE,Character.MAX_VALUE,'0',Character.MIN_VALUE};

    static int LEN = 1024;

    void vectorizeNaNDP() {
        for (int i = 0; i < LEN; ++i) {
            array[i] = 0xfff7;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5610().vectorizeNaNDP();
    }
}
