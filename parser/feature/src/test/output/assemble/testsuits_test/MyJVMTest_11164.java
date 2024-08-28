public class MyJVMTest_11164 {

    static int i = 5;

    static Integer ib = -1039732719;

    int testp(int i, Integer ib) {
        if ((i & 1) == 0)
            ib = new Integer(i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11164().testp(i, ib));
    }
}
