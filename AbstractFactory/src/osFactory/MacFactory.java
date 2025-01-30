package osFactory;

import osComponents.mac.MacButton;
import osComponents.mac.MacCheckBox;
import uiComponents.Button;
import uiComponents.CheckBox;

public class MacFactory implements UiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
