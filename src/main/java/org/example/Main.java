package org.example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public  class Main{
    public  static void generateQRCode(String data , String path , String charset, Map map , int h , int w )throws WriterException , IOException{
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        MatrixToImageWriter.writeToFile(matrix,path.substring(path.lastIndexOf('.') + 1), new File(path));

    }
    public static void main(String args[]) throws WriterException, IOException, NotFoundException{
        String str= "THE HABIT OF PERSISTENCE IS THE HABIT OF VICTORY.";
        String path = "C:\\Users\\Mike_pn\\Desktop\\y1program\\javascript\\qrcode.png";
        String charset = "UTF-8";
        Map <EncodeHintType , ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType , ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);

        generateQRCode(str , path , charset ,hashMap , 200 , 200);
        System.out.println("QR code created successfully");
    }
}