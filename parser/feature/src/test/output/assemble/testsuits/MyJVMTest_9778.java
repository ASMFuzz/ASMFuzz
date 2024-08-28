public class MyJVMTest_9778 {

    static ThreadLocal<String> other = null;

    String initialValue() {
        other = new ThreadLocal<String>();
        other.set("Other");
        return "Initial";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9778().initialValue());
    }
}
