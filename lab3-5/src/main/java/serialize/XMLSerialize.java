package serialize;

import game.character.Hero;
import javafx.collections.ObservableList;
import util.TableSize;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLSerialize {

    public void saveHero(ObservableList<Hero> heroObservableList) {
        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("output.xml")));
            encoder.writeObject(new TableSize(heroObservableList.size()));
            for (Hero hero : heroObservableList)
                encoder.writeObject(hero);
            encoder.flush();
            encoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
