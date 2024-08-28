public class MyJVMTest_14212 {

    static int i = 3;

    static int f = 0;

    static int[] a = {0,6,0,3,7,0,-108858485,0,8,8};

    static int sz = 4;

    int dummy(int i) {
        return i * 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14212().dummy(i));
    }
}
