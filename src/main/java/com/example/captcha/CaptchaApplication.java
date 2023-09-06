package com.example.captcha;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.StraightLineNoiseProducer;
import cn.apiclub.captcha.text.producer.NumbersAnswerProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class CaptchaApplication {

    //Captcha class object
//    public static Captcha createCaptcha(int width, int height) {
//        Captcha cap = new Captcha.Builder(width,height)
//                .addBackground(new GradiatedBackgroundProducer())
//                .addText(new NumbersAnswerProducer())
//                .addNoise(new StraightLineNoiseProducer())
//                .build();
//        return cap;
//    }

    //convert into image
//    public static void createImage(Captcha captcha) {
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(captcha.getImage(),"png",os);
//            FileOutputStream fos = new FileOutputStream("D:/captcha/mycp.png");
//            fos.write(os.toByteArray());
//            fos.flush();
//            fos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }

    public static void main(String[] args) {
        SpringApplication.run(CaptchaApplication.class, args);
//        Captcha captcha = createCaptcha(200,80);
//        createImage(captcha);
//        System.out.println("DONE");
    }

}
