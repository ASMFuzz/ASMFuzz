public class MyJVMTest_2603 {

    static int i1 = 0;

    static int i2 = 0;

    static Test_ia32[] arr = { null, null, null, null, null, null, null, null, null, null };

    static int i3 = 0;

    static int i4 = 1;

    static Test_ia32[] _tests = {null,null,null,null,null,null,null,null,null,null};

    int g(int i1, int i2, Test_ia32[] arr, int i3, int i4) {
        if (!(i1 == 1 && i2 == 2 && i3 == 3 && i4 == 4)) {
            System.out.println("Bug!");
        }
        return arr.length;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2603().g(i1, i2, arr, i3, i4));
    }
}
