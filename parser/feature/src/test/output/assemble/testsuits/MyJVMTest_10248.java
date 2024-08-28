public class MyJVMTest_10248 {

    static Integer x = 8;

    static Integer y = 0;

    int compare(Integer x, Integer y) {
        int i = x.intValue();
        int j = y.intValue();
        if (i < j)
            return -1;
        if (i > j)
            return 1;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10248().compare(x, y));
    }
}
