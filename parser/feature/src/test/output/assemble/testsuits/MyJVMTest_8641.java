public class MyJVMTest_8641 {

    void methodToLookFor() {
        try {
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        } finally {
            System.out.println("STR_TO_LOOK_FOR");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8641().methodToLookFor();
    }
}
