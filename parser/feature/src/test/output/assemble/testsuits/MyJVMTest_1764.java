public class MyJVMTest_1764 {

    static int i = 5;

    int test(int i) {
        switch(i) {
            case 0:
                break;
            case 1:
                System.out.println();
        }
        return i;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1764().test(i);
    }
}
