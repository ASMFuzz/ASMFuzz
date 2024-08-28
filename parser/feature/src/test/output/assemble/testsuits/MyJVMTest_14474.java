public class MyJVMTest_14474 {

    static Class<?> classChar = char.class;

    boolean testChar() {
        return classChar.isPrimitive();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14474().testChar());
    }
}
