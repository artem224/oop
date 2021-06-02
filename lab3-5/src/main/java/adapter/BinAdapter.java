package adapter;

import serialize.BinSerialize;
import serialize.Serialize;
import game.character.Hero;
import javafx.collections.ObservableList;

public class BinAdapter extends BinSerialize implements Serialize {

    @Override
    public String getExtension() {
        return "bin";
    }

    @Override
    public void serialize(ObservableList<Hero> heroObservableList) {
        saveHero(heroObservableList);
    }
}
