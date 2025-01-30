package osFactory;

import uiComponents.Button;
import uiComponents.CheckBox;

public interface UiFactory {
    Button createButton();
    CheckBox createCheckBox();
}
