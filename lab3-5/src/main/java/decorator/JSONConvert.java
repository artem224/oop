package decorator;

import game.character.Hero;
import javafx.collections.ObservableList;
import plugin.PluginLoader;
import serialize.Serialize;

public class JSONConvert extends SerializeDecorator {

    public JSONConvert(Serialize serialize) {
        super(serialize);
    }

    public void serialize(ObservableList<Hero> heroObservableList) {
        super.serialize(heroObservableList);
        serializeWithJSON();
    }

    private void serializeWithJSON() {
        new PluginLoader().loadPlugin("JSON").action(getExtension());
    }

}
