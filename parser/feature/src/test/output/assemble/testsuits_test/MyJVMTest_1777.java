public class MyJVMTest_1777 {

    static int i = 281439152;

    int testb(int i) {
        Integer ib = i;
        if ((i & 1) == 0)
            ib = (i + 1);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1777().testb(i));
    }
}
