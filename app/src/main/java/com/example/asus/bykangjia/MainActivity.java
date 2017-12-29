package com.example.asus.bykangjia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.bykangjia.base.BaseActivity;
import com.example.asus.bykangjia.base.BaseMVPactivity;
import com.example.asus.bykangjia.model.Imodel;
import com.example.asus.bykangjia.model.Model;
import com.example.asus.bykangjia.persenter.ByPensenter;
import com.example.asus.bykangjia.view.Iview;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends BaseMVPactivity<ByPensenter,Model> implements Iview.Iv{


    private PublicKey publicKey;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void ShowView() {
        Log.d("riz","show");
    }

    @Override
    public void DestView() {
        Log.d("riz","dest");
    }

    @Override
    public void Data(String s) {
        String val = "";
        Random random = new Random();

        for (int i = 0; i < 16; i++) {
            String i1 = random.nextInt(2) % 2 == 0 ? "char" : "num";

            if (i1.equals("char")) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;

                val += (char) (random.nextInt(26) + temp);


            } else if (i1.equals("num")) {
                val += String.valueOf(random.nextInt(10));

            }

        }

        Log.d("val", val);
        final String RSA_PUBLICE = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVGd/g8HD6e/L7+AKYP/RW/7aQz0YVlQ4xrQGnEbMoH5j0BcKhGiw+NbnCMFs6allgwegbGbKqcH+5ooOotgwqY2vAln0PCDExpVjtaxVSeLZchDSM3U40Qx3NeLlGTtiARFU3U2IGgun9EVA79LlvVpqvsl7z/tGtFMP+TWkR3wIDAQAB";
        final String ALGORITHM = "RSA";


        // 利用Base64 对 编码进行解密 获得 公钥
        byte[] decode = Base64.decode(RSA_PUBLICE, Base64.DEFAULT);


        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decode);

        try {
            //KeyFactory 密钥工厂  可以使用 DSAPublicKeySpec 或 X509EncodedKeySpec 指定 DSA 公钥。密钥工厂可用于兼容密钥规范之间的转换。
            KeyFactory rsa = KeyFactory.getInstance(ALGORITHM);

            //http://jszx-jxpt.cuit.edu.cn/JavaAPI/java/security/class-use/PublicKey.html
            //KeyFactory.generatePublic(KeySpec keySpec) 根据所提供的密钥规范（密钥材料）生成公钥对象。
            //拿到公钥
            publicKey = rsa.generatePublic(x509EncodedKeySpec);

            Log.d("sssss", publicKey.toString());
//
        } catch (Exception e) {
            e.printStackTrace();
        }


        //** 使用公钥进行加密‘
        //Cipher 是一个加密类
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");


            //初始化加密模式
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            //    String kk = String.valueOf(val);
            byte plaintext[] = val.getBytes("UTF-8");  //  随机数

            byte[] bytes1 = cipher.doFinal(plaintext);  //方法用来对数据进行加mi


            String s2 = new String(Base64.encode(bytes1, Base64.DEFAULT));

            Log.d("woshinibab", s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
//


//
//        //   Log.d("ssss",""+val);
//;
//

        //   Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void inject() {
        mvpComment().Inject(this);
    }
}
