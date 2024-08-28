public class MyJVMTest_15168 {

    static int key = 1062802211;

    int method1(int key) {
        switch(key) {
            case 100:
                return 1;
            case 200:
                return 2;
            case 300:
                return 3;
            case 400:
                return 4;
            case 500:
                return 5;
            default:
                if (key == 1000) {
                    return 1;
                } else {
                    return 2;
                }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15168().method1(key));
    }
}
