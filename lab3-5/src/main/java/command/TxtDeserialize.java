package command;

import game.BasicPropertyHero;
import game.character.*;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TxtDeserialize extends HeroTable {

    public TxtDeserialize(ObservableList<Hero> heroObservableList) {
        super(heroObservableList);
    }

    @Override
    public void deserialize() {
        List<String> reading = null;
        try {
            reading = Files.readAllLines(Paths.get("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String hero : reading) {
            String[] res = hero.split("-%-");
            switch (res[1]) {
                case "Paladin":
                    heroObservableList.add(new Paladin(
                            res[0],
                            new BasicPropertyHero(
                                    Double.parseDouble(res[2]),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    Integer.parseInt(res[5])
                            ),
                            Double.parseDouble(res[6]),
                            Double.parseDouble(res[7])
                    ));
                    break;
                case "Priest":
                    heroObservableList.add(new Priest(
                            res[0],
                            new BasicPropertyHero(
                                    Double.parseDouble(res[2]),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    Integer.parseInt(res[5])
                            ),
                            Double.parseDouble(res[6]),
                            Double.parseDouble(res[7])
                    ));
                    break;
                case "Ranger":
                    heroObservableList.add(new Ranger(
                            res[0],
                            new BasicPropertyHero(
                                    Double.parseDouble(res[2]),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    Integer.parseInt(res[5])
                            ),
                            Double.parseDouble(res[6])
                    ));
                    break;
                case "Warlock":
                    heroObservableList.add(new Warlock(
                            res[0],
                            new BasicPropertyHero(
                                    Double.parseDouble(res[2]),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    Integer.parseInt(res[5])
                            ),
                            Double.parseDouble(res[6]),
                            Double.parseDouble(res[7])
                    ));
                    break;
                case "Warrior":
                    heroObservableList.add(new Warrior(
                            res[0],
                            new BasicPropertyHero(
                                    Double.parseDouble(res[2]),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    Integer.parseInt(res[5])
                            ),
                            Double.parseDouble(res[6])
                    ));
                    break;
                case "Wizard":
                    heroObservableList.add(new Wizard(
                            res[0],
                            new BasicPropertyHero(
                                    Double.parseDouble(res[2]),
                                    Double.parseDouble(res[3]),
                                    Integer.parseInt(res[4]),
                                    Integer.parseInt(res[5])
                            ),
                            Double.parseDouble(res[6])
                    ));
                    break;
            }
        }
    }
}
