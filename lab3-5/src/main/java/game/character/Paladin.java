package game.character;

import game.BasicPropertyHero;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Paladin extends Warrior {
    private double holyProtection;

    public Paladin() {
        super("Утер", new BasicPropertyHero(), 3);
        holyProtection = 10;
        type = HeroType.Paladin;
    }


    public Paladin(String name, BasicPropertyHero basicProperty, double strength, double holyProtection) {
        super(name, basicProperty, strength);
        this.holyProtection = holyProtection;
        type = HeroType.Paladin;
    }

    public double getHolyProtection() {
        return holyProtection;
    }

    public void setHolyProtection(double holyProtection) {
        this.holyProtection = holyProtection;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Holy protection",
                "Enter holy protection Ranger",
                Double.toString(holyProtection)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        super.updateUniqueProperty(vBox);
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(2);
        this.holyProtection = Double.parseDouble(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + holyProtection;
    }
}
