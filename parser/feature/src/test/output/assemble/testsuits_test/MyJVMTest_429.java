public class MyJVMTest_429 {

    void foo() {
        boolean assertionStatus = false;
        assert assertionStatus = true;
        if (!assertionStatus) {
            throw new Error("Assertions are not enabled before initialization as they should be.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_429().foo();
    }
}
