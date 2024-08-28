public class MyJVMTest_728 {

    static String[] values = {"Q-fDW_(vt7","rI3{hkXC]L","O9KTjz%yQx","?k:'0Mv9 J","9}@N40'9ng","YV!E/qq#uH",";vW0\"{|l,#","Mn\"CE.;GJ_","/U\"k8TM~[#","CK'EwPp$*I"};

    String foo() {
        int i = Integer.MAX_VALUE - 1;
        String s;
        try {
            s = values[i];
        } catch (Throwable e) {
            s = "";
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_728().foo());
    }
}
