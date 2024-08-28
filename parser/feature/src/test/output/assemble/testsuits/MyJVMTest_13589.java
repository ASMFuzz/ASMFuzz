public class MyJVMTest_13589 {

    static int timing_trials = 6;

    static int get_timing_loops = 7;

    static int set_timing_loops = -973523957;

    static SecurityManager sm = new SecurityManager();

    int timeit(int timing_trials, int get_timing_loops, int set_timing_loops) {
        try {
            long start;
            for (int j = 0; j < timing_trials; j++) {
                start = System.nanoTime();
                for (int i = 0; i < get_timing_loops; i++) {
                    sm = System.getSecurityManager();
                }
                if (timing_trials > 1) {
                    System.out.println((float) (System.nanoTime() - start) / (float) get_timing_loops);
                }
            }
            for (int j = 0; j < timing_trials; j++) {
                start = System.nanoTime();
                for (int i = 0; i < set_timing_loops; i++) {
                    System.setSecurityManager(sm);
                }
                if (timing_trials > 1) {
                    System.out.println((float) (System.nanoTime() - start) / (float) set_timing_loops);
                }
            }
            return;
        } catch (Exception e) {
            throw new RuntimeException("SecurityRace got unexpected: " + e);
        }
        return timing_trials;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13589().timeit(timing_trials, get_timing_loops, set_timing_loops);
    }
}
