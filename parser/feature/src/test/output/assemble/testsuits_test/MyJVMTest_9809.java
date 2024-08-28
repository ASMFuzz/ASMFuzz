public class MyJVMTest_9809 {

    static boolean _doSpin = true;

    static Test_ia32[] _tests = {null,null,null,null,null,null,null,null,null,null};

    void requestStop() {
        System.out.println(this + " - stop requested.");
        _doSpin = false;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9809().requestStop();
    }
}
