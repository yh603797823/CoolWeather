package com.example.yuhui.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yuhui on 17-2-26.
 */

public class Suggestion {

    @SerializedName("conf")
    public Comfort comfort;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;

    public class Comfort{

        @SerializedName("txt")
        public String info;
    }

    public class CarWash{

        @SerializedName("txt")
        public String info;
    }

    public class Sport{

        @SerializedName("txt")
        public String info;
    }
}