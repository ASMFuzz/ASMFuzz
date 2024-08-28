public class MyJVMTest_14728 {

    static int field = 6;

    int getMaximum(int field) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14728().getMaximum(field));
    }
}
