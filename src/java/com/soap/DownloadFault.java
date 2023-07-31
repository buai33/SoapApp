/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soap;

import javax.xml.ws.WebFault;

/**
 *
 * @author xwliu
 */
@WebFault(name="DownloadFault", targetNamespace="http://soap.com/")

public class DownloadFault extends Exception{
    
    public DownloadFault (String message) {
        super(message);
    }
    
    public DownloadFault (String message, Throwable cause) {
        super(message, cause);
    }
    
}
