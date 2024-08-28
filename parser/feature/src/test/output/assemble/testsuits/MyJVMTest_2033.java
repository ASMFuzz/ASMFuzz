public class MyJVMTest_2033 {

    static int a = 0;

    static int b = 0;

    int checkMethod(int a, int b) {
        return Math.addExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2033().checkMethod(a, b));
    }
}
