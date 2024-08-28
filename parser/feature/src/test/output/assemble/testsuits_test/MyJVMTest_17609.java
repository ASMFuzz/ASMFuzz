public class MyJVMTest_17609 {

    static int[] a = { -969222355, 2, 1447876026, 4, 0, 935250151, -179986224, 0, 0, 8 };

    int summ2(int[] a) {
        Integer result1 = 1;
        Integer result2 = new Integer(1);
        for (Integer i : a) {
            result1 += i;
            result2 += new Integer(i + 1);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17609().summ2(a));
    }
}
