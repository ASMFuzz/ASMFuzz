public class MyJVMTest_3044 {

    static int a = 1;

    static int b = 1334042004;

    static int nonStaticPublicField = -177030045;

    static int nonStaticFinalPublicField = -774239363;

    int addPublicInner(int a, int b) {
        return a + b + 20;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3044().addPublicInner(a, b));
    }
}
