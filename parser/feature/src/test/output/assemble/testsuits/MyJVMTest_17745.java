public class MyJVMTest_17745 {

    static int i = 1;

    int testb2(int i) {
        Integer ib1 = i;
        Integer ib2 = i + 1;
        if ((i & 1) == 0) {
            ib1 = (i + 1);
            ib2 = (i + 2);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17745().testb2(i));
    }
}
