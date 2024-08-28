public class MyJVMTest_8758 {

    void methodToLookFor() {
        try {
            try {
                ;
            } catch (Exception e) {
            } finally {
            }
        } catch (Exception e) {
            System.out.println("EXCEPTION");
        } finally {
            System.out.println("STR_TO_LOOK_FOR");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8758().methodToLookFor();
    }
}
