public class MyJVMTest_4026 {

    Local g() {
        return new Local();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4026().g());
    }
}
