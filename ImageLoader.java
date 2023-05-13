package com.example.original;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {
    public static ImageView imageView = new ImageView("https://images.unsplash.com/photo-1495195134817-aeb325a55b65?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y3V0dGluZyUyMGJvYXJkfGVufDB8fDB8fA%3D%3D&w=1000&q=80");
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
    public static ImageView getImageView() {
        return imageView;
    }
    public  Image getImage() {
        return images[randomIndex];
    }
    public int calcRandomIndex(){
        randomIndex= (int)(Math.random() * images.length);
        return randomIndex;
    }
}
