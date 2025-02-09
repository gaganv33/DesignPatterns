public class Main {
    public static void main(String[] args) {
        CareTakerMediator careTakerMediator = new CareTakerMediatorImpl(new Editor(), new CareTaker());
        Editor editor = careTakerMediator.getEditor();

        editor.setCareTakerMediator(careTakerMediator);

        editor.setData("state 1");
        System.out.println(" 1: " + editor.getData());
        editor.save();
        editor.setData("state 2");
        System.out.println(" 2: " + editor.getData());
        editor.save();

        editor.setData("state 3");
        System.out.println(" 3: " + editor.getData());
        System.out.println("undo: " + editor.undo());
        System.out.println(" 4: " + editor.getData());
        System.out.println("undo: " + editor.undo());
        System.out.println(" 5: " + editor.getData());
        System.out.println("undo: " + editor.undo());
        System.out.println("undo: " + editor.undo());
        System.out.println(" 6: " + editor.getData());
    }
}