package com.weavebytes.debugtool;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Class for static methods and variables to debug the app
 */
public class Config {

    public static  String DEBUG_TOAST_STRING = " ";

    public static String DEBUG_LOG_STRING = " ";
    public static  ArrayList<String> ERROR_LIST =new ArrayList<>();
    public static void showToast(Context context){

        Toast.makeText(context, DEBUG_TOAST_STRING, Toast.LENGTH_SHORT).show();

    }
    public static void showLog(String tag){

        Log.d(tag,DEBUG_LOG_STRING);
    }

}//Config
