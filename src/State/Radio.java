package State;

public class Radio {

    private String state;

    public Radio () {
        this.state = "VOL";
    }

    public void setState(String state_) {
        this.state = state_;
    }
    public String getState() {
        return state;
    }

    public void clickUp() {
        if(this.state == "VOL") {
            System.out.println("Increase volume");
        } 
        else if (this.state == "CHAN") {
            System.out.println("Go to next channel");
        }
    }
    
    public void clickDown() {
        if(this.state == "VOL") {
            System.out.println("Decrease volume");
        } 
        else if (this.state == "CHAN") {
            System.out.println("Go to previous channel");
        }
    }
}
