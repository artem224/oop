package serialize;

import game.character.Hero;
import javafx.collections.ObservableList;
import util.TableSize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinSerialize {

    public void saveHero(ObservableList<Hero> heroObservableList) {
        try {
            FileOutputStream fos = new FileOutputStream("output.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(new TableSize(heroObservableList.size()));
            for (Hero hero : heroObservableList)
                objectOutputStream.writeObject(hero);
            objectOutputStream.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
