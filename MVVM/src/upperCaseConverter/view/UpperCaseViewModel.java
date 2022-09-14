package upperCaseConverter.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import upperCaseConverter.model.TextConverter;
import upperCaseConverter.model.TextConverterModel;

public class UpperCaseViewModel {
    private TextConverter textConverter;
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;

    public UpperCaseViewModel(TextConverter textConverter) {
        this.textConverter = textConverter;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
    }

    public void convert() {
        String input = request.get();
        if (input != null && !input.equals("")) {
            String result = textConverter.toUpperCaseText(input);
            reply.set(result);
        } else {
            error.setValue("Source Text is Empty");
        }
    }

    public String getRequest() {
        return request.get();
    }

    public StringProperty requestProperty() {
        return request;
    }

    public String getReply() {
        return reply.get();
    }

    public StringProperty replyProperty() {
        return reply;
    }

    public String getError() {
        return error.get();
    }

    public StringProperty errorProperty() {
        return error;
    }
}
