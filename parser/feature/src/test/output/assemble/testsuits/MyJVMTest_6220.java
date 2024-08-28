public class MyJVMTest_6220 {

    static int n = 1;

    int doWork(int n) {
        if (n > 0)
            return n;
        else
            return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6220().doWork(n));
    }
}
