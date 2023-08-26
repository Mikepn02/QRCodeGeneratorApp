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
        // It's necessary to encode the data as bytes because the ZXing library requires byte data for generating QR codes. the charset argument is converting data back to string
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);
        //this is to determine file extension to be generated either png or jpg
        MatrixToImageWriter.writeToFile(matrix,path.substring(path.lastIndexOf('.') + 1), new File(path));

    }
    public static void main(String args[]) throws WriterException, IOException, NotFoundException{
        String str= "Hey Bro!!! Thank you for coming to us.";
        String path = "C:\\Users\\Mike_pn\\IdeaProjects\\QRCodeGenerator\\qrcodes.png";
        String charset = "UTF-8";
        Map <EncodeHintType , ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType , ErrorCorrectionLevel>();
        hashMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
        //The EncodeHintType allows you to provide hints to the QR code generator about how to handle certain aspects of encoding

        generateQRCode(str , path , charset ,hashMap , 200 , 200);
        System.out.println("QR code created successfully");
    }
}