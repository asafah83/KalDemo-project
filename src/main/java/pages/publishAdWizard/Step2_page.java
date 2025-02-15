package pages.publishAdWizard;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class Step2_page extends BasePage {
    @FindBy(css = "[name='floor']")
    WebElement floorField;
    @FindBy(css = "[data-name='floors']")
    WebElement fromFloorField;
    @FindBy(css = "[name='room_num']")
    WebElement numberOfRoomsField;
    @FindBy(css = "[name='terrace']")
    WebElement numberOfTerracesField;
    @FindBy(css = "[name='_parking']")
    WebElement numberOfParkingsField;
    @FindBy(css = "[name='built_mr']")
    WebElement builtMrField;
    @FindBy(css = "[name='elevator_1']")
    WebElement elevatorField;
    @FindBy(xpath = "(//button[contains(text(),'הבא')])[2]")
    WebElement next2Button;

    public Step2_page(WebDriver driver) throws InterruptedException {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Set the floor number")
    public void setFloor(String floorValue) {
        fillText(floorField, floorValue);
    }

    @Step("Set the value from 'which' floor")
    public void setFromFloor(String fromFloorValue) {
        fillText(fromFloorField, fromFloorValue);
    }

    @Step("Set number of the Rooms")
    public void selectNumberOfRooms(String numberOfRoomsValue) {
        selectFromListByValue(numberOfRoomsValue, numberOfRoomsField);
    }

    @Step("Select the number of the traces")
    public void selectNumberOfTerraces(String numberOfTerracesValue) {
        selectFromListByValue(numberOfTerracesValue, numberOfTerracesField);
    }

    @Step("Select the number of the parkings")
    public void selectNumberOfParkings(String numberOfParkingsValue) {
        selectFromListByValue(numberOfParkingsValue, numberOfParkingsField);
    }

    @Step("Set the built per Mr")
    public void setBuiltMr(String builtMrValue) {
        fillText(builtMrField, builtMrValue);
    }

    @Step("Select if elevator is exist or not")
    public void setElevator(String elevatorValue) {
        selectFromListByValue(elevatorValue, elevatorField);
    }

    @Step("Click on the Next button")
    public void clickNext2() {
        click(next2Button);
    }
}

