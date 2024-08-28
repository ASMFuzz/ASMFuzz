public class MyJVMTest_10270 {

    static Class<?> staticClassObject = Object.class;

    boolean testObject() {
        return staticClassObject.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10270().testObject());
    }
}
