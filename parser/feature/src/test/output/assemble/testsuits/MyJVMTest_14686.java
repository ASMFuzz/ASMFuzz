public class MyJVMTest_14686 {

    static int i = 654293242;

    static Integer ib1 = 0;

    int testp2(int i, Integer ib1) {
        Integer ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = new Integer(i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14686().testp2(i, ib1));
    }
}
