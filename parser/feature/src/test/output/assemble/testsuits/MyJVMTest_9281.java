public class MyJVMTest_9281 {

    String helpLongFER() {
        return "test forced return of correct long value";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9281().helpLongFER());
    }
}
