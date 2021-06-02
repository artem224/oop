package command;

import game.character.Hero;
import javafx.collections.ObservableList;
import util.TableSize;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XMLDeserialize extends HeroTable {
    public XMLDeserialize(ObservableList<Hero> heroObservableList) {
        super(heroObservableList);
    }

    @Override
    public void deserialize() {
        try {
            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("output.xml")));
            TableSize tableSize = (TableSize) decoder.readObject();
            for (int i = 0; i < tableSize.getSize(); i++) {
                heroObservableList.add((Hero) decoder.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
