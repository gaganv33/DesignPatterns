public class CareTakerMediatorImpl implements CareTakerMediator {
    private final Editor editor;
    private final CareTaker careTaker;

    public CareTakerMediatorImpl(Editor editor, CareTaker careTaker) {
        this.editor = editor;
        this.careTaker = careTaker;
    }

    @Override
    public Editor getEditor() {
        return editor;
    }

    @Override
    public void save(String data) {
        Memento memento = new Memento(data);
        careTaker.addState(memento);
    }

    @Override
    public void undo() {
        Memento memento = careTaker.popState();
        if(memento != null) {
            editor.setData(memento.state());
        }
    }
}
