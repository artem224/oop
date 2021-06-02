package serialize;

import game.character.Hero;
import javafx.collections.ObservableList;

public interface Serialize {
    String getExtension();

    void serialize(ObservableList<Hero> heroObservableList);
}
