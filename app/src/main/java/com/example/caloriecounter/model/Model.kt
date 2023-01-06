package com.example.caloriecounter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity()
data class Foods(
    @ColumnInfo(name = "name")
    @SerializedName("meyve")
    val besinIsimleri : String?,

    @ColumnInfo(name = "kalori")
    @SerializedName("Kalori")
    val kaloriMiktari : Int?,

    @ColumnInfo(name = "sebze")
    @SerializedName("sebze")
    val sebzeCesitleri : String?,

    @ColumnInfo(name = "hayvansal")
    @SerializedName("hayvansal")
    val hayvansalBesinler : String?,

    @ColumnInfo(name = "yaglar")
    @SerializedName("yaglar")
    val yagCesitleri : String? ) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0}
