package com.example.retrofitexample_0

import com.google.gson.annotations.SerializedName

data class MarsRealState( @SerializedName("id")
                          val id :String,
                          @SerializedName("price")
                          // cambiar a long
                          val price :String,
                          @SerializedName("type")
                          val type : String,
                          @SerializedName("img_src")
                          val imgSrc : String



)
