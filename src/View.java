import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class View implements Initializable {


    public MenuButton alphabetValue;
    public Text lblAlphabet;
    public Text lblNumberOfSentences;

    public Spinner <Integer> spMinWords;

    final int INITIAL_VALUE = 1;
    public TextArea handleValue;


    SpinnerValueFactory<Integer> svfLevel = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20, INITIAL_VALUE);

    public Spinner <Integer> spMaxWords;
    SpinnerValueFactory<Integer> svfLevel2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20, INITIAL_VALUE);
    public Spinner <Integer> spMinCharacters;
    SpinnerValueFactory<Integer> svfLevel3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20, INITIAL_VALUE);
    public Spinner <Integer> spMaxCharacters;
    SpinnerValueFactory<Integer> svfLevel4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20, INITIAL_VALUE);

    public Text lblNumberOfCharacters;
    public Spinner <Integer> spNumberOfSentences;

    SpinnerValueFactory<Integer> svfLevel5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20, INITIAL_VALUE);
    public Text lblNumberOfWords;
    public Button btnGenerate;
    public TextArea taSummary;




    public void handleBtnGenerate(ActionEvent actionEvent) {


        String alphabet = "";
        char letter = 4304; // ASCII Georgian language 4304 = ა;


//      number of word in each sentences random generator;

        Random rd = new Random();
        int words = rd.nextInt(spMinCharacters.getValue(), spMaxCharacters.getValue() + 1);


//      number of word in each sentences random generator;


//      number of word in each sentences random generator

        Random rd2 = new Random();
        int sentences = rd2.nextInt(spMinWords.getValue(), spMaxWords.getValue() + 1);

//      number of word in each sentences random generator


        for (int b = 0 ; b < words; b++){
                alphabet += letter++;
        }

        for (int c = 0 ; c < spNumberOfSentences.getValue(); c++){
            for (int i = 0 ; i < sentences; i++){
                taSummary.appendText( alphabet + " ");
            }
            taSummary.appendText("\n");
        }

        System.out.println("xazi" +spNumberOfSentences.getValue());
        System.out.println("Senteces" +sentences);
        System.out.println("Words" +words);




        // clear and than add statistic

        String text = alphabetValue.getItems().get(0).getText();
        handleValue.clear();
        handleValue.appendText(String.valueOf(text + ": " + spNumberOfSentences.getValue()) + " sentences; " + sentences * spNumberOfSentences.getValue() + "words; " + sentences * words * spNumberOfSentences.getValue() + "characters.");

        // clear and than add statistic




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // default value

        spMinWords.setValueFactory(svfLevel);
        spMaxWords.setValueFactory(svfLevel2);


        spMinCharacters.setValueFactory(svfLevel3);
        spMaxCharacters.setValueFactory(svfLevel4);

        spNumberOfSentences.setValueFactory(svfLevel5);



    }

}
