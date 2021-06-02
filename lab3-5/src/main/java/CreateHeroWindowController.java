import game.BasicPropertyHero;
import game.character.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateHeroWindowController {

    private Hero currentHero;

    private boolean isEditState;
    private  boolean isInit = true;

    private StartWindowController startWindowController;

    public void setEditState(boolean editState) {
        isEditState = editState;
    }

    public void setStartWindowController(StartWindowController startWindowController) {
        this.startWindowController = startWindowController;
    }

    @FXML
    private ComboBox<String> typeHeroComboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField damageTextField;

    @FXML
    private TextField healthTextField;

    @FXML
    private TextField intelligenceTextField;

    @FXML
    private TextField defenseTextField;

    @FXML
    private VBox uniquePropsVBox;


    public CreateHeroWindowController() {
    }

    @FXML
    void cancelAction() {
        ((Stage) uniquePropsVBox.getScene().getWindow()).close();
    }

    @FXML
    void okAction() {
        currentHero.updatePropertyHero(
                nameTextField.getText(),
                new BasicPropertyHero(
                        Double.parseDouble(damageTextField.getText()),
                        Double.parseDouble(healthTextField.getText()),
                        Integer.parseInt(intelligenceTextField.getText()),
                        Integer.parseInt(defenseTextField.getText())
                )
        );
        currentHero.updateUniqueProperty(uniquePropsVBox);
        if (isEditState) {
            startWindowController.getHeroObservableList().
                    set(startWindowController.getHeroTableView().getSelectionModel().getFocusedIndex(), currentHero);
        } else {
            startWindowController.getHeroObservableList().add(currentHero);
        }
        ((Stage) uniquePropsVBox.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
        typeHeroComboBox.getItems().addAll("Волшебник", "Воин", "Рейнджер", "Священник", "Чародей", "Паладин");
        typeHeroComboBox.getSelectionModel().selectedItemProperty().addListener((
                (options, oldValue, newValue) -> init(newValue)
        ));
    }

    private void init(String type) {
        if (isInit) {
            isInit = false;
        } else {
            changeType(type);
        }
    }

    private void changeType(String type) {
        switch (type) {
            case "Паладин":
                currentHero = new Paladin(currentHero.getName(), currentHero.getBasicProperty(), 0, 0);
                break;
            case "Священник":
                currentHero = new Priest(currentHero.getName(), currentHero.getBasicProperty(), 0, 0);
                break;
            case "Рейнджер":
                currentHero = new Ranger(currentHero.getName(), currentHero.getBasicProperty(), 0);
                break;
            case "Чародей":
                currentHero = new Warlock(currentHero.getName(), currentHero.getBasicProperty(), 0, 0);
                break;
            case "Воин":
                currentHero = new Warrior(currentHero.getName(), currentHero.getBasicProperty(), 0);
                break;
            case "Волшебник":
                currentHero = new Wizard(currentHero.getName(), currentHero.getBasicProperty(), 0);
                break;
        }
        currentHero.setUniqueProperty(uniquePropsVBox);
    }


    private void fillBasicFields() {
        nameTextField.setText(currentHero.getName());
        typeHeroComboBox.getSelectionModel().select(currentHero.getType());
        damageTextField.setText(Double.toString(currentHero.getBasicProperty().getDefense()));
        healthTextField.setText(Double.toString(currentHero.getBasicProperty().getHealth()));
        intelligenceTextField.setText(Integer.toString(currentHero.getBasicProperty().getIntelligence()));
        defenseTextField.setText(Integer.toString(currentHero.getBasicProperty().getDefense()));
    }

    public void fillFields() {
        fillBasicFields();
        currentHero.setUniqueProperty(uniquePropsVBox);
    }

    public void setCurrentHero(Hero currentHero) {
        this.currentHero = currentHero;
    }
}
