public class MyJVMTest_6857 {

    static Object o1 = -1266047249;

    static Object o2 = 1400534334;

    Object assertEquals(Object o1, Object o2) {
        System.out.print("Expected: " + o1);
        System.out.println(", Obtained: " + o2);
        if (!o1.equals(o2)) {
            throw new RuntimeException("got unexpected values");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6857().assertEquals(o1, o2);
    }
}
