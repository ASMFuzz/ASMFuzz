public class MyJVMTest_3398 {

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
        System.out.println(new MyJVMTest_3398().test1());
    }
}
