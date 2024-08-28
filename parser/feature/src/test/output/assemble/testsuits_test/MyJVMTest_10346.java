public class MyJVMTest_10346 {

    int m(int v) {
        return v;
    }

    static int i1 = 5;

    static int i2 = -608839195;

    Test8007294 test1() {
        Test8007294 obj = new Test8007294(10, 100);
        int v1 = obj.i1;
        int v3 = m(v1);
        int v2 = obj.i2;
        obj.i2 = v3;
        obj.i1 = v2;
        return obj;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10346().test1());
    }
}
