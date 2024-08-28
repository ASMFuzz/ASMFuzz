public class MyJVMTest_2329 {

    static Object[] exceptionTable = { 0, 7, 2128995351, 1, 4, 2, 3, 630164425, 7, 0 };

    int bucketsInuse(Object[] exceptionTable) {
        int count = 0;
        for (Object x : exceptionTable) if (x != null)
            count++;
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2329().bucketsInuse(exceptionTable));
    }
}
