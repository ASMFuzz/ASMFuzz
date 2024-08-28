public class MyJVMTest_10838 {

    static int i = 9;

    int simple2(int i) {
        Integer ib1 = new Integer(i);
        Integer ib2 = new Integer(i + 1);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10838().simple2(i));
    }
}
