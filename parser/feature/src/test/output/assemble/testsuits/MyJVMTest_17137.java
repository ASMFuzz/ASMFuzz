public class MyJVMTest_17137 {

    static int i = 7;

    int testm(int i) {
        Integer ib = i;
        if ((i & 1) == 0)
            ib = new Integer(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17137().testm(i));
    }
}
