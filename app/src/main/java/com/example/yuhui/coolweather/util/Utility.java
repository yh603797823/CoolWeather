package com.example.yuhui.coolweather.util;

import android.text.TextUtils;

import com.example.yuhui.coolweather.db.City;
import com.example.yuhui.coolweather.db.County;
import com.example.yuhui.coolweather.db.Province;
import com.example.yuhui.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuhui on 17-2-24.
 */

public class Utility {


    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {

            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    String name = provinceObject.getString("name");
                    int code = provinceObject.getInt("id");
                    province.setProvinceCode(code);
                    province.setProvinceName(name);
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response, int provinceId) {
        if (TextUtils.isEmpty(response)) {
            return false;
        }
        try {
            JSONArray allCities = new JSONArray(response);
            for (int i = 0; i < allCities.length(); i++) {
                JSONObject cityObject = allCities.getJSONObject(i);
                City city = new City();
                String name = cityObject.getString("name");
                int code = cityObject.getInt("id");
                city.setCityName(name);
                city.setCityCode(code);
                city.setProvinceId(provinceId);
                city.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean handleCountyResponse(String response, int cityId) {
        if (TextUtils.isEmpty(response)) {
            return false;
        }
        try {
            JSONArray allCounties = new JSONArray(response);
            for (int i = 0; i < allCounties.length(); i++) {
                JSONObject cityObject = allCounties.getJSONObject(i);
                County county = new County();
                String name = cityObject.getString("name");
                String weatherId = cityObject.getString("weather_id");
                county.setCountyName(name);
                county.setWetherId(weatherId);
                county.setCityId(cityId);
                county.save();
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
