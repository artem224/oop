package command;

import game.character.Hero;
import javafx.collections.ObservableList;
import util.TableSize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BinDeserialize extends HeroTable {

    public BinDeserialize(ObservableList<Hero> heroObservableList) {
        super(heroObservableList);
    }

    @Override
    public void deserialize() {
        try {
            FileInputStream fos = new FileInputStream("output.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fos);
            TableSize tableSize = (TableSize) objectInputStream.readObject();
            for (int i = 0; i < tableSize.getSize(); i++) {
                heroObservableList.add((Hero) objectInputStream.readObject());
            }
            objectInputStream.close();
            fos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
