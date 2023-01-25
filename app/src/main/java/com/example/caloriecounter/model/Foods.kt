package com.example.caloriecounter.model

import  androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity()
data class Foods(
    @ColumnInfo(name = "besinIsimleri")
    @SerializedName("name")
    val besinIsimleri : String?,

    @ColumnInfo(name = "kalori")
    @SerializedName("Kalori")
    val kaloriMiktari : Int?,)

{

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0}
