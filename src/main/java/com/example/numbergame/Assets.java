package com.example.numbergame;

import javafx.scene.image.Image;

public final class Assets {

private Assets() {

}

    public static final Image NEW_ICON =
            new Image(Assets.class.getResourceAsStream("/images/new.png"));

    public static final Image EXIT_ICON =
            new Image(Assets.class.getResourceAsStream("/images/exit.png"));

    public static final Image GUESS_ICON =
            new Image(Assets.class.getResourceAsStream("/images/guess.png"));


}//end class

