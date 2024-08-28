public class MyJVMTest_12547 {

    void bar() {
    }

    void foo() {
        while (true) {
            int i = 0;
            break;
        }
        switch(1) {
            case 1:
                int j = 0;
            case 2:
                bar();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12547().foo();
    }
}
