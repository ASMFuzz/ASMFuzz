public class MyJVMTest_9355 {

    static int i = 0;

    int testm2(int i) {
        Integer ib1 = new Integer(i);
        Integer ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = new Integer(i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9355().testm2(i));
    }
}
