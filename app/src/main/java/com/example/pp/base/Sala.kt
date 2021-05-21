package com.example.pp.base

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "contact_table")
data class Sala(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val password: String
): Parcelable