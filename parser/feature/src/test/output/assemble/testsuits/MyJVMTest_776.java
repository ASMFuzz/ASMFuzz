public class MyJVMTest_776 {

    static int i = 9;

    static int f = 0;

    static int[] a = {9,907986875,1969822836,0,1,8,394274621,1490388330,0,543354018};

    static int sz = 781485576;

    static O o = null;

    int put(int i) {
        a[i % sz] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_776().put(i);
    }
}
