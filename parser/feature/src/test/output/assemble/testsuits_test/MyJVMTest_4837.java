public class MyJVMTest_4837 {

    static int a = -1933708645;

    static int b = 4;

    int f3(int a, int b) {
        if (a == b) {
        }
        System.out.println("a == b");
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4837().f3(a, b);
    }
}
