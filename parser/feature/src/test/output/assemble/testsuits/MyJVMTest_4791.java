public class MyJVMTest_4791 {

    static Class<?> staticClassChar = char.class;

    boolean testChar() {
        return staticClassChar.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4791().testChar());
    }
}
