package automation.pages.cars;

import automation.base.BaseLocator;
import org.openqa.selenium.By;

public class CarsLocator extends BaseLocator {

    public static CarsLocator newInstance() {
        return new CarsLocator();
    }

    public final By carRental = getElementByXpath("//*[@*='IcProductDuotoneCarRentalFill']");
    public final By searchLocationRental = getElementByXpath("//*[@*='rental-search-form-location-input']");
    public final By buttonWithoutDrivers = getElementByXpath("//*[@*='IcTransportPickUpDriver']");
    public final By buttonWithDrivers = getElementByXpath("//*[@*='IcTripDriver']");
    public final By dropdownResultListSearchCars = getElementByXpath("//*[@*='rental-search-form-location-item']");
    public final By currentMonthStartRental = getElementByXpath("(//*[@*='calendar-month'])[1]");
    public final By inputStartDateRental = getElementByXpath("//*[@*='rental-search-form-date-input-start']");
    public final By inputEndDateRental = getElementByXpath("//*[@*='rental-search-form-date-input-end']");
    public final By inputStartTimeRental = getElementByXpath("//*[@*='rental-search-form-time-input-start']");
    public final By inputEndTimeRental = getElementByXpath("//*[@*='rental-search-form-time-input-end']");
    public final By buttonCompleteSelectTime = getElementByXpath("//div[@class='css-18t94o4 css-1dbjc4n r-173mn98 r-kdyh1x r-1loqt21 r-1fz3rvf r-10paoce r-5njf8e r-1otgn73 r-lrvibr']");
    public final By buttonSearchRental = getElementByXpath("//*[@*='rental-search-form-cta']");
    public final By cardResultSearchCar = getElementByXpath("//*[@*='css-1dbjc4n r-18u37iz r-ymttw5 r-95jzfe']");
    public final By cardResultRentalProvider = getElementByXpath("//*[@*='css-1dbjc4n r-18u37iz r-nsbfu8']");
    public final By selectLocationPickupRentalOffice = getElementByXpath("(//*[@*='RENTAL_PICKUP_LOCATION']//div[@*='css-1dbjc4n r-1awozwy r-18u37iz r-1777fci r-ymttw5 r-1yzf0co'])[1]");
    public final By selectLocationPickupOtherLocation = getElementByXpath("(//*[@*='RENTAL_PICKUP_LOCATION']//div[@*='css-1dbjc4n r-1awozwy r-18u37iz r-1777fci r-ymttw5 r-1yzf0co'])[2]");
    public final By selectLocationDropOffRentalOffice = getElementByXpath("(//*[@*='RENTAL_DROPOFF_LOCATION']//div[@*='css-1dbjc4n r-1awozwy r-18u37iz r-1777fci r-ymttw5 r-1yzf0co'])[1]");
    public final By selectLocationDropOffOtherLocation = getElementByXpath("(//*[@*='RENTAL_DROPOFF_LOCATION']//div[@*='css-1dbjc4n r-1awozwy r-18u37iz r-1777fci r-ymttw5 r-1yzf0co'])[2]");
    public final By dropdownLocationPickupRentalOffice = getElementByXpath("//*[@*='css-1dbjc4n r-13awgt0 r-18u37iz r-edyy15']");
    public final By resultLocationPickupRentalOffice = getElementByXpath("//*[@*='css-901oao css-bfa6kz r-t1w4ow r-ubezar r-majxgm r-135wba7 r-fdjqy7']");
    public final By searchInputDropOffOtherLocation = getElementByXpath("//*[@*='RENTAL_DROPOFF_LOCATION']//*[@*='css-11aywtz r-z2wwpe r-t1w4ow r-1b43r93 r-majxgm r-mabqd8 r-rjixqe r-cwlir5']");
    public final By resultLocationDropOffOtherLocation = getElementByXpath("//*[@*='RENTAL_DROPOFF_LOCATION']//h3[@*='undefined-title']");
    public final By inputNotesLocationDropOffOtherLocation = getElementByXpath("//*[@*='RENTAL_DROPOFF_LOCATION']//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-13n6l4s']");
    public final By buttonContinueProductRental = getElementByXpath("//*[@*='css-18t94o4 css-1dbjc4n r-kdyh1x r-1loqt21 r-10paoce r-5wp0in r-5njf8e r-1otgn73 r-lrvibr']");
    public final By fullNameContactDetails = getElementByXpath("(//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-13n6l4s'])[1]");
    public final By emailContactDetails = getElementByXpath("(//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-13n6l4s'])[2]");
    public final By mobileNumberContactDetails = getElementByXpath("(//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-edyy15 r-13n6l4s'])[1]");
    public final By selectTitleNameDriverDetails = getElementByXpath("//*[@*='r-30o5oe r-1niwhzg r-1yadl64 r-1p0dtai r-t1w4ow r-ubezar r-majxgm r-1pi2tsx r-1r74h94 r-135wba7 r-crgep1 r-orgf3d r-1ny4l3l r-10paoce r-u8s1d r-3mc0re r-ipm5af r-34rx7k r-417010']");
    public final By fullNameDriverDetails = getElementByXpath("(//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-13n6l4s'])[3]");
    public final By mobileNumberDriverDetails = getElementByXpath("(//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-edyy15 r-13n6l4s'])[2]");
    public final By buttonContinueToPayment = getElementByXpath("//*[@*='css-18t94o4 css-1dbjc4n r-1k97etb r-kdyh1x r-1loqt21 r-10paoce r-1e081e0 r-5njf8e r-1otgn73 r-lrvibr']");
    public final By buttonContinuePay = getElementByXpath("//*[@*='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-1uirtdp r-b88u0q r-uzxld0 r-q4m81j']");
    public final By inputNotesSpecialRequest = getElementByXpath("//*[@*='css-11aywtz r-13awgt0 r-t1w4ow r-ubezar r-majxgm r-135wba7 r-bcqeeo r-1ny4l3l r-10paoce r-13n6l4s']");
    public final By fieldCheckRequirement = getElementByXpath("//*[@*='css-1dbjc4n r-14lw9ot r-kdyh1x r-1yos0t3 r-18u37iz r-1wtj0ep r-1udh08x r-nsbfu8']");
    public final By checkboxCheckAllRequirements = getElementByXpath("(//*[@*='css-1dbjc4n r-1awozwy r-18u37iz r-633pao'])");
    public final By buttonSaveRequirements = getElementByXpath("//*[@*='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-cygvgh r-b88u0q r-1iukymi r-q4m81j']");
    public final By buttonContinueConfirmationPayment = getElementByXpath("(//*[@*='css-1dbjc4n r-14lw9ot r-kdyh1x r-da5iq2 r-1udh08x r-nsbfu8']//*[@*='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1777fci'])[2]");
    public final By buttonPay = getElementByXpath("//*[@*='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1777fci']");
    public final By totalPricePaymentConditions1 = getElementByXpath("//*[@*='css-1dbjc4n r-1guathk r-1h4fu65']");
    public final By navbarBankTransfer = getElementByXpath("//*[@*='css-901oao r-1euibsf r-t1w4ow r-1b43r93 r-majxgm r-rjixqe r-1yzf0co r-fdjqy7']");
    public final By buttonPayWithBankTransfer = getElementByXpath("//*[@*='css-901oao css-bfa6kz r-jwli3a r-t1w4ow r-cygvgh r-b88u0q r-1iukymi r-q4m81j']");
    public final By totalPricePaymentConditions2 = getElementByXpath("//*[@*='css-1dbjc4n r-1habvwh r-1h9nbw7 r-6koalj r-18u37iz r-1b43r93 r-1wtj0ep r-p1pxzi']");



    public By getResultSearchCar(int i){
        return getElementByXpath("(//*[@*='rental-search-form-location-item'])["+i+"]");
    }

    public By getSelectStartDateRental(String dateNow){
        return getElementByXpath("(//div[@*='date-cell-"+dateNow+"'])[1]");
    }

    public By getSelectEndDateRental(String dateNow){
        return getElementByXpath("(//div[@*='date-cell-"+dateNow+"'])[2]");
    }

    public By getHoursTimeRental(String time){
        return getElementByXpath("//div[@class='css-1dbjc4n r-18u37iz r-xyw6el']//div[@class='css-1dbjc4n']/div[.='"+time+"']");
    }

    public By getMinutesTimeRental(String time){
        return getElementByXpath("(//div[@class='css-1dbjc4n r-18u37iz r-xyw6el']//div[@class='css-1dbjc4n'])[2]/div[.='"+time+"']");
    }

    public By getButtonContinueSelectCars(int i){
        return getElementByXpath("(//*[@*='css-1dbjc4n r-18u37iz r-ymttw5 r-95jzfe']//div[@*='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1777fci'])["+i+"]");
    }

    public By getNameCarsRental(int i){
        return getElementByXpath("(//*[@*='css-1dbjc4n r-18u37iz r-ymttw5 r-95jzfe']//*[@*='css-4rbku5 css-901oao css-bfa6kz r-t1w4ow r-ubezar r-b88u0q r-rjixqe r-fdjqy7'])["+i+"]");
    }

    public By getNameRentalProvider(int i){
        return getElementByXpath("(//*[@*='css-1dbjc4n r-18u37iz r-nsbfu8']//*[@*='css-4rbku5 css-901oao css-bfa6kz r-t1w4ow r-ubezar r-b88u0q r-rjixqe r-fdjqy7'])["+i+"]");
    }

    public By getButtonContinueSelectRental(int i){
        return getElementByXpath("(//*[@*='css-1dbjc4n r-18u37iz r-nsbfu8']//*[@*='css-1dbjc4n r-1awozwy r-13awgt0 r-18u37iz r-1777fci'])["+i+"]");
    }

    public By getSelectResultPickupLocationRentalOffice(int i){
        return getElementByXpath("(//*[@*='css-901oao css-bfa6kz r-t1w4ow r-ubezar r-majxgm r-135wba7 r-fdjqy7'])["+i+"]");
    }

    public By getSelectResultDropOffLocationOtherLocation(int i){
        return getElementByXpath("(//*[@*='RENTAL_DROPOFF_LOCATION']//h3[@*='undefined-title'])["+i+"]");
    }
}