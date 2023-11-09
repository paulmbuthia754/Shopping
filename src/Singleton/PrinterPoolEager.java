package Singleton;

public class PrinterPoolEager {
    private static final PrinterPoolEager instance = new PrinterPoolEager();

    private PrinterPoolEager() {
        // PrinterPool Code
    }
    public static PrinterPoolEager getInstance() {
        return instance;
    }
}
