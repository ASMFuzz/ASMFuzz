public class MyJVMTest_8639 {

    void methodToLookFor() {
        try {
            ;
        } finally {
            System.out.println("STR_TO_LOOK_FOR");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8639().methodToLookFor();
    }
}
