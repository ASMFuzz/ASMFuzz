public class MyJVMTest_14862 {

    void goo() {
        Integer i = 100;
        do {
            break;
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14862().goo();
    }
}
