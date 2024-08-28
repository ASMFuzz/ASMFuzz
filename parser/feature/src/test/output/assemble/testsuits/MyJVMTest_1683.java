public class MyJVMTest_1683 {

    static int i = 0;

    static Integer ibc = new Integer(1);

    int testc(int i) {
        Integer ib = ibc;
        if ((i & 1) == 0)
            ib = new Integer(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1683().testc(i));
    }
}
