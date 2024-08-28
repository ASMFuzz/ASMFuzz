public class MyJVMTest_16937 {

    static int c = -2035272596;

    static a[] i = { new a() };

    float j() {
        a k = new a();
        float l = 5;
        for (int d = 0; d < 8; ++d) {
            for (int e = 0; e < 9; ++e) {
                k = k;
                l *= k.g;
            }
            for (int f = 0; f < 9; ++f) {
                new a();
            }
            {
                a[] m = { new a(), new a(), new a(), new a(), new a(), new a(), new a(), new a(), new a() };
                c = i[0].g + k.g;
            }
        }
        return k.h;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16937().j());
    }
}
