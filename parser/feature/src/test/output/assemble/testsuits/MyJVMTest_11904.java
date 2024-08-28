public class MyJVMTest_11904 {

    static long counter = 0;

    void add() {
        counter++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11904().add();
    }
}
