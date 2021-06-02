package adapter;

import serialize.Serialize;
import serialize.XMLSerialize;
import game.character.Hero;
import javafx.collections.ObservableList;

public class XMLAdapter extends XMLSerialize implements Serialize {

    @Override
    public String getExtension() {
        return "xml";
    }

    @Override
    public void serialize(ObservableList<Hero> heroObservableList) {
        saveHero(heroObservableList);
    }
}
