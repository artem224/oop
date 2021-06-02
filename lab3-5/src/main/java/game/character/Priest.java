package game.character;

import game.BasicPropertyHero;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Priest extends Wizard {
    private double lightEnergy;

    public Priest() {
        super("Андуин", new BasicPropertyHero(), 30);
        lightEnergy = 50;
        type = HeroType.Priest;
    }

    public Priest(String name, BasicPropertyHero basicProperty, double mana, double lightEnergy) {
        super(name, basicProperty, mana);
        this.lightEnergy = lightEnergy;
        type = HeroType.Priest;
    }



    public double getLightEnergy() {
        return lightEnergy;
    }

    public void setLightEnergy(double lightEnergy) {
        this.lightEnergy = lightEnergy;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Light Energy",
                "Enter light Energy Ranger",
                Double.toString(lightEnergy)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        super.updateUniqueProperty(vBox);
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(2);
        this.lightEnergy = Double.parseDouble(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + lightEnergy;
    }
}
