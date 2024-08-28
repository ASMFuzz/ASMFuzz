public class MyJVMTest_3748 {

    static String name = "M6m\\>P%J){";

    boolean containsControlChar(String name) {
        byte[] bytes = name.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < 32) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3748().containsControlChar(name));
    }
}
