public class MyJVMTest_17665 {

    static int start = 4;

    static int stop = 0;

    int test1(int start, int stop) {
        int sum = 0;
        int i = start;
        do {
            synchronized (new Object()) {
            }
            sum += i;
            i++;
        } while (i < stop);
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17665().test1(start, stop));
    }
}
