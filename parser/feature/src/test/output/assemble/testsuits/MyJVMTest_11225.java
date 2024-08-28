public class MyJVMTest_11225 {

    static int i = 3;

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
        System.out.println(new MyJVMTest_11225().testc2(i));
    }
}
