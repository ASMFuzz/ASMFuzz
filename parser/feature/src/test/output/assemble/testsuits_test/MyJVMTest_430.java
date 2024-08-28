public class MyJVMTest_430 {

    boolean isCorrect() {
        return true;
    }

    void check() {
        if (!isCorrect())
            throw new Error();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_430().check();
    }
}
