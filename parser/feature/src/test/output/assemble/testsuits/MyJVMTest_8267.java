public class MyJVMTest_8267 {

    static long i = 0;

    long testb2(long i) {
        Long ib1 = i;
        Long ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = (i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8267().testb2(i));
    }
}
