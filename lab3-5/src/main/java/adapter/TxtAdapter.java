package adapter;

import serialize.Serialize;
import serialize.TxtSerialize;
import game.character.Hero;
import javafx.collections.ObservableList;

public class TxtAdapter extends TxtSerialize implements Serialize {

    @Override
    public String getExtension() {
        return "txt";
    }

    @Override
    public void serialize(ObservableList<Hero> heroObservableList) {
        saveHero(heroObservableList);
    }
}
