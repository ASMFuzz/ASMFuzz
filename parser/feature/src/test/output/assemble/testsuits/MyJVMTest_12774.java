public class MyJVMTest_12774 {

    static int start = 4;

    static int stop = 0;

    int test2(int start, int stop) {
        int sum = 0;
        int i = start;
        do {
            synchronized (new Object()) {
            }
            sum += i;
            i--;
        } while (i >= stop);
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12774().test2(start, stop));
    }
}
