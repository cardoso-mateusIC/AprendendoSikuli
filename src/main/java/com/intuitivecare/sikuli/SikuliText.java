package com.intuitivecare.sikuli;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 *
 * @author acardoso
 */
public class SikuliText {

    public static final Logger LOG = LogManager.getLogger(SikuliApp.class);

    /**
     * <p>
     * Verifica a existencia de um texto na tela atual</p>
     *
     * <span>Utiliza o timeout default do Sikuli.</span>
     *
     * @param texto Texto a ser comparado
     * @return True se o texto existe na tela ou False se nao existe
     * @throws FindFailed Exception caso o texto nao possa ser encontrado
     */
    public static boolean checkTexto(String texto) throws FindFailed {
        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        LOG.info("Verificando existência do texto.");
        return screen.findText(texto) != null
                || screen.findWord(texto) != null;
    }

    public static String copyAllToClipboard() throws InterruptedException {
        Thread.sleep(100);
        Screen screen = new Screen();
        screen.type("c", KeyModifier.CTRL);
        Thread.sleep(100);
        String clipboard = App.getClipboard();

        return clipboard;
    }

    /**
     * <p>
     * Verifica a existencia de um texto em uma Region passada como
     * parametro</p>
     *
     * <span>Utiliza o timeout default do Sikuli.</span>
     *
     * @param region Objeto Region que servira de base para a comparacao
     * @param texto Texto a ser comparado
     * @return True se o texto existe na tela ou False se nao existe
     * @throws FindFailed Exception caso o texto nao possa ser encontrado
     */
    public static boolean checkTexto(Region region, String texto) throws FindFailed {
        return region.findText(texto) != null
                || region.findWord(texto) != null;
    }
}
