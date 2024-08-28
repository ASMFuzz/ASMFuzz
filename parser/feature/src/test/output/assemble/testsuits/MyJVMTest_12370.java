public class MyJVMTest_12370 {

    boolean assertsEnabled() {
        boolean enabled = false;
        assert enabled = true;
        return enabled;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12370().assertsEnabled());
    }
}
