public class MyJVMTest_9097 {

    int size() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9097().size());
    }
}
