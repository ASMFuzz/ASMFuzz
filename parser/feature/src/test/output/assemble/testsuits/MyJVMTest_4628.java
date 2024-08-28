public class MyJVMTest_4628 {

    static TestSyntheticNullChecks outer = null;

    TestSyntheticNullChecks generateSyntheticNPE(TestSyntheticNullChecks outer) {
        outer.new Inner();
        return outer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4628().generateSyntheticNPE(outer);
    }
}
