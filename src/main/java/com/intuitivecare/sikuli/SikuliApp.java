package com.intuitivecare.sikuli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.script.App;

/**
 *
 * @author acardoso
 */
public class SikuliApp {
    
    public static final Logger LOG = LogManager.getLogger(SikuliApp.class);
    
    private SikuliApp() {}
    
    /**
     * <p>Metodo que abre uma aplicacao pelo sikuli</p>
     * 
     * @param caminhoAplicacao Caminho da aplicacao que sera aberta
     * @return true se a aplicacao foi aberta com sucesso e false caso contrario
     */
    public static boolean openApp(String caminhoAplicacao) {
        boolean success = false;
        
        LOG.info("Abrindo aplicação.");
        
        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da aplicação: {}", caminhoAplicacao);
        }
        
        App app = App.open(caminhoAplicacao);
        
        if (app != null) {
            LOG.info("Aplicação aberta com sucesso.");
            
            app.focus();
            success = true;
        }
        
        return success;
    }
}
