package com.example.dongja94.samplesharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by dongja94 on 2016-02-11.
 */
public class PropertyManager {
    private static PropertyManager instance;
    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private static final String FIELD_USER_ID = "userid";
    private static final String FIELD_PASSWORD = "password";

    private PropertyManager() {
        Context context = MyApplication.getContext();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();
    }

    public void setUserId(String userid) {
        mEditor.putString(FIELD_USER_ID, userid);
        mEditor.commit();
    }

    public String getUserId() {
        return mPrefs.getString(FIELD_USER_ID,"");
    }

    public void setPassword(String password) {
        mEditor.putString(FIELD_PASSWORD, password);
        mEditor.commit();
    }

    public String getPassword() {
        return mPrefs.getString(FIELD_PASSWORD, "");
    }


}
