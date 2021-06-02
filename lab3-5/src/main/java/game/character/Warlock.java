package game.character;

import game.BasicPropertyHero;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Warlock extends Wizard {
    private double darkEnergy;

    public Warlock() {
        super("Гулдан", new BasicPropertyHero(), 40);
        darkEnergy = 5;
        type =HeroType.Warlock;
    }



    public Warlock(String name, BasicPropertyHero basicProperty, double mana, double darkEnergy) {
        super(name, basicProperty, mana);
        this.darkEnergy = darkEnergy;
        type = HeroType.Warlock;
    }

    public double getDarkEnergy() {
        return darkEnergy;
    }

    public void setDarkEnergy(double darkEnergy) {
        this.darkEnergy = darkEnergy;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Dark Energy",
                "Enter dark energy Warlock",
                Double.toString(darkEnergy)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        super.updateUniqueProperty(vBox);
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(2);
        this.darkEnergy = Double.parseDouble(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + darkEnergy;
    }
}
