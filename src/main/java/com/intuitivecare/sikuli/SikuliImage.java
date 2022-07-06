package com.intuitivecare.sikuli;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import static com.intuitivecare.sikuli.util.SikuliUtilInternal.convertImagesToPatternObjects;
import org.sikuli.basics.Settings;

/**
 *
 * @author acardoso
 */
public class SikuliImage {

    public static final Logger LOG = LogManager.getLogger(SikuliImage.class);

    /**
     * <p>
     * Verifica a existencia de uma imagem na tela atual pelo caminho da imagem
     * a ser comparada</p>
     *
     * <span>Utiliza o timeout default do Sikuli.</span>
     *
     * @param imgPath Caminho local da imagem a ser comparada na tela.
     * @return True se a imagem existe ou False se a imagem nao existe na tela
     */
    public static boolean checkImage(String imgPath) {
        return checkImage(imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Verifica a existencia de uma imagem na tela atual pelo caminho da imagem
     * a ser comparada</p>
     *
     * <span>Utiliza um timeout customizado passado para o metodo</span>
     *
     * @param imgPath Caminho local da imagem a ser comparada na tela.
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return True se a imagem existe ou False se a imagem nao existe na tela.
     */
    public static boolean checkImage(String imgPath, double timeout) {
        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
            LOG.debug("Tempo de timeout: {}s", timeout);
        }

        LOG.info("Verificando existência da imagem.");
        return screen.exists(imgPath, timeout) != null;
    }

    /**
     * <p>
     * Verifica a existencia de uma imagem em um objeto Region pelo caminho da
     * imagem a ser comparada</p>
     *
     * <span>Utiliza o timeout default do Sikuli.</span>
     *
     * @param region Region a ser comparada.
     * @param imgPath Caminho local da imagem a ser comparada na tela.
     * @return True se a imagem existe ou False se a imagem nao existe na tela.
     */
    public static boolean checkImage(Region region, String imgPath) {
        return checkImage(region, imgPath, Settings.AutoWaitTimeout);
    }

    /**
     * <p>
     * Verifica a existencia de uma imagem em um objeto Region pelo caminho da
     * imagem a ser comparada</p>
     *
     * <span>Utiliza um timeout customizado passado para o método</span>
     *
     * @param region Region a ser comparada.
     * @param imgPath Caminho local da imagem a ser comparada na tela.
     * @param timeout Tempo de timeout para procurar a imagem na tela.
     * @return True se a imagem existe ou False se a imagem nao existe na tela.
     */
    public static boolean checkImage(Region region, String imgPath, double timeout) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Caminho da imagem: {}", imgPath);
            LOG.debug("Tempo de timeout: {}s", timeout);
        }

        LOG.info("Verificando existência da imagem.");
        return region.exists(imgPath, timeout) != null;
    }

    /**
     * <p>
     * Metodo que verifica a presença de varias imagens ao mesmo tempo na
     * tela</p>
     *
     * <span>Uma lista com caminhos de imagens e passada e o Sikuli verifica ao
     * mesmo tempo quais imagens estão presentes na tela</span>
     *
     * <span>Esta busca e feita durante um tempo passado para o metodo, porem
     * para ao encontrar a primeira imagem da lista e retorna o sucesso</span>
     *
     * <span>Tambem e possivel passar a similaridade (entre 0 e 1) que sera
     * usada para dar match na imagem</span>
     *
     * <span>O metodo retorna apenas o caminho da primeira imagem
     * encontrada</span>
     *
     * @param imgPaths Lista com caminhos das imagens que serao pesquisadas na
     * tela
     * @param similarity Double entre 0 e 1 que indica a similaridade para a
     * imagem ser considerada um match
     * @param waitingTime Tempo que o programa ira procurar a imagem na tela
     * @param timeUnit Unidade de tempo (DIAS, MINUTOS, SEGUNDOS, HORAS etc) que
     * sera usado no param waitingTime
     * @return O caminho da primeira imagem encontrada na tela
     */
    public static String checkImages(List<String> imgPaths,
            double similarity, double waitingTime, TimeUnit timeUnit) {

        Settings.ActionLogs = true;
        Settings.InfoLogs = true;
        
        LOG.info("VERSAO COM MAIS LOGS!!!!");
        
        List<Match> matches = new ArrayList();

        LOG.info("Criando objeto referente à tela atual.");
        Screen screen = new Screen();

        if (LOG.isDebugEnabled()) {
            LOG.debug("imgPaths: {}", imgPaths.toString());
            LOG.debug("similarity: {}", similarity);
            LOG.debug("waitingTime: {}", waitingTime);
            LOG.debug("TimeUnit: {}", timeUnit.toString());
        }

        LOG.info("Iniciando a busca pelas imagens");

        List<Object> patterns = convertImagesToPatternObjects(imgPaths, similarity);

        Stopwatch sw = Stopwatch.createStarted();
        while (sw.elapsed(timeUnit) <= waitingTime && matches.isEmpty()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Nenhuma imagem encontrada. "
                        + "Tempo parcial de busca: {} {}", sw.elapsed(timeUnit),
                        timeUnit.toString());
                LOG.debug("waitingTime: {}", waitingTime);
            }
            
            matches = screen.findAnyList(patterns);
        }

        sw.stop();

        LOG.info("Busca finalizada em {} {}", sw.elapsed(timeUnit), timeUnit.toString());
        return matches.isEmpty()
                ? "" : matches.get(0).getImageFilename();
    }

    /**
     * <p>
     * Overload do metodo checkImages passando apenas o caminho das imagens</p>
     *
     * <span>Mesma funcionalidade do metodo checkImages usando como params o
     * tempo e similaridade defaults do Sikuli</span>
     *
     * @param imgPaths Lista de caminhos das imagens que serao procuradas na
     * tela
     * @return O caminho da primeira imagem encontrada na tela
     */
    public static String checkImages(List<String> imgPaths) {
        return checkImages(imgPaths, Settings.MinSimilarity,
                Settings.AutoWaitTimeout, TimeUnit.SECONDS);
    }

    /**
     * <p>
     * Overload do metodo checkImages passando o caminho das imagens e o tempo
     * limite de busca</p>
     *
     * <span>Mesma funcionalidade do metodo checkImages usando como params a
     * similaridade default do sikuli</span>
     *
     * @param imgPaths Lista de caminhos das imagens que serao procuradas na
     * tela
     * @param waitingTime Tempo que o programa ira procurar a imagem na tela
     * @param timeUnit Unidade de tempo (DIAS, MINUTOS, SEGUNDOS, HORAS etc) que
     * sera usado no param waitingTime
     * @return O caminho da primeira imagem encontrada na tela
     */
    public static String checkImagesForSpecificTime(
            List<String> imgPaths, double waitingTime, TimeUnit timeUnit) {

        return checkImages(imgPaths, Settings.MinSimilarity, waitingTime, timeUnit);
    }

    /**
     * <p>
     * Overload do metodo checkImages passando o caminho das imagens e o tempo
     * limite de busca (sem a unidade de tempo, que e considerada como sendo
     * SEGUNDOS)</p>
     *
     * <span>Mesma funcionalidade do metodo checkImages usando como params a
     * similaridade default do sikuli</span>
     *
     * @param imgPaths Lista de caminhos das imagens que serao procuradas na
     * tela
     * @param waitingTime Tempo que o programa ira procurar a imagem na tela
     * @return O caminho da primeira imagem encontrada na tela
     */
    public static String checkImagesForSpecificTime(
            List<String> imgPaths, double waitingTime) {

        return checkImages(imgPaths, Settings.MinSimilarity,
                waitingTime, TimeUnit.SECONDS);
    }

    /**
     * <p>
     * Overload do metodo checkImages passando o caminho das imagens e a
     * similaridade para dar match nas imagens</p>
     *
     * <span>Mesma funcionalidade do metodo checkImages usando como params o
     * tempo de espera default do Sikuli</span>
     *
     * @param imgPaths Lista de caminhos das imagens que serao procuradas na
     * tela
     * @param similarity Double entre 0 e 1 que indica a similaridada para a
     * imagem ser considerada um match
     * @return O caminho da primeira imagem encontrada na tela
     */
    public static String checkImagesWithSimilarity(
            List<String> imgPaths, double similarity) {

        return checkImages(imgPaths, similarity,
                Settings.AutoWaitTimeout, TimeUnit.SECONDS);
    }

    /**
     * <p>
     * Metodo que tira uma captura da tela atual e grava em um caminho
     * especifico.</p>
     *
     * @param caminho Caminho em que a captura sera gravada
     * @param nome Nome do arquivo em que a captura sera gravada
     */
    public static void tiraScreenShot(String caminho, String nome) {
        Screen screen = new Screen();

        screen.saveScreenCapture(caminho, nome);
    }
 

}
