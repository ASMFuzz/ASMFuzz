public class MyJVMTest_4031 {

    void m() {
        try {
            System.out.println("EMPTY TRY!");
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4031().m();
    }
}
