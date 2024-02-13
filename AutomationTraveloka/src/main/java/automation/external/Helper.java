package automation.external;

public class Helper {

    private static Helper mInstance;
    private final Element mElement;

    public static Helper newInstance(Element element) {
        mInstance = new Helper(element);
        return mInstance;
    }

    public Helper(Element element) {
        this.mElement = element;
    }

    public void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
