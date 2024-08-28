public class MyJVMTest_12728 {

    String test1() {
        String ret = null;
        try (ResCloseable tr = new ResCloseable(new ResCloseable("throw from inner resource ctor", 3))) {
            ret = "FAIL";
        } catch (RuntimeException re) {
            ret = re.getMessage();
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12728().test1());
    }
}
