package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AtakanPage {

    public AtakanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
