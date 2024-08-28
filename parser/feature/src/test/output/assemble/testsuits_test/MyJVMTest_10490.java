public class MyJVMTest_10490 {

    static int n = 5;

    static double sum = 0;

    static double least = Double.MIN_VALUE;

    static int number = 0;

    Long[] forceMem(int n) {
        Long[] junk = new Long[n];
        for (int i = 0; i < junk.length; ++i) junk[i] = new Long(i);
        int sum = 0;
        for (int i = 0; i < junk.length; ++i) sum += (int) (junk[i].longValue() + i);
        if (sum == 0)
            System.out.println("Useless number = " + sum);
        junk = null;
        return junk;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10490().forceMem(n);
    }
}
