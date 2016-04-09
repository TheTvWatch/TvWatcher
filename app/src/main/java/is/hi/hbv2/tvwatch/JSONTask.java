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

    public int count;
    private String tvStation = "";
    private JSONFetching updater;
    public JSONTask(JSONFetching callbackImplementer, int count)
    {
        this.count = count;
        this.updater = callbackImplementer;
    }


    private JSONArray concatArray(JSONArray... arrs)
            throws JSONException {
        JSONArray result = new JSONArray();
        for (JSONArray arr : arrs) {
            for (int i = 0; i < arr.length(); i++) {
                result.put(arr.get(i));
            }
        }
        return result;
    }

    @Override
    protected JSONArray doInBackground(String... params)
    {
        JSONArray finalArr = null;
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        InputStream stream = null;

        int i = 0;
        try {
            while (i<count) {
                URL url = new URL(params[i]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                String temp = params[i];
                i++;
                String[] seperated = temp.split("/");
                tvStation = seperated[seperated.length - 1];

                stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String finalJSON = buffer.toString();

                JSONObject parent = new JSONObject(finalJSON);

                JSONArray resArray = null;

                resArray = parent.getJSONArray("results");
                if (finalArr == null) {
                    finalArr = resArray;
                } else {
                    JSONArray tmp = concatArray(finalArr, resArray);
                }
            }
            return finalArr;
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
