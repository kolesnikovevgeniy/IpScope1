package otp.utils.ipscope;

/**
 * Created by user on 04.08.2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import otp.utils.ipscope.model.IPAddress;
import java.sql.Timestamp;
import java.util.Date;

public class Controller {
    @FXML
    private TextField tfLeftIP;

    @FXML
    private TextField tfRightIP;

    @FXML
    private TextArea tfOutputScope;

    @FXML
    private Label lOutput;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnExit;

    // Ссылка на главное приложение.
    private AppMain mainApp;

    /**
     * Конструктор.
     */
    public Controller() {
    }

    /**
     * Обработчик нажатия на кнопку запуска.
     */
    @FXML
    private void handleStart()
    {
        java.util.Date date= new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());

        lOutput.setText("Работаю...");
        IPAddress ipLeft = new IPAddress();
        IPAddress ipRight = new IPAddress();

        if(!ipLeft.set(tfLeftIP.getText()) || !ipRight.set(tfRightIP.getText()))
        {
            lOutput.setText("Ошибка: неверный формат ip.");
            return;
        }

        if (ipLeft.compare(ipRight) == -1)
        {
            lOutput.setText("Ошибка: неправильно задан диапазон.");
            return;
        }
        String stOutScope = ipLeft.toString() + "\r\n";;
        //old version
        /*
        while(ipLeft.compare(ipRight) != 0)
        {
            ipLeft.increment();
            stOutScope += ipLeft.toString() + "\r\n";

        }*/
        int n = ipRight.getIntIP() - ipLeft.getIntIP();
        for(int i = 0; i < n; i++)
        {
            ipLeft.increment();
            stOutScope += ipLeft.toString() + "\r\n";
        }
        //stOutScope += ipRight.toString();
        tfOutputScope.setText(stOutScope);
        lOutput.setText("Готово");
    }

    /**
     * Обработчик нажатия на кнопку выхода.
     */
    @FXML
    private void handleExit()
    {
        try
        {
            // выход
            System.exit(0);
        }catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    /**
     * Инициализация класса-контроллера.
     */
    @FXML
    private void initialize() {

    }

    /**
     *
     * @param mainApp
     */
    public void setMainApp(AppMain mainApp) {
        this.mainApp = mainApp;
    }
}