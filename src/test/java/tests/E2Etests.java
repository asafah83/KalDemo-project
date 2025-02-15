package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.publishAdWizard.*;
import pages.tabs.AssetsInventoryPage;

public class E2Etests extends BaseTest {

    //////////////////////////******* Tests list *********/////////////////////////////////////////////////////////

    @Test
    @Description("Test 1 - Login with a valid user, to the website and Create a new Ad")
    private void e2eTest_loginAndCreateAd() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Step1_page step1_page = new Step1_page(driver);
        Step2_page step2_page = new Step2_page(driver);
        Step3_page step3_page = new Step3_page(driver);
        Step4_page step4_page = new Step4_page(driver);
        Step5_page step5_page = new Step5_page(driver);
        Step6_page step6_page = new Step6_page(driver);
        AssetsInventoryPage assetsInventoryPage = new AssetsInventoryPage(driver);

        // Starting the E2E test by beginning the publishing flow
        homePage.selectTabByName("מאגר דירות");
        assetsInventoryPage.getInitialAdCount();
        homePage.clickOnPublishAdButton();

        // Go over on the first step of the wizard
        step1_page.selectAssetType("דירת גן");
        step1_page.selectAssetStatus("משופץ");
        step1_page.selectCityAndHandleStreet("כרמיאל", "אשור", "24");
        step1_page.clickNext1();

        // Go over on the second step of the wizard
        step2_page.setFloor("1");
        step2_page.setFromFloor("2");
        step2_page.selectNumberOfRooms("4");
        step2_page.selectNumberOfTerraces("1");
        step2_page.selectNumberOfParkings("1");
        step2_page.setBuiltMr("120");
        step2_page.setElevator("עם");
        step2_page.clickNext2();

        // Go over on the third step of the wizard
        step3_page.selectAccessForCripples();
        step3_page.selectAirConditionOption();
        step3_page.selectKosherKitchenOption();
        step3_page.setAssetDescription("בדיקה 1 בדיקה 23");
        step3_page.clickNext3();

        // Go over on the fourth step of the wizard
        step4_page.setNumberOfPayments("12");
        step4_page.setHouseCommitment("200");
        step4_page.setTaxAsset("600");
        step4_page.setPrice("700000");
        step4_page.selectDate("2025", "November", "29");
        step4_page.clickNext4button();

        // Go over on the fifth step of the wizard
        step5_page.uploadImage("C:\\Automation\\folderForTestImages\\Menora.jpg");
        step5_page.clickNext5Button();

        // Go over on the sixth step of the wizard
        step6_page.setFullName("Asaf test");
        step6_page.setPhoneNumber("0523213214");
        step6_page.clickThePublishButton();

        // Verifying that the asset created successfully
        homePage.selectTabByName("מאגר דירות");
        assetsInventoryPage.verifyAdAdded();

    }
}
