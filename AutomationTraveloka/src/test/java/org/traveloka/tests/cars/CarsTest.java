package org.traveloka.tests.cars;

import automation.pages.cars.CarsEnum;
import automation.pages.cars.CarsPage;
import org.testng.annotations.Test;
import org.traveloka.base.BaseWebDriver;

public class CarsTest extends BaseWebDriver {
    public CarsPage carsPage;

    @Override
    public void initInstance() {
        carsPage = CarsPage.newInstance(webDriver,webDriverWait);
    }

    @Test(priority = 1)
    public void searchCarsRentalWithoutDrivers() {
        carsPage.navigateToCarsRental();
        carsPage.selectWithDrivers(CarsEnum.WITHOUT_DRIVERS);
        carsPage.searchLocationCarsRental("Jakarta");
        carsPage.selectStartDate();
        carsPage.selectEndDateRental();
        carsPage.selectTime(carsPage.getLocator().inputStartTimeRental,"8","0");
        carsPage.selectTime(carsPage.getLocator().inputEndTimeRental,"19","30");
        carsPage.clickSearchRental();
        carsPage.selectCarsRental("Daihatsu Ayla");
        carsPage.selectRentalProvider("CSS Rent Jakarta");
        carsPage.selectPickupLocation(CarsEnum.RENTAL_OFFICE);
        carsPage.selectDropOffLocation(CarsEnum.OTHER_LOCATION,"Jakarta");
        carsPage.addNotesLocationDropOff("Notes Drop Off Location");
        carsPage.clickContinueProductDetail();
        carsPage.fillContactDetails("John Doe","HJbq6@example.com","8123456789");
        carsPage.fillDriverDetails("MR","Jack Doe","8123456789");
        carsPage.clickContinuePayment();
        carsPage.addSpecialRequest("Notes Special Request");
        carsPage.checkAllRequirements();
        carsPage.clickContinuePay();
        carsPage.confirmationPayment();
        carsPage.proceedPayment();
    }
}