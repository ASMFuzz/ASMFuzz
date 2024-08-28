public class MyJVMTest_14190 {

    static Class<?> staticClassChar = char.class;

    boolean testChar() {
        return staticClassChar.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14190().testChar());
    }
}
