import t.WarnWrongYieldTest.yield;

public class MyJVMTest_1376 {

    static int i = 1;

    static String[] yield = null;

    static yield y = null;

    int[] yieldLocalVar2(int i) {
        int[] yield = new int[1];
        yield[0] = 5;
        return yield;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1376().yieldLocalVar2(i);
    }
}
