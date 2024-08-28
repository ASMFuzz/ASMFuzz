public class MyJVMTest_13087 {

    static String name = "{KEVYIEhF=";

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
        System.out.println(new MyJVMTest_13087().containsControlChar(name));
    }
}
