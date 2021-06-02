package game.character;

import game.BasicPropertyHero;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Wizard extends Hero {
    protected double mana;

    public Wizard() {
        super("Джайна", HeroType.Wizard, new BasicPropertyHero());
        mana = 0;
        type = HeroType.Wizard;
    }


    public Wizard(String name, BasicPropertyHero basicProperty, double mana) {
        super(name, HeroType.Wizard, basicProperty);
        this.mana = mana;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    @Override
    public void setUniqueProperty(VBox vBox) {
        super.setUniqueProperty(vBox);
        vBox.getChildren().addAll(createUiUniqueProperty(
                "Mana",
                "Enter mane Wizard",
                Double.toString(mana)
        ));
    }

    @Override
    public void updateUniqueProperty(VBox vBox) {
        TextField textField = (TextField) ((HBox) vBox.getChildren().get(1)).getChildren().get(1);
        this.mana = Double.parseDouble(textField.getText());
    }

    @Override
    public String toString() {
        return super.toString() + "-%-" + mana;
    }
}
