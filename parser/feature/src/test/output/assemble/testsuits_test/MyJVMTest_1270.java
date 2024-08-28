public class MyJVMTest_1270 {

    static int i = 1;

    int test2(int i) {
        Integer ib1 = new Integer(i);
        Integer ib2 = new Integer(i + 1);
        if ((i & 1) == 0) {
            ib1 = new Integer(i + 1);
            ib2 = new Integer(i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1270().test2(i));
    }
}
