public class MyJVMTest_13331 {

    static int x = 0;

    static int[] data = {0,9,2,549811859,6,-1217903254,3,0,0,7};

    static int size = 0;

    int hash(int x) {
        x ^= (x << 21);
        x ^= (x >>> 31);
        x ^= (x << 4);
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13331().hash(x));
    }
}
