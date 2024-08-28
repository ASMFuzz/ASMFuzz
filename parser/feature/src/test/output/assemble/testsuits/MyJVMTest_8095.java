public class MyJVMTest_8095 {

    static int start = 6;

    static int stop = 4;

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
        System.out.println(new MyJVMTest_8095().test1(start, stop));
    }
}
