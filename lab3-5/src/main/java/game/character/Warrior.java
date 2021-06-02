package game.character;

import game.BasicPropertyHero;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Warrior extends Hero {
    protected double strength;

    public Warrior() {
        super("Горош", HeroType.Warrior, new BasicPropertyHero());
        this.strength = 5;
        type = HeroType.Warrior;
    }


    public Warrior(String name, BasicPropertyHero basicProperty, double strength) {
        super(name, HeroType.Warrior, basicProperty);
        this.strength = strength;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Strength",
                "Enter strength Warrior",
                Double.toString(strength)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(1);
        this.strength = Double.parseDouble(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + strength;
    }
}
