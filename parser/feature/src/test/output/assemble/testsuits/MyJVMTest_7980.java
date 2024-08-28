public class MyJVMTest_7980 {

    static int i = 480079501;

    static int sz = -1900225390;

    static int[] a = {2,6,0,0,-95186080,8,0,9,0,8};

    int put(int i) {
        a[i % sz] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7980().put(i);
    }
}
