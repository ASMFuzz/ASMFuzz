public class MyJVMTest_611 {

    static ThreadLocal<String> other = null;

    String initialValue() {
        other = new ThreadLocal<String>();
        other.set("Other");
        return "Initial";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_611().initialValue());
    }
}
