public class MyJVMTest_1070 {

    static int i = 3;

    int simplem2(int i) {
        Integer ib1 = new Integer(i);
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1070().simplem2(i));
    }
}
