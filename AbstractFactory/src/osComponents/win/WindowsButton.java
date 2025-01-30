package osComponents.win;

import uiComponents.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Created Windows button");
    }
}
