package Singleton;

public class PrinterPoolBillPugh {
   private PrinterPoolBillPugh () {
    // PrinterPool Code
   } 

   // Helper class that is also static
   // Not loaded into memory until someone calls getInstance()

   private static class Helper {
        private static final PrinterPoolBillPugh instance = new PrinterPoolBillPugh();

   }
   public static PrinterPoolBillPugh getInstance() {
        return Helper.instance;
   }

}
