public class MyJVMTest_5782 {

    static int field = 1;

    static int amount = 0;

    int add(int field, int amount) {
        throw new UnsupportedOperationException("Not supported yet.");
        return field;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5782().add(field, amount);
    }
}
