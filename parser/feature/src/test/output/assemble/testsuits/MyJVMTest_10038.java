public class MyJVMTest_10038 {

    String getB() {
        return "hello";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10038().getB());
    }
}
