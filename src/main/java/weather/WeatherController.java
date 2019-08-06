package weather;

import models.WeatherModel;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherController {

    public  String getWeather (String message, WeatherModel model ){
        String key ="7e546c04e5ffd491d962b086b0de8727";
        URL url=null;
        Scanner sc = null;
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+message+"&units=metric&appid="+key);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            assert url != null;
            sc = new Scanner((InputStream) url.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result ="";
        assert sc != null;
        while(sc.hasNext()){
            result+=sc.nextLine();
        }


        JSONObject object = new JSONObject(result);
        model.setName(object.getString("name"));

        JSONObject main = object.getJSONObject("main");
        model.setTemp(main.getDouble("temp"));
        model.setHumidity(main.getDouble("humidity"));

        JSONArray getArray = object.getJSONArray("weather");
        for(int i=0; i<getArray.length(); i++){
            JSONObject obj = getArray.getJSONObject(i);
            model.setIcon((String) obj.get("icon"));
            model.setMain((String) obj.get("main"));
        }

        return "City "+model.getName()+ "\n"+
                "Temperature: "+model.getTemp() +" C"+ "\n"+
                "Humidity "+ model.getHumidity() +"%"+ "\n"+
                "Main "+model.getMain()+"\n"+
                "http://openweathermap.org/img/w/"+model.getIcon()+".png";
    }
}
