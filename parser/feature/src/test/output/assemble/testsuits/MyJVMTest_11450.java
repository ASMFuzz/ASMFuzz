public class MyJVMTest_11450 {

    static int stop = 100;

    void test() {
        Object o1 = null;
        for (int i = 0; i < stop; i++) {
            try {
                Object o = new TestSubTypeCheckMacroNodeWrongMem();
                o1.equals(o);
            } catch (NullPointerException npe) {
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11450().test();
    }
}
