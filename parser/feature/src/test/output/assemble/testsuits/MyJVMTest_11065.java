public class MyJVMTest_11065 {

    String Greeting() {
        return new String(", how are you?");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11065().Greeting());
    }
}
