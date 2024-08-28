public class MyJVMTest_15261 {

    String helpVoidFER() {
        return "test forced return of a void method";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15261().helpVoidFER());
    }
}
