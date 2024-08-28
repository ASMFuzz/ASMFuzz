public class MyJVMTest_13384 {

    void m() {
        try {
            System.out.println("EMPTY TRY!");
        } finally {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13384().m();
    }
}
