public class MyJVMTest_3059 {

    boolean assertsEnabled() {
        boolean enabled = false;
        assert enabled = true;
        return enabled;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3059().assertsEnabled());
    }
}
