public class MyJVMTest_16443 {

    static int a = 3;

    static int b = 5;

    int checkMethod(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16443().checkMethod(a, b));
    }
}
