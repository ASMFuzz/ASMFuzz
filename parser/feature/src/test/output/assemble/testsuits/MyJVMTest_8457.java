public class MyJVMTest_8457 {

    void methodToLookFor() {
        try {
        } finally {
            System.out.println("STR_TO_LOOK_FOR");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8457().methodToLookFor();
    }
}
