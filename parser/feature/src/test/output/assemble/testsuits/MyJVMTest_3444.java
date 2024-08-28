public class MyJVMTest_3444 {

    static int start = 6;

    static int stop = 1423368162;

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
        System.out.println(new MyJVMTest_3444().test2(start, stop));
    }
}
