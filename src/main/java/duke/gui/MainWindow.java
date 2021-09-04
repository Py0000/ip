package duke.gui;

import duke.Duke;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for MainWindow.
 * Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke chatBot;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/UserIcon.png"));
    private final Image botImage = new Image(this.getClass().getResourceAsStream("/images/BotIcon.png"));

    /**
     * Sets up the application UI when started.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        assert (!botImage.isBackgroundLoading()) : "Chat Bot Icon not loaded in GUI";
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(Ui.greetUser(), botImage));
    }

    public void setChatBot(Duke duke) {
        chatBot = duke;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and
     * then appends them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = chatBot.getResponse(input);
        assert (!userImage.isBackgroundLoading()) : "User Icon not loaded in GUI";
        assert (!botImage.isBackgroundLoading()) : "Chat Bot Icon not loaded in GUI";
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input + "    ", userImage),
                DialogBox.getDukeDialog(response, botImage)
        );
        userInput.clear();
    }
}
