public class Editor {
    private String data;
    private CareTakerMediator careTakerMediator;

    public void setCareTakerMediator(CareTakerMediator careTakerMediator) {
        this.careTakerMediator = careTakerMediator;
    }

    public Editor() {
        this.data = "";
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void save() {
        if(checkIfCareTakerMediatorIsValid()) {
            System.out.println("Set the care taker mediator before performing this operation");
            return;
        }
        careTakerMediator.save(this.data);
    }

    public String undo() {
        if(checkIfCareTakerMediatorIsValid()) {
            System.out.println("Set the care taker mediator before performing this operation");
            return this.data;
        }
        careTakerMediator.undo();
        return this.data;
    }

    private boolean checkIfCareTakerMediatorIsValid() {
        return (careTakerMediator == null);
    }
}
