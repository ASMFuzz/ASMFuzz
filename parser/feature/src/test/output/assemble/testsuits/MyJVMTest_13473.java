public class MyJVMTest_13473 {

    static int field = 3;

    int getMinimum(int field) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13473().getMinimum(field));
    }
}
