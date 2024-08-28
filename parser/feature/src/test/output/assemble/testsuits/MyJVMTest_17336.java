public class MyJVMTest_17336 {

    static Object[] aArray = { 6, 0, 4, 0, -1248440850, 9, 79226202, 0, -500366477, 4 };

    Object[] test(Object[] aArray) {
        Object a = new Object();
        try {
            System.arraycopy(aArray, 0, a, 0, 1);
            throw new RuntimeException("FAILED: Expected ArrayStoreException " + "(due to destination not being an array) " + "was not thrown");
        } catch (ArrayStoreException e) {
            System.out.println("PASSED: Expected ArrayStoreException was thrown");
        }
        try {
            System.arraycopy(a, 0, aArray, 0, 1);
            throw new RuntimeException("FAILED: Expected ArrayStoreException " + "(due to source not being an array) " + "was not thrown");
        } catch (ArrayStoreException e) {
            System.out.println("PASSED: Expected ArrayStoreException was thrown");
        }
        return aArray;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17336().test(aArray);
    }
}
