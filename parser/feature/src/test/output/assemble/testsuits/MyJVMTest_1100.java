public class MyJVMTest_1100 {

    static int i = 8;

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
        new MyJVMTest_1100().m(i);
    }
}
