public class MyJVMTest_4624 {

    boolean testObject() {
        return Object.class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4624().testObject());
    }
}
