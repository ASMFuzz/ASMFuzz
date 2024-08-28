public class MyJVMTest_11001 {

    static int i = 885494917;

    int testb(int i) {
        Integer ib = i;
        if ((i & 1) == 0)
            ib = (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11001().testb(i));
    }
}
