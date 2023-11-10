package State;

public class RadioTest {
    public static void main(String[] args) {
        RadioContext radio = new RadioContext();
        radio.clickUp();
        radio.clickUp();
        radio.clickDown();
        radio.clickDown();
        radio.setState(new ChannelMode());
        radio.clickDown();
        radio.clickDown();
        radio.clickUp();
        radio.clickUp();
        radio.setState(new VolumeMode());
        radio.clickUp();
        radio.setState(new ChannelMode());
        radio.clickDown();
    }
}
