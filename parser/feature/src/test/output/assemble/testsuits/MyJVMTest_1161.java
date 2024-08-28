public class MyJVMTest_1161 {

    static int i = 0;

    static int f = 9;

    static int[] a = {3,0,1213471665,6,1488328594,0,2,-426248804,-1980322738,-667265645};

    static int sz = 1;

    static O o = null;

    int put(int i) {
        a[i % a.length] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1161().put(i);
    }
}
