package org.academiadecodigo.bootcamp22.helloworldmaven;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;

public class main {

    public static void main(String[] args) {

        GUIScreen guiScreen = TerminalFacade.createGUIScreen();
        guiScreen.getScreen().startScreen();

        Window window = new Window("Hello carálhe");
        guiScreen.showWindow(window);

        guiScreen.getScreen().stopScreen();
    }
}
