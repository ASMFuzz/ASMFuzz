public class MyJVMTest_6583 {

    static int i = 3;

    static int[] a = {0,7,3,0,6,-989189654,0,2,0,-687042268};

    int put(int i) {
        a[i % a.length] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6583().put(i);
    }
}
