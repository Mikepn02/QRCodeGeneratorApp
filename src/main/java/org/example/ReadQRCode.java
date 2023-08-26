package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class ReadQRCode {

    public  static   String readQRCode(String path , String charset , Map map) throws  FileNotFoundException, IOException , NotFoundException {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();
    }

    public  static  void main(String[] args) throws WriterException, IOException, NotFoundException {
        String path = "C:\\Users\\Mike_pn\\IdeaProjects\\QRCodeGenerator\\qrcodes.png";
        String charset = "UTF-8";
        Map<EncodeHintType , ErrorCorrectionLevel> hintMap  = new HashMap<EncodeHintType , ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION , ErrorCorrectionLevel.L);

        System.out.println("Data stored in the QR code is: \n" + readQRCode(path , charset , hintMap));



    }

}
