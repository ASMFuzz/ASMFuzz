public class MyJVMTest_11605 {

    static int value = 4;

    int checkMethod(int value) {
        return Math.decrementExact(value);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11605().checkMethod(value));
    }
}
