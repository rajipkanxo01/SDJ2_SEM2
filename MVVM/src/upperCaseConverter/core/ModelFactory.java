package upperCaseConverter.core;

import upperCaseConverter.model.TextConverter;
import upperCaseConverter.model.TextConverterModel;

public class ModelFactory {
    private TextConverter textConverter;

    public TextConverter getTextConverter() {
        if (textConverter == null) {
            textConverter = new TextConverterModel();
        }
        return textConverter;
    }
}
