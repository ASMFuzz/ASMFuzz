public class MyJVMTest_15042 {

    static int dmChanges = 1;

    void incDmChanges() {
        dmChanges++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15042().incDmChanges();
    }
}
