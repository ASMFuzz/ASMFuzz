public class MyJVMTest_3980 {

    static int x = -1792511587;

    static int[] data = {2,0,0,-1552695284,4,8,8,3,9,0};

    static int size = 791151927;

    int hash(int x) {
        x ^= (x << 21);
        x ^= (x >>> 31);
        x ^= (x << 4);
        return x;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3980().hash(x));
    }
}
