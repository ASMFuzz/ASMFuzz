public class MyJVMTest_6933 {

    static int a = 2;

    static int b = 1370134155;

    int checkMethod(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6933().checkMethod(a, b));
    }
}
