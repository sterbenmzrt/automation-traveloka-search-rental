package automation.pages.cars;

import automation.base.BasePage;
import automation.base.EmptyModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarsPage extends BasePage<EmptyModel, CarsLocator> {

    public static CarsPage newInstance(WebDriver webDriver, WebDriverWait webDriverWait) {
        return new CarsPage().init(webDriver, webDriverWait);
    }

    public CarsPage init(WebDriver webDriver, WebDriverWait webDriverWait) {
        initInstance(webDriver, webDriverWait);
        return this;
    }

    @Override
    public void setupController() {
        this.mModel = new EmptyModel();
    }

    @Override
    public void setupPathElement() {
        this.mLocator = CarsLocator.newInstance();
    }

    public CarsLocator getLocator(){
        return mLocator;
    }

    public void navigateToCarsRental() {
        System.out.println("Navigating to Cars Rental");
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.carRental));
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.carRental));
        getElement().click(mLocator.carRental);
    }

    public void searchLocationCarsRental(String location) {
        System.out.println("Searching Location : " + location);
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.searchLocationRental));
        getElement().setText(mLocator.searchLocationRental, location);
        stepHelper.delay(3000);
        selectSearchResultLocation(location);
    }

    public void selectWithDrivers(CarsEnum condition) {
        System.out.println("Selecting Condition : " + condition);
        if (condition.equals(CarsEnum.WITH_DRIVERS)) {
            getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.buttonWithDrivers));
            getElement().click(mLocator.buttonWithDrivers);
        } else if (condition.equals(CarsEnum.WITHOUT_DRIVERS)) {
            getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.buttonWithoutDrivers));
            getElement().click(mLocator.buttonWithoutDrivers);
        } else {
            throw new RuntimeException("Invalid Conditions");
        }
        stepHelper.delay(3000);
    }

    private void selectSearchResultLocation(String resultLocation) {
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.dropdownResultListSearchCars));
        int getRowResult = getElement().getSize(mLocator.dropdownResultListSearchCars);
        System.out.println("Count of Result : " + getRowResult);
        for (int i = 1; i <= getRowResult; i++) {
            getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.getResultSearchCar(i)));
            String geTextResult = getElement().getText(mLocator.getResultSearchCar(i));
            if (geTextResult.contains(resultLocation)) {
                getElement().click(mLocator.getResultSearchCar(i));
                break;
            }
        }
        stepHelper.delay(3000);
    }

    public void selectStartDate() {
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.inputStartDateRental));
        getElement().click(mLocator.inputStartDateRental);

        LocalDate dateNow = LocalDate.now();

        LocalDate datePlusTwoDays = dateNow.plusDays(2);

        String datePattern = "dd-M-YYYY";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(datePattern);
        String formattedDate = myFormatObj.format(datePlusTwoDays);

        getElement().click(mLocator.getSelectStartDateRental(formattedDate));

        stepHelper.delay(3000);
    }

    public void selectEndDateRental() {
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.inputEndDateRental));
        getElement().click(mLocator.inputEndDateRental);

        LocalDate dateNow = LocalDate.now();

        LocalDate datePlusTwoDays = dateNow.plusDays(5);

        String datePattern = "dd-M-YYYY";
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(datePattern);
        String formattedDate = myFormatObj.format(datePlusTwoDays);

        getElement().click(mLocator.getSelectEndDateRental(formattedDate));

        stepHelper.delay(3000);
    }

    public void selectTime(By inputField, String hours, String minutes) {
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(inputField));
        getElement().click(inputField);

        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.getHoursTimeRental(hours)));
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.getMinutesTimeRental(minutes)));
        getElement().click(mLocator.getHoursTimeRental(hours));
        getElement().click(mLocator.getMinutesTimeRental(minutes));

        getElement().click(mLocator.buttonCompleteSelectTime);
    }

    public void clickSearchRental(){
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.buttonSearchRental));
        getElement().click(mLocator.buttonSearchRental);
        stepHelper.delay(5000);
        boolean isSearched = getElement().verifyElementPresent(mLocator.cardResultSearchCar);
        Assert.assertTrue(isSearched, "Failed search rental");
    }

    public void selectCarsRental(String carsType){
        System.out.println("Selecting Cars : " + carsType);
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.cardResultSearchCar));
        int getRowResultCar = getElement().getSize(mLocator.cardResultSearchCar);
        System.out.println("Result Cars : " + getRowResultCar);
        for (int i = 1; i <= getRowResultCar; i++) {
            String getNameCar = getElement().getText(mLocator.getNameCarsRental(i));
            System.out.println("Name Car Index " + i + " : " + getNameCar);
            if (getNameCar.contains(carsType)) {
                getElement().click(mLocator.getButtonContinueSelectCars(i));
                break;
            }
        }
        stepHelper.delay(3000);
        boolean isSelected = getElement().verifyTextPresent("Pilih Penyedia Rental") || getElement().verifyTextPresent("Select Rental Provider");
        Assert.assertTrue(isSelected, "Failed select cars : " + carsType);
    }

    public void selectRentalProvider(String provider){
        System.out.println("Selecting Provider : " + provider);
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.cardResultRentalProvider));
        int getRowResultProvider = getElement().getSize(mLocator.cardResultRentalProvider);
        System.out.println("Available Result Provider : " + getRowResultProvider);
        for (int i = 1; i <= getRowResultProvider; i++) {
            String getNameProvider = getElement().getText(mLocator.getNameRentalProvider(i));
            System.out.println("Name Provider Index " + i + " : " + getNameProvider);
            if (getNameProvider.contains(provider)) {
                getElement().click(mLocator.getButtonContinueSelectRental(i));
                break;
            }
        }
        stepHelper.delay(3000);
        boolean isSelected = getElement().verifyTextPresent("Important Info") || getElement().verifyTextPresent("Kebijakan Rental");
        Assert.assertTrue(isSelected, "Failed select provider : " + provider);
    }

    public void selectPickupLocation(CarsEnum location){
        System.out.println("Selecting Location Pickup: " + location);
        if (location.equals(CarsEnum.RENTAL_OFFICE)) {
            getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.selectLocationPickupRentalOffice));
            getElement().click(mLocator.selectLocationPickupRentalOffice);
            getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.dropdownLocationPickupRentalOffice));
            getElement().verifyElementPresent(mLocator.dropdownLocationPickupRentalOffice);
            getElement().click(mLocator.dropdownLocationPickupRentalOffice);
            getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.resultLocationPickupRentalOffice));
            getElement().click(mLocator.getSelectResultPickupLocationRentalOffice(1));
            stepHelper.delay(5000);
            boolean isSelected = getElement().verifyElementPresent(mLocator.selectLocationDropOffRentalOffice);
            Assert.assertTrue(isSelected, "Failed select location pickup : " + location);
        } else if (location.equals(CarsEnum.OTHER_LOCATION)) {
            getElement().click(mLocator.selectLocationPickupOtherLocation);
            //soon will be handled
        }
    }

    public void selectDropOffLocation(CarsEnum location, String locationName){
        System.out.println("Selecting Location DropOff: " + location);
        if (location.equals(CarsEnum.OTHER_LOCATION)) {
            getElement().click(mLocator.selectLocationDropOffOtherLocation);
            getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.searchInputDropOffOtherLocation));
            getElement().setText(mLocator.searchInputDropOffOtherLocation,locationName);
            stepHelper.delay(3000);

            int getSizeResult = getElement().getSize(mLocator.resultLocationDropOffOtherLocation);
            System.out.println("Result Location : " + getSizeResult);
            for (int i = 1; i <= getSizeResult; i++) {
                String getNameLocation = getElement().getText(mLocator.getSelectResultDropOffLocationOtherLocation(i));
                System.out.println("Name Location Index " + i + " : " + getNameLocation);
                if (getNameLocation.contains(locationName)) {
                    getElement().click(mLocator.getSelectResultDropOffLocationOtherLocation(i));
                    break;
                }
            }
            stepHelper.delay(5000);
            boolean isSelected = getElement().verifyElementPresent(mLocator.inputNotesLocationDropOffOtherLocation);
            Assert.assertTrue(isSelected, "Failed select location drop off : " + location);
        } else if (location.equals(CarsEnum.RENTAL_OFFICE)) {
            getElement().click(mLocator.selectLocationDropOffRentalOffice);
            //soon will be handled
        }
    }

    public void addNotesLocationDropOff(String notes){
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.inputNotesLocationDropOffOtherLocation));
        getElement().setText(mLocator.inputNotesLocationDropOffOtherLocation,notes);
        stepHelper.delay(3000);
        boolean isAdded = getElement().verifyTextPresent(notes);
        Assert.assertTrue(isAdded, "Failed add notes location drop off : " + notes);
    }

    public void clickContinueProductDetail(){
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.buttonContinueProductRental));
        getElement().click(mLocator.buttonContinueProductRental);
        getElement().waitUntil(ExpectedConditions.invisibilityOfElementLocated(mLocator.buttonContinueProductRental));
        System.out.println("This is will be blocked by captcha, soon will be handled, have to solve this manually");
        stepHelper.delay(10000);
        boolean isContinued = getElement().verifyTextPresent("Pemesanan Anda") || getElement().verifyTextPresent("Your Booking");
        Assert.assertTrue(isContinued, "Failed continue product detail");
    }

    public void fillContactDetails(String name, String email, String phone){
        getElement().setText(mLocator.fullNameContactDetails,name);
        getElement().setText(mLocator.emailContactDetails,email);
        getElement().setText(mLocator.mobileNumberContactDetails,phone);
        stepHelper.delay(3000);
        boolean isFilled = getElement().verifyTextPresent(name) && getElement().verifyTextPresent(email)
                && getElement().verifyTextPresent(phone);
        Assert.assertTrue(isFilled, "Failed fill contact details");
    }

    public void fillDriverDetails(String titleName, String name, String phone){
        getElement().selectOptionByValue(mLocator.selectTitleNameDriverDetails,titleName);
        getElement().setText(mLocator.fullNameDriverDetails,name);
        getElement().setText(mLocator.mobileNumberDriverDetails,phone);
        stepHelper.delay(3000);
        boolean isFilled = getElement().verifyTextPresent(titleName) && getElement().verifyTextPresent(name)
                && getElement().verifyTextPresent(phone);
        Assert.assertTrue(isFilled, "Failed fill driver details");
    }

    public void clickContinuePayment(){
        getElement().click(mLocator.buttonContinueToPayment);
        stepHelper.delay(5000);
        boolean isContinued = getElement().verifyElementPresent(mLocator.inputNotesSpecialRequest);
        Assert.assertTrue(isContinued, "Failed continue payment");
    }

    public void addSpecialRequest(String notes){
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.inputNotesSpecialRequest));
        getElement().setText(mLocator.inputNotesSpecialRequest,notes);
        stepHelper.delay(3000);
        boolean isAdded = getElement().verifyTextPresent(notes);
        Assert.assertTrue(isAdded, "Failed add special request : " + notes);
    }

    public void checkAllRequirements(){
        getElement().scrollToElement(mLocator.inputNotesSpecialRequest);
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.fieldCheckRequirement));
        getElement().click(mLocator.fieldCheckRequirement);
        stepHelper.delay(2000);
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.checkboxCheckAllRequirements));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", getElement().findElement(mLocator.checkboxCheckAllRequirements));
        boolean isChecked = getElement().isEnabled(mLocator.buttonSaveRequirements);
        Assert.assertTrue(isChecked, "Failed check all requirements");
        getElement().click(mLocator.buttonSaveRequirements);
        stepHelper.delay(3000);
    }

    public void clickContinuePay(){
        getElement().scrollToElement(mLocator.buttonContinuePay);
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.buttonContinuePay));
        getElement().click(mLocator.buttonContinuePay);
        stepHelper.delay(3000);
        boolean isClicked = getElement().verifyElementPresent(mLocator.buttonContinueConfirmationPayment);
        Assert.assertTrue(isClicked, "Failed click continue pay");
    }

    public void confirmationPayment(){
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.buttonContinueConfirmationPayment));
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.buttonContinueConfirmationPayment));
        getElement().click(mLocator.buttonContinueConfirmationPayment);
        stepHelper.delay(5000);
        boolean isConfirmed = getElement().verifyElementNotPresent(mLocator.buttonContinueConfirmationPayment);
        Assert.assertTrue(isConfirmed, "Failed confirmation payment");
    }

    private void clickPayConditions1(){
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.buttonPay));
        String getMethodPayment = getElement().getText(mLocator.buttonPay);
        String getTotalPrice = getElement().getText(mLocator.totalPricePaymentConditions1);
        System.out.println("Method Payment : " + getMethodPayment + "\nTotal Price : " + getTotalPrice);
        getElement().click(mLocator.buttonPay);
        System.out.println("This is will be blocked by captcha, soon will be handled, have to solve this manually");
        stepHelper.delay(10000);
        boolean isPay = getElement().verifyTextPresent("We’re holding this price for you! Let’s complete your payment in");
        Assert.assertTrue(isPay, "Failed pay");
    }

    private void clickPayConditions2(){
        getElement().waitUntil(ExpectedConditions.elementToBeClickable(mLocator.navbarBankTransfer));
        getElement().click(mLocator.navbarBankTransfer);
        getElement().waitUntil(ExpectedConditions.visibilityOfElementLocated(mLocator.buttonPayWithBankTransfer));
        String getTotalPrice = getElement().getText(mLocator.totalPricePaymentConditions2);
        System.out.println("Total Price : " + getTotalPrice);
        getElement().scrollToElement(mLocator.buttonPayWithBankTransfer);
        getElement().click(mLocator.buttonPayWithBankTransfer);
        System.out.println("This is will be blocked by captcha, soon will be handled, have to solve this manually");
        stepHelper.delay(10000);
        boolean isPay = getElement().verifyTextPresent("Transfer Payment Instructions");
        Assert.assertTrue(isPay, "Failed pay");
    }

    public void proceedPayment(){
        if (getElement().verifyElementPresent(mLocator.buttonPay)){
            System.out.println("Entering pay conditions 1 ");
            clickPayConditions1();
        } else if (getElement().verifyElementPresent(mLocator.navbarBankTransfer)){
            System.out.println("Entering pay conditions 2 ");
            clickPayConditions2();
        } else {
            Assert.fail("Failed proceed payment");
        }
    }
}
