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
 * Created by ari on 17-Mar-16.
 */
interface JSONFetching{
    void didFetch(JSONArray jsonArray, String station) throws JSONException;
}

public class JSONTask extends AsyncTask<String,String,JSONArray> {


    private String tvStation = "";
    private JSONFetching updater;
    public JSONTask(JSONFetching callbackImplementer)
    {
        this.updater = callbackImplementer;
    }
    @Override
    protected JSONArray doInBackground(String... params)
    {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        InputStream stream = null;
        try
        {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            String temp = params[0];
            String[] seperated = temp.split("/");
            tvStation = seperated[seperated.length-1];


            stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line);
            }

            String finalJSON = buffer.toString();

            JSONObject parent = new JSONObject(finalJSON);

            JSONArray resArray = null;

            resArray = parent.getJSONArray("results");



            return resArray;


        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
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
                if (stream != null){
                    stream.close();
                }
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
    protected void onPostExecute(JSONArray result)
    {
        //super.onPostExecute(result);
        //TODO: Parse JSON
        try
        {
            Log.d("JSON - onPostExecute", result.getJSONObject(0).getString("title"));
            this.updater.didFetch(result, tvStation);
        } catch (JSONException e) {

        }
    }
}
