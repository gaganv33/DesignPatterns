import osFactory.MacFactory;
import osFactory.UiFactory;
import osFactory.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        UiFactory windowsFactory = new WindowsFactory();
        UiFactory macFactory = new MacFactory();

        Application windowsApplication = new Application(windowsFactory);
        Application macApplication = new Application(macFactory);

        windowsApplication.paint();
        macApplication.paint();
    }
}