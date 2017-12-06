package com.example.jaredboese.travelplan;

import android.content.Context;

/**
 * Created by Jared Boese on 12/4/2017.
 */

public class Model implements AutoCloseable {
    public static class Lazy extends com.example.jaredboese.travelplan.Lazy < Model > {
        Lazy(Context context) {
            super(Model.class, context);
        }
    }

    Context mContext;
    Model(Context context) {
        mContext = context;
        mPrefs = new Prefs.Lazy(mContext);
    }

    Context context() { return mContext; }
    Prefs.Lazy mPrefs;
    Prefs prefs() { return mPrefs.self(); }



    @Override
    public void close() {
        mPrefs.close();
    }
}