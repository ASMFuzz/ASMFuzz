public class MyJVMTest_2197 {

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
        new MyJVMTest_2197().test();
    }
}
