public class MyJVMTest_16079 {

    static int i = 0;

    static int[] a = {213589477,0,-1918730849,2,0,0,2,416805970,-656977292,0};

    int put(int i) {
        a[i % a.length] = i;
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16079().put(i);
    }
}
