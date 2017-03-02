package com.example.yuhui.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yuhui on 17-2-26.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{

        @SerializedName("txt")
        public String info;
    }
}
