/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intuitivecare.sikuli;

import static com.intuitivecare.sikuli.SikuliImage.LOG;
import static com.intuitivecare.sikuli.SikuliText.checkTexto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

/**
 *
 * @author acardoso
 */
public class SikuliMouse {

    public static final Logger LOG = LogManager.getLogger(SikuliApp.class);

    /**
     * <p>
     * Clica na tela atual ao encontrar uma imagem passada como parâmetro</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @return true se o click ocorreu e false caso contrario
     */
    public static boolean click(String imgPath) {
        return click(imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Clica na tela atual ao encontrar uma imagem passada como parâmetro</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o click ocorreu e false caso contrario
     */
    public static boolean click(String imgPath, double timeout) {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(screen, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Clicando na tela");
            screen.click();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Clica em uma Region ao encontrar uma imagem passada como parâmetro</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse.
     * @param region Region que será utilizada para procurar a imagem.
     * @return true se o click ocorreu e false caso contrario
     */
    public static boolean click(Region region, String imgPath) {
        return click(region, imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Clica em uma Region ao encontrar uma imagem passada como parâmetro</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param region Region que será utilizada para procurar a imagem.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse.
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o click ocorreu e false caso contrario
     */
    public static boolean click(Region region, String imgPath, double timeout) {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(region, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Clicando na tela");
            region.click();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Move o mouse até a posição da imagem encontrada na tela</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @return true se o move do mouse ocorreu e false caso contrario
     */
    public static boolean move(String imgPath) {
        return move(imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Move o mouse até a posição da imagem encontrada na tela</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o move do mouse ocorreu e false caso contrario
     */
    public static boolean move(String imgPath, double timeout) {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(screen, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Movendo até a posição.");
            screen.mouseMove();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Move o mouse até a posição da imagem encontrada em uma Region na tela</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param region Region que será utilizada para procurar a imagem.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @return true se o move do mouse ocorreu e false caso contrario
     */
    public static boolean move(Region region, String imgPath) {
        return move(region, imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Move o mouse até a posição da imagem encontrada em uma Region na tela</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param region Region que será utilizada para procurar a imagem.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse.
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o move do mouse ocorreu e false caso contrario
     */
    public static boolean move(Region region, String imgPath, double timeout) {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(region, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Movendo até a posição.");
            region.mouseMove();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Clica com o botão direito do mouse na posição da imagem encontrada na
     * tela</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param imgPath Imagem que sera comparada com a tela para que haja o
     * clique do mouse
     * @return true se o clique com o botao direito ocorreu e false caso
     * contrario
     */
    public static boolean rightClick(String imgPath) {
        return rightClick(imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Clica com o botão direito do mouse na posição da imagem encontrada na
     * tela</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o clique com o botao direito ocorreu e false caso
     * contrario
     */
    public static boolean rightClick(String imgPath, double timeout) {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(screen, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Clicando com o botão direito na posição.");
            screen.rightClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Clica com o botão direito do mouse na posição da imagem encontrada na
     * tela</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param region Region em que a imagem será procurada.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @return true se o clique com o botao direito ocorreu e false caso
     * contrario
     */
    public static boolean rightClick(Region region, String imgPath) {
        return rightClick(region, imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Clica com o botão direito do mouse na posição da imagem encontrada na
     * tela</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param region Region em que a imagem será procurada.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o clique com o botao direito ocorreu e false caso
     * contrario
     */
    public static boolean rightClick(Region region, String imgPath, double timeout) {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(region, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Clicando com o botão direito na posição.");
            region.rightClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Duplo-clique na posição da imagem encontrada na tela</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @return true se o duplo-clique ocorreu e false caso contrario
     */
    public static boolean doubleClick(String imgPath) {
        return doubleClick(imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Duplo-clique na posição da imagem encontrada na tela</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o duplo-clique ocorreu e false caso contrario
     */
    public static boolean doubleClick(String imgPath, double timeout) {
        boolean success = false;

        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(screen, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Fazendo duplo-clique na posição.");
            screen.doubleClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Duplo-clique na posição da imagem encontrada na tela</p>
     *
     * <span>Utiliza o timeout default do Sikuli para procurar a imagem.</span>
     *
     * @param region Region em que a imagem será procurada.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @return true se o duplo-clique ocorreu e false caso contrario
     */
    public static boolean doubleClick(Region region, String imgPath) {
        return doubleClick(region, imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Duplo-clique na posição da imagem encontrada na tela</p>
     *
     * <span>Utiliza um timeout customizado para procurar a imagem.</span>
     *
     * @param region Region em que a imagem será procurada.
     * @param imgPath Imagem que será comparada com a tela para que haja o
     * clique do mouse
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return true se o duplo-clique ocorreu e false caso contrario
     */
    public static boolean doubleClick(Region region, String imgPath, double timeout) {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
        }

        if (SikuliImage.checkImage(region, imgPath, timeout)) {
            LOG.info("Imagem encontrada. Fazendo duplo-clique na posição.");
            region.doubleClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Realiza duplo-clique na tela na soma da posição de uma imagem mais
     * acrescimos em x e y </p>
     *
     * @param imagePath Caminho da imagem referente ao clique.
     * @param x coordenada x em relacao a imagem
     * @param y coordenada y em relacao a imagem
     */
    public static  boolean moveDoubleClick(String imagePath, int x, int y) {
        LOG.info("Buscando imagens: '" + String.join(" -- ", imagePath) + "'");
        Screen screen = new Screen();
        Pattern pattern = new Pattern(imagePath).similar(0.95f);
        Match m = screen.exists(pattern);
        Region region = null;
        if (!(m == null)) {
            region = new Region(m.getRect().x + x, m.getRect().y + y, m.getRect().width, m.getRect().height);
            region.doubleClick();
            LOG.info("Moveu mouse e clicou");
        }
        return !(region == null) ;
    }

    /**
     * <p>
     * Realiza o clique na tela na posição de um texto encontrado</p>
     *
     * @param texto Texto que será procurado na tela
     * @return true se o click ocorreu e false caso contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean clickText(String texto) throws FindFailed {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(screen, texto)) {
            LOG.info("Texto encontrado. Clicando na posição.");
            screen.click();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Realiza o clique em uma Region na posição de um texto encontrado</p>
     *
     * @param region Region em que o texto será procurado
     * @param texto Texto que será procurado na tela
     * @return true se o click ocorreu e false caso contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean clickText(Region region, String texto) throws FindFailed {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(region, texto)) {
            LOG.info("Texto encontrado. Clicando na posição.");
            region.click();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Move o mouse na tela para a posição de um texto encontrado</p>
     *
     * @param texto Texto que será procurado na tela
     * @return true se o move do mouse ocorreu e false caso contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean moveToText(String texto) throws FindFailed {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(screen, texto)) {
            LOG.info("Texto encontrado. Movendo o mouse para a posição.");
            screen.mouseMove();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Move o mouse em uma Region para a posição de um texto encontrado</p>
     *
     * @param region Region em que o texto será procurado
     * @param texto Texto que será procurado na tela
     * @return true se o move do mouse ocorreu e false caso contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean moveToText(Region region, String texto) throws FindFailed {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(region, texto)) {
            LOG.info("Texto encontrado. Movendo o mouse para a posição.");
            region.mouseMove();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Clica com o botão direito do mouse na tela na posição de um texto
     * encontrado</p>
     *
     * @param texto Texto que será procurado na tela
     * @return true se o clique com o botao direito ocorreu e false caso
     * contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean rightClickText(String texto) throws FindFailed {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(screen, texto)) {
            LOG.info("Texto encontrado. Clicando com o botão direito na posição.");
            screen.rightClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Clica com o botão direito do mouse em uma Region na posição de um texto
     * encontrado</p>
     *
     * @param region Region em que o texto será procurado
     * @param texto Texto que será procurado na tela
     * @return true se o clique com o botao direito ocorreu e false caso
     * contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean rightClickText(Region region, String texto) throws FindFailed {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(region, texto)) {
            LOG.info("Texto encontrado. Clicando com o botão direito na posição.");
            region.rightClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Realiza duplo-clique na tela na posição de um texto encontrado</p>
     *
     * @param texto Texto que será procurado na tela
     * @return true se o duplo-clique ocorreu e false caso contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean doubleClickText(String texto) throws FindFailed {
        boolean success = false;

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(screen, texto)) {
            LOG.info("Texto encontrado. Realizando duplo-clique na posição.");
            screen.doubleClick();
            success = true;
        }

        return success;
    }

    /**
     * <p>
     * Realiza duplo-clique em uma Region na posição de um texto encontrado</p>
     *
     * @param region Region em que o texto será procurado
     * @param texto Texto que será procurado na tela
     * @return true se o duplo-clique ocorreu e false caso contrario
     * @throws FindFailed Exceção lançada caso o texto não seja encontrado.
     */
    public static boolean doubleClickText(Region region, String texto) throws FindFailed {
        boolean success = false;

        if (LOG.isDebugEnabled()) {
            LOG.debug("Texto procurado: {}", texto);
        }

        if (checkTexto(region, texto)) {
            LOG.info("Texto encontrado. Realizando duplo-clique na posição.");
            region.doubleClick();
            success = true;
        }

        return success;
    }

}
