public class MyJVMTest_7591 {

    static int i = 3;

    int testm(int i) {
        Integer ib = i;
        if ((i & 1) == 0)
            ib = new Integer(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7591().testm(i));
    }
}
