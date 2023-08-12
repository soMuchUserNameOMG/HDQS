import bin.util.TestCurve;
import bin.util.TestLEXICON;

public class Launcher {
    private static void configureLaunch() {

    }

    public static void main(String[] args) {
        configureLaunch();
        for (int i = 0; i < args.length; i++) {
            if ("-t".equals(args[i])) {
                runTest(args[i + 1]);
            }
            if ("-helloWorld".equals(args[i])) {
                helloWorld(args[i + 1]);
            }
            if ("-benchmark".equals(args[i])) {
                benchmark(args[i + 1]);
            }
        }
        cleanUp();
    }

    private static void runTest(String arg) {
        switch (arg) {
            case "all", "All", "ALL" -> {
                bin.io.Test.main(null);
                bin.io.smartIO2.Test.main(null);
                TestLEXICON.main(null);
                TestCurve.main(null);
            }
            default -> throw new RuntimeException("Invalid parameter: " + arg);
        }
    }

    private static void helloWorld(String arg) {
        switch (arg) {
            case "true", "True", "TRUE" -> {
                System.out.println("你好世界！");
                System.out.println("Hello world!");
            }
            case "false", "False", "FALSE" -> {}
            default -> throw new RuntimeException("Invalid parameter: " + arg);
        }
    }

    private static void benchmark(String arg) {
        switch (arg) {
            case "all", "All", "ALL" -> {
                TestLEXICON.BenchMark();
            }
            default -> throw new RuntimeException("Invalid parameter: " + arg);
        }
    }

    private static void cleanUp() {

    }
}
