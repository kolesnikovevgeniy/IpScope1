package otp.utils.ipscope;

/**
 * Created by user on 04.08.2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import otp.utils.ipscope.AppMain;

public class Controller {
    @FXML
    private TextField tfLeftIP;

    @FXML
    private TextField tfRightIP;

    @FXML
    private TextField tfOutputScope;

    @FXML
    private TextField tfOutput;


    // Ссылка на главное приложение.
    private AppMain mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public Controller() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        //firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        //lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(AppMain mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        //personTable.setItems(mainApp.getPersonData());
    }
}