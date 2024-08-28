public class MyJVMTest_9201 {

    int doesNotExist() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9201().doesNotExist());
    }
}
