public class MyJVMTest_9038 {

    void m() {
        try {
            System.out.println("EMPTY TRY!");
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9038().m();
    }
}
