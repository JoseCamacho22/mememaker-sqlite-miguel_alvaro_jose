package es.tessier.mememaker;

import android.preference.PreferenceManager;

import es.tessier.mememaker.utils.FileUtilities;

/**
 * Created by Carlos Tessier on 30/12/14.
 */
public class MemeMakerApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FileUtilities.saveAssetImage(this, "Funny_Face.jpg");
        FileUtilities.saveAssetImage(this, "Troll-face-Okay.jpg");
        FileUtilities.saveAssetImage(this, "Troll_meme.png");
        FileUtilities.saveAssetImage(this, "julio.png");

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

    }
}
