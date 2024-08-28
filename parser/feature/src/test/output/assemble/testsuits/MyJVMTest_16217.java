public class MyJVMTest_16217 {

    String getSomething() {
        return "Something value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16217().getSomething());
    }
}
