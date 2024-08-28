public class MyJVMTest_10263 {

    static int i = 9;

    int simplem2(int i) {
        Integer ib1 = new Integer(i);
        Integer ib2 = Integer.valueOf(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10263().simplem2(i));
    }
}
