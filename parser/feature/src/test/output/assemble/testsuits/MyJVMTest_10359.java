public class MyJVMTest_10359 {

    static int i = 0;

    static int f = -262720344;

    static int[] a = {2082467900,1661018586,1683716547,1115699954,1,3,4,1,8,0};

    static int sz = 8;

    static O o = null;

    int put(int i) {
        a[i % a.length] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10359().put(i);
    }
}
