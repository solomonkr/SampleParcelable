package kr.iuu.sampleparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by 8a296581 on 2017-05-31.
 */

public class SimpleData implements Parcelable{

    int number;
    String message;

    public SimpleData(int num, String msg){
        this.number = num;
        this.message = msg;
    }

    public SimpleData(Parcel src){
        this.number = src.readInt();
        this.message = src.readString();
    }

    public int getNumber(){
        return this.number;
    }

    public String getMessage(){
        return this.message;
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
