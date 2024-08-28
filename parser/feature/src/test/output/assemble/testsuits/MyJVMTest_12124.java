public class MyJVMTest_12124 {

    int size() {
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12124().size());
    }
}
