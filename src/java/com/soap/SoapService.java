/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.soap;

import com.sun.xml.ws.developer.StreamingAttachment;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.WebFault;
import javax.xml.ws.soap.MTOM;
import static sun.security.krb5.Confounder.bytes;


/**
 * @author xwliu
 */

@WebService(serviceName = "Soap")
@MTOM(enabled = true, threshold = 10)

public class SoapService {
    byte[] b;
    ByteArrayInputStream input;
    ByteArrayOutputStream output;

    @WebMethod(operationName = "upload")
    public void upload(@WebParam(name = "fileName") String fileName, @WebParam(name = "file") DataHandler file) {
        try {
        input = (ByteArrayInputStream) file.getInputStream();
        output = new ByteArrayOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }      

    }

    @WebMethod(operationName = "download")
    public @XmlMimeType("application/octet-stream")
    DataHandler download() throws IOException, DownloadFault {
        
       DataSource ds = (DataSource) new ByteArrayDataSource(input, "application/octet-stream");
       if (input.equals(null)) {
                    Throwable t= new IllegalArgumentException ("File is not available.");
                    throw new DownloadFault("There is one error", t);
                }
       DataHandler dh = new DataHandler(ds);
       return dh;
      
    }
    
    @WebMethod
    public int[] fibonacci(int length){
        int first = 0, second = 1, third;
        // I need to handle NegativeArraySizeException
        while(length < 0){
            return null;
        }
        int [] fibonacciArray = new int[length];
           
        //fibonacciArray = new int[length];
        switch (length) {
            case 0:
                return fibonacciArray;
            case 1:
                fibonacciArray[0] = first;
                return fibonacciArray;
            case 2:
                fibonacciArray[0] = first;
                fibonacciArray[1] = second;
                return fibonacciArray;
            default:
                fibonacciArray[0] = first;
                fibonacciArray[1] = second;
                for (int i = 2; i < length; ++i)
                {
                    third = first + second;
                    fibonacciArray[i] = third;
                    first = second;
                    second = third;
                }   break;
            }
        return fibonacciArray;

    }

    
//    
//        public void upload(@WebParam(name = "fileName") String fileName, @WebParam(name = "file") DataHandler file) {
//        try {
//
//        input = (ByteArrayInputStream) file.getInputStream();
//        output = new ByteArrayOutputStream();
////            miniType = file.getContentType();
////            int size = input.available();
////            b = new byte[size];
////            b = output.toByteArray();
////            int bytesRead = 0;
////            while ((bytesRead = input.read(b)) != -1) {
////                output.write(b, 0, bytesRead);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//
//    }
//    
    

//    public @XmlMimeType("application/octet-stream")
//        DataHandler download() {
////       File image = new File(pathDownload.toString());
//        try {
//            
//            
//            return new DataHandler ((DataSource) ImageIO.read(image));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//    public @XmlMimeType("application/octet-stream")
//    DataHandler download() {
//        DataSource ds = new FileDataSource(new File(pathUpload.toString()));
//        return new DataHandler(ds, miniType);
//
//     
////        return new DataHandler(new FileDataSource(new File(pathDownload.toString())), miniType);
//    }
//    public  @XmlMimeType("application/octet-stream")
//	DataHandler download() throws DownloadFault{          
//
//		DataSource ds = new FileDataSource(
//				new File(pathDownload.toString()));
//                if (ds.equals(null)) {
//                    Throwable t= new IllegalArgumentException ("File is not available.");
//                    throw new DownloadFault("There is one error", t);
//                }
//		return new DataHandler(ds);
//	}
//    @Override
//    public Image downloadImage(String imageName) {
//        File image = new File (pathDownload.toString());
//        try {
//            return ImageIO.read(image);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
}



