package is.hi.hbv2.tvwatch;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by valdi on 3.2.16.
 */
interface JSONFetching
{
    void didFetch(JSONArray jsonArray);
}
public class JSONTask extends AsyncTask<String,String,String>
{
    private JSONFetching updater;
    public JSONTask(JSONFetching callbackImplementer)
    {
        this.updater = callbackImplementer;
    }
    @Override
    protected String doInBackground(String... params)
    {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try
        {
            Log.d("Running","1");
            URL url = new URL(params[0]);
            System.out.println("URL: "+url.toString());
            Log.d("Running","2");
            connection = (HttpURLConnection) url.openConnection();
            Log.d("Running","1");
            connection.connect();
            Log.d("Running","1");
            InputStream stream = connection.getInputStream();
            Log.d("Running","1");
            reader = new BufferedReader(new InputStreamReader(stream));
            Log.d("Running","1");
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line);
            }
            Log.d("Running","1");

            System.out.println("JSONString = "+buffer.toString());
            String finalJSON = buffer.toString();

            JSONObject parent = new JSONObject(finalJSON);

            JSONArray resArray = null;
            if (parent != null)
            {
                resArray = parent.getJSONArray("results");
            }
            if (resArray == null)
            {
                System.out.print("Warning! jsonArray = nil");
            }
            Log.d("Running","1");

            this.updater.didFetch(resArray);


        }
        catch (MalformedURLException e)
        {
            Log.d("Failed", "1");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            Log.d("Failed","2");
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            System.out.println("JSON format exception: \n"+ e.getMessage());
            System.out.println("Stack Trace:\n");
            e.printStackTrace();

        }
        finally
        {
            try
            {
                if (connection != null)
                {
                    connection.disconnect();
                }
                if (reader != null)
                {
                    reader.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result)
    {
        //TODO: Parse JSON
        System.out.println(result);


    }
}
