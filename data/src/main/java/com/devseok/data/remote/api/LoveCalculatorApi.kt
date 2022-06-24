package com.devseok.data.remote.api

import com.devseok.data.remote.model.DataLoveResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * @author Ha Jin Seok
 * @email seok270@gmail.com
 * @created 2022-06-16
 * @desc
 */
interface LoveCalculatorApi {
    @GET("/getPercentage")
    suspend fun getPercentage(
        @Header("X-RapidAPI-Key") key : String,
        @Header("X-RapidAPI-Host") host : String,
        @Query("fname") fName : String,
        @Query("sname") sName : String
    ) : Response<DataLoveResponse>

}