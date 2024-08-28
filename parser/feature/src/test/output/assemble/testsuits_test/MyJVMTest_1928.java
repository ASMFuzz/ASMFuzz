public class MyJVMTest_1928 {

    static int i = 8;

    static Integer ib = 5;

    int testp(int i, Integer ib) {
        if ((i & 1) == 0)
            ib = new Integer(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1928().testp(i, ib));
    }
}
