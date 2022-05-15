package edu.kiet.protodatastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

class ColorSerializer : Serializer<ColorInfo> {
    override val defaultValue: ColorInfo= ColorInfo.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): ColorInfo {
        try {
            return ColorInfo.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: ColorInfo,
        output: OutputStream
    ) = t.writeTo(output)
}

