public class MyJVMTest_15226 {

    static int field = 5;

    static int amount = 1;

    int add(int field, int amount) {
        throw new UnsupportedOperationException("Not supported yet.");
        return field;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15226().add(field, amount);
    }
}
