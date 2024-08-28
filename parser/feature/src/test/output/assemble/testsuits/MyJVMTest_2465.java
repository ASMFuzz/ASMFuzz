public class MyJVMTest_2465 {

    static int i = -1333655914;

    String test(int i) {
        switch(i) {
            case 0:
                return ("found 0");
            case 1:
                return ("found 1");
        }
        return ("Error");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2465().test(i));
    }
}
