package com.example.captcha.util;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;


import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class CaptchaUtil {

    //1. Captcha class object
    public static Captcha createCaptcha(int width, int height) {
        System.out.println("START : createCaptcha : CaptchaUtil");

        Captcha cap = new Captcha.Builder(width,height)
                .addBackground(new GradiatedBackgroundProducer())
                .addText(new DefaultTextProducer())
                .addNoise(new CurvedLineNoiseProducer())
                .build();

        System.out.println("END   : createCaptcha : CaptchaUtil");
        return cap;
    }
    //2. convert to binary String
    public static String encodeBase64(Captcha captcha) {
        System.out.println("START : encodeBase 64 : CaptchaUtil");

        String imageData = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(),"png",os);
            System.out.println("Captcha Value is "+captcha.getAnswer());
            byte[] arr = Base64.getEncoder().encode(os.toByteArray()); //encoding so that os can't be read
            imageData = new String(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("END   : encodeBase 64 : CaptchaUtil");

        return imageData;
    }

    //convert into image
    public static void createImage(Captcha captcha) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            ImageIO.write(captcha.getImage(),"png",os);
            FileOutputStream fos = new FileOutputStream("D:/captcha/mycp.png");
            fos.write(os.toByteArray());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
