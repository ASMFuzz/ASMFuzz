public class MyJVMTest_14014 {

    boolean testObject() {
        return Object.class.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14014().testObject());
    }
}
