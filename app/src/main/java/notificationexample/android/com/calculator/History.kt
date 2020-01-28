package notificationexample.android.com.calculator

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import kotlinx.android.parcel.Parcelize


data class History (
    var input:ArrayList<String> = ArrayList(),
    var output:ArrayList<String> = ArrayList()

)
@Parcelize
data class Student(
    val name: String = "Anupam",
    val age: Int = 24
) : Parcelable
