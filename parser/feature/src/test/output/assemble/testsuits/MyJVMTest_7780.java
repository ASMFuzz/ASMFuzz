public class MyJVMTest_7780 {

    static Object[] aArray = { 0, -103641615, -1536019662, 1, 8, 5, -437377854, 0, 6, 9 };

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
        new MyJVMTest_7780().test(aArray);
    }
}
