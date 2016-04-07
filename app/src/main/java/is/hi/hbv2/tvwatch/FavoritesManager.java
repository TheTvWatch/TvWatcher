package is.hi.hbv2.tvwatch;
import android.content.SharedPreferences;
import android.content.Context;

/**
 * Created by valdi on 7.4.16.
 */
/*
NOTKUN:
//save
FavoritesManager fm = YourPreference.getInstance(context);
fm.saveJSONString(YOUR_KEY,YOUR_VALUE);

//get
String value = fm.getData(YOUR_KEY);
*/
public class FavoritesManager
{
    private static FavoritesManager manager;
    private static int objectCount;
    private SharedPreferences sharedPreferences;

    public static FavoritesManager getInstance()
    {
        if (manager == null)
        {
            manager = new FavoritesManager(MainActivity.getActivityContext());
        }
        return manager;
    }

    private FavoritesManager(Context context)
    {
        sharedPreferences = context.getSharedPreferences("CustomNamedPreference",Context.MODE_PRIVATE);
    }

    public boolean saveToFavorites(String title, String key)
    {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, title);
        return prefsEditor.commit();
    }

    public void deleteFromFavorites(String key)
    {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.remove(key);
        prefsEditor.apply();
    }

    public boolean isInFavorites(String key)
    {
        String value = sharedPreferences.getString(key, "");
        return value.equals("") == false;
    }
}
