public class MyJVMTest_1839 {

    String Greeting() {
        return new String(", how are you?");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1839().Greeting());
    }
}
