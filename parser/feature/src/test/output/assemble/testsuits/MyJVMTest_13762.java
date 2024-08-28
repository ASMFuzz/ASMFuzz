public class MyJVMTest_13762 {

    static Object name = 7;

    static Object value = 4;

    boolean containsAttribute(Object name, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13762().containsAttribute(name, value));
    }
}
