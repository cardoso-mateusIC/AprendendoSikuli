package com.intuitivecare.sikuli;

import com.intuitivecare.sikuli.util.SikuliKeysMapping;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

/**
 *
 * @author acardoso
 */
// TODO: escrever documentação + Logs
public class SikuliKeyboard {

    public static final Logger LOG = LogManager.getLogger(SikuliKeyboard.class);

    /**
     * <p>
     * Metodo que escreve um texto na janela atual.</p>
     *
     * @param texto Texto que será escrito
     */
    public static void writeText(String texto) {
        LOG.info("Escrevendo texto na janela atual.");

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto que será escrito: {}", texto);
        }

        Screen screen = new Screen();
        screen.type(texto);

        LOG.info("Fim do método de escrever texto.");
    }

    /**
     * <p>
     * Metodo para pressionar atalhos no teclado</p>
     *
     * <span>Para usar corretamente, basta passar como primeiro parametro a
     * tecla a ser usada e como segundo param a tecla que sera pressionada em
     * conjunto.</span>
     *
     * <span>Exemplo: ctrl + c - writeCommandCombination("c", "CTRL");</span>
     *
     * @param text Tecla ou String que sera pressionada junto com o comando no
     * teclado
     * @param command Comando do teclado que sera utilizado (Ex: ALT, ENTER,
     * CTRL)
     * @return Booleano indicando que o comando foi executado com sucesso
     */
    public static boolean writeCommandCombination(String text, String command) {
        boolean wrote = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto: {}", text);
            LOG.debug("Command: {}", command);
        }

        LOG.info("Convertendo comando para ser escrito pelo Sikuli");
        String sikuliCommand
                = SikuliKeysMapping.SIKULI_KEYS_MAP.get(command);

        if (sikuliCommand != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Sikuli command: {}", sikuliCommand);
            }

            LOG.info("Escrevendo comando");

            if (text.isBlank()) {
                screen.type(sikuliCommand);
            } else {
                screen.type(text, sikuliCommand);
            }

            wrote = true;
        }

        return wrote;
    }

    /**
     * <p>
     * Metodo para pressionar teclas de comando no teclado</p>
     *
     * <span>Utiliza o metodo writeCommandCombination passando como primeiro
     * param uma String vazia.</span>
     *
     * <span>Exemplo: ENTER - writeCommand("ENTER");</span>
     *
     * @param command Comando do teclado que sera utilizado (Ex: ALT, ENTER,
     * CTRL)
     * @return Booleano indicando que o comando foi executado com sucesso
     */
    public static boolean writeCommand(String command) {
        return writeCommandCombination("", command);
    }

    public static boolean writeCommands(String text, String command1, String command2) {
        boolean wrote = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto: {}", text);
            LOG.debug("Command1: {}", command1);
            LOG.debug("Command2: {}", command2);
        }

        LOG.info("Convertendo comando para ser escrito pelo Sikuli");
      

        int sikuliCommand1
                = SikuliKeysMapping.SIKULI_KEYS_MODIFIER_MAP.get(command1);
        int sikuliCommand2
                = SikuliKeysMapping.SIKULI_KEYS_MODIFIER_MAP.get(command2);

        if (sikuliCommand2 != 0 || sikuliCommand1 != 0) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Sikuli text: {}", text);
                LOG.debug("Sikuli command2: {}", sikuliCommand1);
                LOG.debug("Sikuli command3: {}", sikuliCommand2);
            }

            LOG.info("Escrevendo comando");
            screen.type(text, sikuliCommand1 + sikuliCommand2);
            wrote = true;
        }

        return wrote;

    }
    public static boolean writeCommandCombination(String command1, String command2, String command3) {
        boolean wrote = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Command1: {}", command1);
            LOG.debug("Command2: {}", command2);
            LOG.debug("Command3: {}", command3);
        }

        LOG.info("Convertendo comando para ser escrito pelo Sikuli");
        String sikuliCommand1
                = SikuliKeysMapping.SIKULI_KEYS_MAP.get(command1);

        int sikuliCommand2
                = SikuliKeysMapping.SIKULI_KEYS_MODIFIER_MAP.get(command2);
        int sikuliCommand3
                = SikuliKeysMapping.SIKULI_KEYS_MODIFIER_MAP.get(command3);

        if (sikuliCommand1 != null && sikuliCommand2 != 0) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Sikuli command1: {}", sikuliCommand1);
                LOG.debug("Sikuli command2: {}", sikuliCommand2);
                LOG.debug("Sikuli command3: {}", sikuliCommand3);
            }

            LOG.info("Escrevendo comando");

            screen.type(sikuliCommand1, sikuliCommand2 + sikuliCommand3);

            wrote = true;
        }

        return wrote;

    }

    /**
     * <p>
     * Metodo que pressiona teclas de comandos do teclado</p>
     *
     * <span>Exemplo: ALT + F4 -> writeCommands("F4", "ALT") Obs: As teclas de
     * controle do teclado (ALT, SHIFT, CTRL, DEL) devem estar no segundo param
     * do metodo.
     * </span>
     *
     * @param command1 Comando do teclado ou tecla de funcao. Ex: "DEL", "F1",
     * "F4", etc.
     * @param command2 Tecla de controle do teclado. Ex: "ALT", "CTRL", "SHIFT",
     * "CMD"
     * @return Booleano indicando que o metodo foi executado com sucesso.
     */
    public static boolean writeCommands(String command1, String command2) {
        boolean wrote = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Command1: {}", command1);
            LOG.debug("Command2: {}", command2);
        }

        LOG.info("Convertendo comando para ser escrito pelo Sikuli");
        String sikuliCommand1
                = SikuliKeysMapping.SIKULI_KEYS_MAP.get(command1);

        int sikuliCommand2
                = SikuliKeysMapping.SIKULI_KEYS_MODIFIER_MAP.get(command2);

        if (sikuliCommand1 != null && sikuliCommand2 != 0) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Sikuli command1: {}", sikuliCommand1);
                LOG.debug("Sikuli command2: {}", sikuliCommand2);
            }

            LOG.info("Escrevendo comando");

            screen.type(sikuliCommand1, sikuliCommand2);

            wrote = true;
        }

        return wrote;
    }

    /**
     * <p>
     * Metodo que executa um Paste (colar [CTRL + v]) na tela.</p>
     *
     * <span>Este metodo deve ser utilizado quando o valor digitado na tela
     * possui caracteres especiais, pois o Sikuli trabalha apenas com o teclado
     * norte-americano.</span>
     *
     * <span>Obs: Esse metodo tem um efeito colateral que e ocupar a area de
     * transferencia da maquina que esta executando e, por conta disso, e
     * recomendavel que ele seja usado o minimo possivel</span>
     *
     * @param text Texto que sera colado.
     */
    public static void pasteText(String text) {
        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto: {}", text);
        }

        LOG.info("Colando texto.");
        screen.paste(text);
    }
}
