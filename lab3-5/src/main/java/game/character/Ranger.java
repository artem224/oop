package game.character;

import game.BasicPropertyHero;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Ranger extends Hero {
    protected double agility;

    public Ranger() {
        super("Леголас", HeroType.Ranger, new BasicPropertyHero());
        this.agility = 45;
        type = HeroType.Ranger;
    }

    public Ranger(String name, BasicPropertyHero basicProperty, double agility) {
        super(name, HeroType.Ranger, basicProperty);
        this.agility = agility;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Agility",
                "Enter agility Ranger",
                Double.toString(agility)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(1);;
        this.agility = Double.parseDouble(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + agility;
    }
}
