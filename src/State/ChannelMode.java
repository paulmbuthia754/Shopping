package State;

public class ChannelMode implements RadioState {
   @Override
   public void clickUp () {
        System.out.println("Go to next channel");
   }
   @Override 
   public void clickDown () {
        System.out.println("Go to previous channel");
   } 
}
