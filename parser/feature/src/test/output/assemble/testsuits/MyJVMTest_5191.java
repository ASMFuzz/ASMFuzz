public class MyJVMTest_5191 {

    static TwrMultiCatch twrMultiCatch = null;

    static Class<? extends Exception> expected = null;

    static Class<? extends Exception> exceptionClass = null;

    Class<? extends Exception> test(TwrMultiCatch twrMultiCatch, Class<? extends Exception> expected) {
        try (TwrMultiCatch tmc = twrMultiCatch) {
            System.out.println(tmc.toString());
        } catch (CustomCloseException1 | CustomCloseException2 exception) {
            if (!exception.getClass().equals(expected)) {
                throw new RuntimeException("Unexpected catch!");
            }
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5191().test(twrMultiCatch, expected);
    }
}
