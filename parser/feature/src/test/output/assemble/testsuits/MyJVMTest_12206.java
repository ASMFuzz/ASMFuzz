public class MyJVMTest_12206 {

    static int value = 9;

    int unchecked(int value) {
        return -value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12206().unchecked(value));
    }
}
