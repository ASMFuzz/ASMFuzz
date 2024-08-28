public class MyJVMTest_14018 {

    static TestSyntheticNullChecks outer = null;

    TestSyntheticNullChecks generateSyntheticNPE(TestSyntheticNullChecks outer) {
        outer.new Inner();
        return outer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14018().generateSyntheticNPE(outer);
    }
}
