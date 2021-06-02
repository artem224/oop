package decorator;

import game.character.Hero;
import javafx.collections.ObservableList;
import plugin.PluginLoader;
import serialize.Serialize;

public class ZipArchive extends SerializeDecorator {

    public ZipArchive(Serialize serialize) {
        super(serialize);
    }

    public void serialize(ObservableList<Hero> heroObservableList) {
        super.serialize(heroObservableList);
        serializeWithZip();
    }

    private void serializeWithZip() {
        new PluginLoader().loadPlugin("Zip").action(getExtension());
    }
}
