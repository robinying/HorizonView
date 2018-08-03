package com.yubin.horizonview.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yubin.horizonview.bean.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * author : Yubin.Ying
 * time : 2018/8/2
 */
public class DataUtil {
    public static List<Product> getData (Context context) {
        try {
            InputStream in = context.getResources().getAssets().open("data.json");
            String res = convertStreamToString(context);
            Gson gson = new Gson();
            List<Product> list = gson.fromJson(res, new TypeToken<ArrayList<Product>>(){}.getType());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String convertStreamToString(Context context) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */

        StringBuilder sb = new StringBuilder();

        String line = null;
        InputStream in = null;
        try {
            in= context.getResources().getAssets().open("data.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }
}
