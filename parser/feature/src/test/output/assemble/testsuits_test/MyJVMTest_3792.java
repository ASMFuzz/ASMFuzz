public class MyJVMTest_3792 {

    String moo() {
        return "moo";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3792().moo());
    }
}
