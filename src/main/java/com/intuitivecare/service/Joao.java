package com.intuitivecare.service;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import com.intuitivecare.sikuli.SikuliApp;
import com.intuitivecare.sikuli.SikuliImage;
import com.intuitivecare.sikuli.SikuliMouse;

public class Joao {
    public static void main(String[] args) throws FindFailed {
        String site = "https://www.gov.br/ans/pt-br/assuntos/consumidor/o-que-o-seu-plano-de-saude-deve-cobrir-1/o-que-e-o-rol-de-procedimentos-e-evento-em-saude";
        SikuliApp.openApp(site);

        Screen cursor = new Screen();
        
        while (SikuliImage.checkImage("C:\\Repos\\IntuitiveCare\\primeiro-teste\\resources\\anexo.png") == false){
            cursor.wheel(1,9);
        }
        SikuliMouse.click("C:\\Repos\\IntuitiveCare\\primeiro-teste\\resources\\anexo.png");


        //SikuliMouse.click("C:\\Users\\joaov\\Pictures\\anexoiv.png");
//        SikuliMouse.click("C:\\Users\\joaov\\Pictures\\botaodownload.png");
    }
}