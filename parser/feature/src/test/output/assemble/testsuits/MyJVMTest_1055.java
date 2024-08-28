public class MyJVMTest_1055 {

    static Integer x = 6;

    static Integer y = -1437389575;

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
        System.out.println(new MyJVMTest_1055().compare(x, y));
    }
}
