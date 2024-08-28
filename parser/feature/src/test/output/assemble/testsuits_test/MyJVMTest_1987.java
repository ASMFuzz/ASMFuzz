public class MyJVMTest_1987 {

    static int i = 0;

    static Integer ibc = new Integer(1);

    int testc2(int i) {
        Integer ib1 = ibc;
        Integer ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = (ibc + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1987().testc2(i));
    }
}
