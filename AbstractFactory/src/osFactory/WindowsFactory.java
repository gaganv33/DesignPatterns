package osFactory;

import osComponents.win.WindowsButton;
import osComponents.win.WindowsCheckBox;
import uiComponents.Button;
import uiComponents.CheckBox;

public class WindowsFactory implements UiFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
