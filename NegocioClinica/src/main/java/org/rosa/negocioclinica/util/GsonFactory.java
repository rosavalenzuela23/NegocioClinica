/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rosa.negocioclinica.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author natsu
 */
public class GsonFactory {

    public static Gson createInstance() {
        var gsonBuilder = new GsonBuilder();
        //ISOFormat
        gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss.sssZ");
        
        return gsonBuilder.create();
    }
    
}
