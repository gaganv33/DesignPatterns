import osFactory.UiFactory;
import uiComponents.Button;
import uiComponents.CheckBox;

public class Application {
    Button button;
    CheckBox checkBox;

    public Application(UiFactory uiFactory) {
        button = uiFactory.createButton();
        checkBox = uiFactory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }
}
