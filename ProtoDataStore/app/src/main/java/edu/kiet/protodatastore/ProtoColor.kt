package edu.kiet.protodatastore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

class ProtoColor(val context: Context) {
    val Context.settingsDataStore: DataStore<ColorInfo> by dataStore(
        fileName = "settings.pb",
        serializer = ColorSerializer()
    )
    val getColorInfo: Flow<ColorInfo> = context.settingsDataStore.data.catch {
        exception->
        if (exception is IOException)
        {
            Log.d("ColorInfo",exception.message.toString())
            ColorInfo.getDefaultInstance()
        } else {
            throw exception
        }
    }

    suspend fun ColorUpdate(red:Int, green:Int, blue:Int) {
        context.settingsDataStore.updateData { colorInfo ->
            colorInfo.toBuilder()
                .setRed(red)
                .setGreen(green)
                .setBlue(blue)
                .build()
        }
    }
}