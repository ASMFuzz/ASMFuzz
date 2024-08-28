public class MyJVMTest_2907 {

    static int value = 742383212;

    int unchecked(int value) {
        return -value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2907().unchecked(value));
    }
}
