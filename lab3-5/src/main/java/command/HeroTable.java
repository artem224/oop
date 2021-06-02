package command;

import game.character.Hero;
import javafx.collections.ObservableList;

public abstract class HeroTable {
    protected ObservableList<Hero> heroObservableList;

    public HeroTable(ObservableList<Hero> heroObservableList) {
        this.heroObservableList = heroObservableList;
    }

    public abstract void deserialize();
}
