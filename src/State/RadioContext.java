package State;

public class RadioContext implements RadioState{
   public RadioState state; 

   public RadioContext () {
        this.state = new VolumeMode();
   }
   public void setState(RadioState state_) {
        this.state = state_;
   }
   public RadioState getState() {
        return this.state;
   }
   @Override
   public void clickUp() {
        this.state.clickUp();
   }
   @Override
   public void clickDown() {
       this.state.clickDown();
   }
}
