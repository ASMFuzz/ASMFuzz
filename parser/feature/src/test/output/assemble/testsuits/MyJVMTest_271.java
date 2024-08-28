public class MyJVMTest_271 {

    static Class<?> staticClassInt = int.class;

    boolean testInt() {
        return staticClassInt.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_271().testInt());
    }
}
