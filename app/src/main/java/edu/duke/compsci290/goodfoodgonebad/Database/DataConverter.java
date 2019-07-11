package edu.duke.compsci290.goodfoodgonebad.Database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by nazligungor on 29.04.2018.
 */

public class DataConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
