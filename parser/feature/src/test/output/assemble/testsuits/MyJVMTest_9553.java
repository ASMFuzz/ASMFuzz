public class MyJVMTest_9553 {

    void methodToLookFor() {
        try {
            try {
                ;
            } finally {
            }
        } finally {
            System.out.println("STR_TO_LOOK_FOR");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9553().methodToLookFor();
    }
}
