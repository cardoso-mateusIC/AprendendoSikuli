package com.intuitivecare.sikuli.util;

import java.util.List;
import java.util.stream.Collectors;
import org.sikuli.basics.Settings;
import org.sikuli.script.Pattern;

/**
 *
 * @author acardoso
 */
public class SikuliUtilInternal {
    
    /**
     * <p>Metodo que cria um objeto Pattern de acordo com um caminho de imagem e uma similaridade para o match</p>
     * 
     * @param imgPath Caminho da imagem a ser buscada
     * @param similarity Double variando entre 0 a 1 que indica a similaridade para o match da imagem
     * @return Objeto Pattern
     */
    public static Pattern convertImagePathToPattern(String imgPath, double similarity) {
        return new Pattern(imgPath).similar(similarity);
    }
    
    /**
     * <p>Overload do metodo convertImagePathToPattern usando a similaridade default do Sikuli</p>
     * 
     * @param imgPath Caminho da imagem a ser buscada
     * @return Objeto Pattern
     */
    public static Pattern convertImagePathToPattern(String imgPath) {
        return convertImagePathToPattern(imgPath, Settings.MinSimilarity);
    }
    
    /**
     * <p>Metodo que cria uma lista de Object (para ser utilizada nos metodos do
     * Sikuli que buscam varias imagens ao mesmo tempo) a partir de uma lista com caminhos de imagem
     * utilizando uma similaridade customizada</p>
     * 
     * @param imgPaths Lista com os caminhos de imagem
     * @param similarity Double variando entre 0 a 1 que indica a similaridade para o match da imagem
     * @return Lista de Object com Objetos Pattern
     */
    public static List<Object> convertImagesToPatternObjects(
            List<String> imgPaths, double similarity) {
        
        return imgPaths.stream()
                .map(imgPath -> convertImagePathToPattern(imgPath, similarity))
                .collect(Collectors.toList());
    }
    
    /**
     * <p>Overload do metodo convertImagesToPatternObjects utilizando a similaridade 
     * default do Sikuli</p>
     * 
     * @param imgPaths Lista com os caminhos de imagem
     * @return Lista de Object com Objetos Pattern
     */
    public static List<Object> convertImagesToPatternObjects(
            List<String> imgPaths) {
        
        return convertImagesToPatternObjects(imgPaths, Settings.MinSimilarity);
    }
    
}
