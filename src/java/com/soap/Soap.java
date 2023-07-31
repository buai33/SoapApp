/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author xwliu
 */

@WebService
public class Soap {
    
    
    
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
}
