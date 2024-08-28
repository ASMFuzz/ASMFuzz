public class MyJVMTest_15693 {

    static int n = 0;

    int doWork(int n) {
        if (n > 0)
            return n;
        else
            return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15693().doWork(n));
    }
}
