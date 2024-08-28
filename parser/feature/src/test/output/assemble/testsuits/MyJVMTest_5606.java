public class MyJVMTest_5606 {

    static int dmChanges = 8;

    void incDmChanges() {
        dmChanges++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5606().incDmChanges();
    }
}
