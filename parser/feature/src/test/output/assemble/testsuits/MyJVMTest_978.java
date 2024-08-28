public class MyJVMTest_978 {

    String getClassVersion() {
        return "redefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_978().getClassVersion());
    }
}
