package com.example.original;

import javafx.scene.image.Image;

public class ImageLoader {

    int randomIndex;
    private static final String[] IMAGE_URLS = {
            "https://i.imgur.com/dZTkRDM.png",
            "https://i.imgur.com/9y39dN8.png",
            "https://i.imgur.com/8J8qFLL.png",
            "https://i.imgur.com/MuxYWIg.png",
            "https://i.imgur.com/arE79xp.png",
            "https://i.imgur.com/MSZQQxx.png",
            "https://i.imgur.com/5Vobi3I.png",
            "https://i.imgur.com/EpLxZbB.png",
            "https://i.imgur.com/BWIux5Y.png",
            "https://i.imgur.com/CUAkAj4.png"
    };
    private static Image[] images= new Image[IMAGE_URLS.length];;

    public ImageLoader() {
        for (int i = 0; i < IMAGE_URLS.length; i++) {
            images[i] = new Image(IMAGE_URLS[i]);
        }
    }

    public  Image getImage() {
        return images[randomIndex];
    }
    public int calcRandomIndex(){
        randomIndex= (int)(Math.random() * images.length);
        return randomIndex;
    }
}
