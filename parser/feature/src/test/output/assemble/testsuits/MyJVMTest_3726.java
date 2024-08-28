public class MyJVMTest_3726 {

    static int v = 0;

    int test1(int v) {
        return v * Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3726().test1(v));
    }
}
