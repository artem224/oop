package util;

import serialize.Serialize;
import game.character.Hero;
import javafx.collections.ObservableList;

public class DateSave {
    private Serialize serialize;

    public DateSave(Serialize serialize) {
        super();
        this.serialize = serialize;
    }

    public void saveDate(ObservableList<Hero> heroObservableList) {
        serialize.serialize(heroObservableList);
    }
}
