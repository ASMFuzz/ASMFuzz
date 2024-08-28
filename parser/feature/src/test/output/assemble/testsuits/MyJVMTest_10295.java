public class MyJVMTest_10295 {

    static int i = 1713673996;

    int m(int i) {
        switch(i) {
            case 0:
                System.out.println(0);
            case 1:
                System.out.println(1);
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10295().m(i);
    }
}
