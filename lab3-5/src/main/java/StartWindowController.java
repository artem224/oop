import adapter.BinAdapter;
import adapter.TxtAdapter;
import adapter.XMLAdapter;
import command.*;
import decorator.JSONConvert;
import decorator.SerializeDecorator;
import decorator.ZipArchive;
import serialize.Serialize;
import game.BasicPropertyHero;
import game.character.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import plugin.PluginLoader;
import util.DateSave;
import util.TableSize;

import java.beans.XMLDecoder;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StartWindowController {

    private ObservableList<Hero> heroObservableList = FXCollections.observableArrayList();

    public ObservableList<Hero> getHeroObservableList() {
        return heroObservableList;
    }

    public TableView<Hero> getHeroTableView() {
        return heroTableView;
    }

    @FXML
    private ComboBox<String> fileExtensionBox;

    @FXML
    private TableView<Hero> heroTableView;

    @FXML
    private TableColumn<Hero, String> nameHeroColumn;

    @FXML
    private TableColumn<Hero, String> typeHeroColumn;

    @FXML
    private ComboBox<String> pluginCheckBox;



    @FXML
    void addHero() {
        navigatorTo(
                new Wizard("name", new BasicPropertyHero(), 0),
                false,
                "Add Window"
        );
    }

    @FXML
    void clearTable() {
        heroObservableList.clear();
    }

    @FXML
    void deleteHero() {
        if (heroTableView.getSelectionModel().isEmpty()) {
            showWarningDialog("The item was not selected");
            return;
        }
        heroObservableList.remove(heroTableView.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void editHero() {
        if (heroTableView.getSelectionModel().isEmpty()) {
            showWarningDialog("The item was not selected");
            return;
        }
        navigatorTo(
                heroObservableList.get(heroTableView.getSelectionModel().getSelectedIndex()),
                true,
                "Edit Window"
        );
    }

    @FXML
    void loadDataTable() {
        deserialize(fileExtensionBox.getSelectionModel().getSelectedIndex());
    }

    @FXML
    void saveDataTable() {
        if (heroObservableList.isEmpty()) {
            showWarningDialog("Table is empty");
            return;
        }
        Serialize adapter = getAdapter(fileExtensionBox.getSelectionModel().getSelectedIndex());
        int type = pluginCheckBox.getSelectionModel().getSelectedIndex();
        if (type == 2) {
            DateSave dateSave = new DateSave(adapter);
            dateSave.saveDate(heroObservableList);
        } else if (type == 0) {
            Serialize json = new JSONConvert(adapter);
            json.serialize(heroObservableList);
        } else {
            Serialize zip = new ZipArchive(adapter);
            zip.serialize(heroObservableList);
        }
    }

    @FXML
    void initialize() {
        fileExtensionBox.getItems().addAll("xml", "bin", "str");
        fileExtensionBox.getSelectionModel().select(0);
        pluginCheckBox.getItems().addAll("JSON", "ZIP", "Nothing");
        pluginCheckBox.getSelectionModel().select(2);

        heroTableView.setItems(heroObservableList);
        nameHeroColumn.setCellValueFactory(cellData -> cellData.getValue().getNameSSP());
        typeHeroColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeSSP());

    }

    private void showWarningDialog(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Serialize getAdapter(int type) {
        switch (type) {
            case 0:
                return new XMLAdapter();
            case 1:
                return new BinAdapter();
            case 2:
                return new TxtAdapter();
            default:
                return null;
        }
    }

    private void deserialize(int type) {
        HeroTableOperationExecutor executor = new HeroTableOperationExecutor();
        switch (type) {
            case 0:
                executor.executeOperation(new DeserializeHeroTable(new XMLDeserialize(heroObservableList)));
                break;
            case 1:
                executor.executeOperation(new DeserializeHeroTable(new BinDeserialize(heroObservableList)));
                break;
            case 2:
                executor.executeOperation(new DeserializeHeroTable(new TxtDeserialize(heroObservableList)));
                break;
        }
    }

    private void navigatorTo(Hero hero, boolean isEditState, String title) {
        Stage primaryStage = new Stage();
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("createHeroWindow.fxml");
            loader.setLocation(xmlUrl);
            root = loader.load();
            CreateHeroWindowController controller = loader.getController();
            controller.setCurrentHero(hero);
            controller.setEditState(isEditState);
            controller.setStartWindowController(this);
            controller.fillFields();

        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle(title);
        primaryStage.setResizable(false);
        assert root != null;
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
