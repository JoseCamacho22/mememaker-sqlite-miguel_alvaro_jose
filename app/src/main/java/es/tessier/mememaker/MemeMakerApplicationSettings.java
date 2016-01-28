package es.tessier.mememaker;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import es.tessier.mememaker.utils.StorageType;

/**
 * Created by Carlos Tessier on 30/12/14.
 */
public class MemeMakerApplicationSettings {

    SharedPreferences mSharedPreferences;
    final static String KEY_STORAGE = "Storage";

    public MemeMakerApplicationSettings(Context context) {

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    }

    public String getStoragePreference(){

        return mSharedPreferences.getString(KEY_STORAGE, StorageType.INTERNAL);
    }

    public void setSharedPreference(String storageType){

        mSharedPreferences
                .edit()
                .putString(KEY_STORAGE,StorageType.INTERNAL)
                .apply();

    }
}
