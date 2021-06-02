package decorator;

import serialize.Serialize;
import game.character.Hero;
import javafx.collections.ObservableList;

public class SerializeDecorator implements Serialize {
    private Serialize serialize;

    public SerializeDecorator(Serialize serialize) {
        this.serialize = serialize;
    }

    @Override
    public String getExtension() {
        return serialize.getExtension();
    }

    @Override
    public void serialize(ObservableList<Hero> heroObservableList) {
        serialize.serialize(heroObservableList);
    }
}
