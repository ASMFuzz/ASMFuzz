public class MyJVMTest_16363 {

    static Object o1 = 3;

    static Object o2 = 6;

    Object assertEquals(Object o1, Object o2) {
        System.out.print("Expected: " + o1);
        System.out.println(", Obtained: " + o2);
        if (!o1.equals(o2)) {
            throw new RuntimeException("got unexpected values");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16363().assertEquals(o1, o2);
    }
}
