public class MyJVMTest_5433 {

    void goo() {
        Integer i = 100;
        do {
            break;
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5433().goo();
    }
}
