package serialize;

import game.character.Hero;
import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;

public class TxtSerialize {

    public void saveHero(ObservableList<Hero> heroObservableList) {
        for (Hero hero : heroObservableList) {
            try {
                FileWriter fWriter = new FileWriter("output.txt", false);
                fWriter.write(hero.toString() + "\n");
                fWriter.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
