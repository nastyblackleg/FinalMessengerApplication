package com.example.admin.firebaseapplication.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class User(val uid: String, val username: String, val profileImageURL: String): Parcelable {
    constructor() : this("","","")
}