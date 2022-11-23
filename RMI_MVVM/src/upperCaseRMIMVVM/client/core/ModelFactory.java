package upperCaseRMIMVVM.client.core;


import upperCaseRMIMVVM.client.model.TextConverterManager;
import upperCaseRMIMVVM.client.model.TextConverter;

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


