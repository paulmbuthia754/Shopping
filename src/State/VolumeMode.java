package State;

public class VolumeMode implements RadioState{
   @Override
   public void clickUp() {
        System.out.println("Increase volume");
   } 
   @Override
   public void clickDown() {
        System.out.println("Decrease volume");
   }
}
