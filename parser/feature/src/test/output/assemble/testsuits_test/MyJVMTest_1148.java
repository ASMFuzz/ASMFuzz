public class MyJVMTest_1148 {

    static int a = 979080433;

    static int b = 6;

    int unchecked(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1148().unchecked(a, b));
    }
}
