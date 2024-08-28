public class MyJVMTest_11589 {

    static Object[] exceptionTable = { 5, 8, 8, 3, 0, 0, 0, 4, 0, 0 };

    int bucketsInuse(Object[] exceptionTable) {
        int count = 0;
        for (Object x : exceptionTable) if (x != null)
            count++;
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11589().bucketsInuse(exceptionTable));
    }
}
