package upperCaseSocketsMVVM.client.core;


import upperCaseSocketsMVVM.client.model.TextConverter;
import upperCaseSocketsMVVM.client.model.TextConverterManager;

public class ModelFactory {

    private TextConverter textConverter;
    private ClientFactory cf;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public TextConverter getTextConverter() {
        if(textConverter == null)
            textConverter = new TextConverterManager(cf.getClient());
        return textConverter;
    }
}


