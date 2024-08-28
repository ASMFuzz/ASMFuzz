public class MyJVMTest_17079 {

    static int initialValue = 0;

    int runLinCon(int initialValue) {
        int temp = (initialValue * RAND_MULT) + RAND_ADD;
        return temp;
    }

    static int RAND_MULT = 1103515245;

    static int RAND_ADD = 12345;

    int scrambleSeed(int initialValue) {
        int seed = initialValue;
        for (int i = 0; i < 41; ++i) {
            seed = runLinCon(seed);
        }
        return seed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17079().scrambleSeed(initialValue));
    }
}
