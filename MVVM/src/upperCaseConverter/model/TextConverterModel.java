package upperCaseConverter.model;

public class TextConverterModel implements TextConverter {
    @Override
    public String toUpperCaseText(String text) {
        return text.toUpperCase();
    }
}
