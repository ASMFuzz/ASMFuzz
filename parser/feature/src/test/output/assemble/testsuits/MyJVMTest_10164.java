public class MyJVMTest_10164 {

    String getClassVersion() {
        return "redefined";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10164().getClassVersion());
    }
}
