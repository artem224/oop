package game.character;

import game.BasicPropertyHero;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.Serializable;

public abstract class Hero implements Serializable {
    protected int level;
    protected String name;
    protected HeroType type;
    protected BasicPropertyHero basicProperty;

    public Hero(String name, HeroType type, BasicPropertyHero basicProperty) {
        this.level = 0;
        this.name = name;
        this.type = type;
        this.basicProperty = basicProperty;
    }

    public BasicPropertyHero getBasicProperty() {
        return basicProperty;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(HeroType type) {
        this.type = type;
    }

    public void setBasicProperty(BasicPropertyHero basicProperty) {
        this.basicProperty = basicProperty;
    }

    public void setUniqueProperty(VBox vBox) {
        Label label = (Label) vBox.getChildren().get(0);
        vBox.getChildren().clear();
        vBox.getChildren().addAll(label);
    }

    public abstract void updateUniqueProperty(VBox vBox);

    public void updatePropertyHero(String name, BasicPropertyHero basicProperty) {
        this.name = name;
        this.basicProperty = basicProperty;
    }


    public SimpleStringProperty getNameSSP() {
        return new SimpleStringProperty(name);
    }

    public SimpleStringProperty getTypeSSP() {
        return new SimpleStringProperty(type.toString());
    }

    @Override
    public String toString() {
        return name + "-%-" + type.toString() + "-%-" + basicProperty.toString();
    }

    public static HBox createUiUniqueProperty(String textLabel, String promptText, String filedText) {
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);
        Label label = new Label(textLabel);
        TextField field = new TextField();
        field.setPromptText(promptText);
        field.setText(filedText);
        hBox.getChildren().addAll(label, field);
        return hBox;
    }
}
