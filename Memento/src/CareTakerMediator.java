public interface CareTakerMediator {
    void save(String data);
    void undo();
    Editor getEditor();
}
