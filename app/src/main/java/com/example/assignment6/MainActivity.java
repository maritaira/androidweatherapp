package com.example.assignment6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.w3c.dom.Text;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ArrayList<TextView> hours = new ArrayList<TextView>();
    ArrayList<ImageView> hourlyWeather = new ArrayList<ImageView>();
    ArrayList<TextView> hourlyTemps = new ArrayList<TextView>();
    ArrayList<TextView> days = new ArrayList<TextView>();
    ArrayList<ImageView> dailyWeather = new ArrayList<ImageView>();
    ArrayList<TextView> highs = new ArrayList<TextView>();
    ArrayList<TextView> lows = new ArrayList<TextView>();
    ArrayList<TextView> precipitation = new ArrayList<TextView>();
    JSONArray time;
    JSONArray temp;
    JSONArray high;
    JSONArray low;
    JSONArray weather;
    JSONArray prec;
    JSONArray dailyprec;
    JSONArray dailyweather;
    JSONArray humidity;
    JSONArray dewpoint;
    Integer day;
    Integer hour;

    enum DayofWeek {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView currentTemp = findViewById(R.id.currentTemp);
        TextView high = findViewById(R.id.dayHigh);
        TextView low = findViewById(R.id.dayLow);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        String date = sdf.format(new Date());
        hour = Integer.valueOf(date.substring(17,19));
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        day = cal.get(Calendar.DAY_OF_WEEK);


        buildHourlyArrays();
        buildDailyArrays();

        setHours();
        setDays();
        volleyRequest("30.28", "-97.76");


//        testButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Hey!!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void buildHourlyArrays() {
        TextView hour1 = findViewById(R.id.hourly1);
        hours.add(hour1);
        TextView hour2 = findViewById(R.id.hourly2);
        hours.add(hour2);
        TextView hour3 = findViewById(R.id.hourly3);
        hours.add(hour3);
        TextView hour4 = findViewById(R.id.hourly4);
        hours.add(hour4);
        TextView hour5 = findViewById(R.id.hourly5);
        hours.add(hour5);
        TextView hour6 = findViewById(R.id.hourly6);
        hours.add(hour6);
        TextView hour7 = findViewById(R.id.hourly7);
        hours.add(hour7);
        TextView hour8 = findViewById(R.id.hourly8);
        hours.add(hour8);
        TextView hour9 = findViewById(R.id.hourly9);
        hours.add(hour9);
        TextView hour10 = findViewById(R.id.hourly10);
        hours.add(hour10);
        TextView hour11 = findViewById(R.id.hourly11);
        hours.add(hour11);
        TextView hour12 = findViewById(R.id.hourly12);
        hours.add(hour12);
        TextView hour13 = findViewById(R.id.hourly13);
        hours.add(hour13);
        TextView hour14 = findViewById(R.id.hourly14);
        hours.add(hour14);
        TextView hour15 = findViewById(R.id.hourly15);
        hours.add(hour15);
        TextView hour16 = findViewById(R.id.hourly16);
        hours.add(hour16);
        TextView hour17 = findViewById(R.id.hourly17);
        hours.add(hour17);
        TextView hour18 = findViewById(R.id.hourly18);
        hours.add(hour18);
        TextView hour19 = findViewById(R.id.hourly19);
        hours.add(hour19);
        TextView hour20 = findViewById(R.id.hourly20);
        hours.add(hour20);
        TextView hour21 = findViewById(R.id.hourly21);
        hours.add(hour21);
        TextView hour22 = findViewById(R.id.hourly22);
        hours.add(hour22);
        TextView hour23 = findViewById(R.id.hourly23);
        hours.add(hour23);


        ImageView hw0 = findViewById(R.id.imageView0);
        hourlyWeather.add(hw0);
        ImageView hw1 = findViewById(R.id.imageView1);
        hourlyWeather.add(hw1);
        ImageView hw2 = findViewById(R.id.imageView2);
        hourlyWeather.add(hw2);
        ImageView hw3 = findViewById(R.id.imageView3);
        hourlyWeather.add(hw3);
        ImageView hw4 = findViewById(R.id.imageView4);
        hourlyWeather.add(hw4);
        ImageView hw5 = findViewById(R.id.imageView5);
        hourlyWeather.add(hw5);
        ImageView hw6 = findViewById(R.id.imageView6);
        hourlyWeather.add(hw6);
        ImageView hw7 = findViewById(R.id.imageView7);
        hourlyWeather.add(hw7);
        ImageView hw8 = findViewById(R.id.imageView8);
        hourlyWeather.add(hw8);
        ImageView hw9 = findViewById(R.id.imageView9);
        hourlyWeather.add(hw9);
        ImageView hw10 = findViewById(R.id.imageView10);
        hourlyWeather.add(hw10);
        ImageView hw11 = findViewById(R.id.imageView11);
        hourlyWeather.add(hw11);
        ImageView hw12 = findViewById(R.id.imageView12);
        hourlyWeather.add(hw12);
        ImageView hw13 = findViewById(R.id.imageView13);
        hourlyWeather.add(hw13);
        ImageView hw14 = findViewById(R.id.imageView14);
        hourlyWeather.add(hw14);
        ImageView hw15 = findViewById(R.id.imageView15);
        hourlyWeather.add(hw15);
        ImageView hw16 = findViewById(R.id.imageView16);
        hourlyWeather.add(hw16);
        ImageView hw17 = findViewById(R.id.imageView17);
        hourlyWeather.add(hw17);
        ImageView hw18 = findViewById(R.id.imageView18);
        hourlyWeather.add(hw18);
        ImageView hw19 = findViewById(R.id.imageView19);
        hourlyWeather.add(hw19);
        ImageView hw20 = findViewById(R.id.imageView20);
        hourlyWeather.add(hw20);
        ImageView hw21 = findViewById(R.id.imageView21);
        hourlyWeather.add(hw21);
        ImageView hw22 = findViewById(R.id.imageView22);
        hourlyWeather.add(hw22);
        ImageView hw23 = findViewById(R.id.imageView23);
        hourlyWeather.add(hw23);

        TextView hourtemp0 = findViewById(R.id.hrTemp0);
        hourlyTemps.add(hourtemp0);
        TextView hourtemp1 = findViewById(R.id.hrTemp1);
        hourlyTemps.add(hourtemp1);
        TextView hourtemp2 = findViewById(R.id.hrTemp2);
        hourlyTemps.add(hourtemp2);
        TextView hourtemp3 = findViewById(R.id.hrTemp3);
        hourlyTemps.add(hourtemp3);
        TextView hourtemp4 = findViewById(R.id.hrTemp4);
        hourlyTemps.add(hourtemp4);
        TextView hourtemp5 = findViewById(R.id.hrTemp5);
        hourlyTemps.add(hourtemp5);
        TextView hourtemp6 = findViewById(R.id.hrTemp6);
        hourlyTemps.add(hourtemp6);
        TextView hourtemp7 = findViewById(R.id.hrTemp7);
        hourlyTemps.add(hourtemp7);
        TextView hourtemp8 = findViewById(R.id.hrTemp8);
        hourlyTemps.add(hourtemp8);
        TextView hourtemp9 = findViewById(R.id.hrTemp9);
        hourlyTemps.add(hourtemp9);
        TextView hourtemp10 = findViewById(R.id.hrTemp10);
        hourlyTemps.add(hourtemp10);
        TextView hourtemp11 = findViewById(R.id.hrTemp11);
        hourlyTemps.add(hourtemp11);
        TextView hourtemp12 = findViewById(R.id.hrTemp12);
        hourlyTemps.add(hourtemp12);
        TextView hourtemp13 = findViewById(R.id.hrTemp13);
        hourlyTemps.add(hourtemp13);
        TextView hourtemp14 = findViewById(R.id.hrTemp14);
        hourlyTemps.add(hourtemp14);
        TextView hourtemp15 = findViewById(R.id.hrTemp15);
        hourlyTemps.add(hourtemp15);
        TextView hourtemp16 = findViewById(R.id.hrTemp16);
        hourlyTemps.add(hourtemp16);
        TextView hourtemp17 = findViewById(R.id.hrTemp17);
        hourlyTemps.add(hourtemp17);
        TextView hourtemp18 = findViewById(R.id.hrTemp18);
        hourlyTemps.add(hourtemp18);
        TextView hourtemp19 = findViewById(R.id.hrTemp19);
        hourlyTemps.add(hourtemp19);
        TextView hourtemp20 = findViewById(R.id.hrTemp20);
        hourlyTemps.add(hourtemp20);
        TextView hourtemp21 = findViewById(R.id.hrTemp21);
        hourlyTemps.add(hourtemp21);
        TextView hourtemp22 = findViewById(R.id.hrTemp22);
        hourlyTemps.add(hourtemp22);
        TextView hourtemp23 = findViewById(R.id.hrTemp23);
        hourlyTemps.add(hourtemp23);
    }

    public void buildDailyArrays() {
        TextView day1 = findViewById(R.id.day1);
        days.add(day1);
        TextView day2 = findViewById(R.id.day2);
        days.add(day2);
        TextView day3 = findViewById(R.id.day3);
        days.add(day3);
        TextView day4 = findViewById(R.id.day4);
        days.add(day4);
        TextView day5 = findViewById(R.id.day5);
        days.add(day5);
        TextView day6 = findViewById(R.id.day6);
        days.add(day6);

        TextView prec0 = findViewById(R.id.prec0);
        precipitation.add(prec0);
        TextView prec1 = findViewById(R.id.prec1);
        precipitation.add(prec1);
        TextView prec2 = findViewById(R.id.prec2);
        precipitation.add(prec2);
        TextView prec3 = findViewById(R.id.prec3);
        precipitation.add(prec3);
        TextView prec4 = findViewById(R.id.prec4);
        precipitation.add(prec4);
        TextView prec5 = findViewById(R.id.prec5);
        precipitation.add(prec5);
        TextView prec6 = findViewById(R.id.prec6);
        precipitation.add(prec6);

        ImageView dayImage0 = findViewById(R.id.dayImage0);
        dailyWeather.add(dayImage0);
        ImageView dayImage1 = findViewById(R.id.dayImage1);
        dailyWeather.add(dayImage1);
        ImageView dayImage2 = findViewById(R.id.dayImage2);
        dailyWeather.add(dayImage2);
        ImageView dayImage3 = findViewById(R.id.dayImage3);
        dailyWeather.add(dayImage3);
        ImageView dayImage4 = findViewById(R.id.dayImage4);
        dailyWeather.add(dayImage4);
        ImageView dayImage5 = findViewById(R.id.dayImage5);
        dailyWeather.add(dayImage5);
        ImageView dayImage6 = findViewById(R.id.dayImage6);
        dailyWeather.add(dayImage6);

        TextView dayHigh0 = findViewById(R.id.dayHigh0);
        highs.add(dayHigh0);
        TextView dayHigh1 = findViewById(R.id.dayHigh1);
        highs.add(dayHigh1);
        TextView dayHigh2 = findViewById(R.id.dayHigh2);
        highs.add(dayHigh2);
        TextView dayHigh3 = findViewById(R.id.dayHigh3);
        highs.add(dayHigh3);
        TextView dayHigh4 = findViewById(R.id.dayHigh4);
        highs.add(dayHigh4);
        TextView dayHigh5 = findViewById(R.id.dayHigh5);
        highs.add(dayHigh5);
        TextView dayHigh6 = findViewById(R.id.dayHigh6);
        highs.add(dayHigh6);

        TextView dayLow0 = findViewById(R.id.dayLow0);
        lows.add(dayLow0);
        TextView dayLow1 = findViewById(R.id.dayLow1);
        lows.add(dayLow1);
        TextView dayLow2 = findViewById(R.id.dayLow2);
        lows.add(dayLow2);
        TextView dayLow3 = findViewById(R.id.dayLow3);
        lows.add(dayLow3);
        TextView dayLow4 = findViewById(R.id.dayLow4);
        lows.add(dayLow4);
        TextView dayLow5 = findViewById(R.id.dayLow5);
        lows.add(dayLow5);
        TextView dayLow6 = findViewById(R.id.dayLow6);
        lows.add(dayLow6);
    }


    public void setHours() {
        Integer n = hour + 1;
        String s;
        for (int i = 0; i < hours.size(); i++) {
            TextView hr = hours.get(i);
            if (n < 10) {
                s = "0" + n.toString();
                hr.setText(s);
            } else if (n == 24) {
                n = 0;
                s = "00";
                hr.setText(s);
            } else {
                s = n.toString();
                hr.setText(s);
            }
            n++;
        }
    }

    public void setDays() {
        Integer n = day;
        String s;
        for (int i = 0; i < days.size(); i++) {
            TextView d = days.get(i);
            if (n > 6) {
                n = 0;
            }
            s = DayofWeek.values()[n].toString();
            d.setText(s);
            n++;
        }
    }

    public void okButtonTap(View view){
        EditText lat = (EditText) findViewById(R.id.editTextLat);
        EditText lon = (EditText) findViewById(R.id.editTextLong);
        volleyRequest(lat.getText().toString(), lon.getText().toString());
    }

    private void volleyRequest(String lat, String lon){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,precipitation,rain,weathercode&daily=weathercode,temperature_2m_max,temperature_2m_min,precipitation_sum&temperature_unit=fahrenheit&windspeed_unit=mph&precipitation_unit=inch&timezone=America%2FChicago";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject reader = new JSONObject(response);
                    JSONObject hourly = reader.getJSONObject("hourly");
                    time = hourly.getJSONArray("time");
                    temp = hourly.getJSONArray("temperature_2m");
                    weather = hourly.getJSONArray("weathercode");
                    humidity = hourly.getJSONArray("relativehumidity_2m");
                    dewpoint = hourly.getJSONArray("dewpoint_2m");
                    prec = hourly.getJSONArray("precipitation");
                    JSONObject daily = reader.getJSONObject("daily");
                    high = daily.getJSONArray("temperature_2m_max");
                    low = daily.getJSONArray("temperature_2m_min");
                    dailyprec = daily.getJSONArray("precipitation_sum");
                    dailyweather = daily.getJSONArray("weathercode");

                    String currTemp = Integer.toString((int) temp.getDouble(hour)) + "°";
                    TextView currentTemp = (TextView) findViewById(R.id.currentTemp);
                    currentTemp.setText(currTemp);

                    String currHigh = "H: " + Integer.toString((int) high.getDouble(0)) + "°";
                    TextView currentHigh = (TextView) findViewById(R.id.dayHigh);
                    currentHigh.setText(currHigh);

                    String currLow = "L: " + Integer.toString((int) low.getDouble(0)) + "°";
                    TextView currentLow = (TextView) findViewById(R.id.dayLow);
                    currentLow.setText(currLow);

                    ImageView currentWeather = findViewById(R.id.mainImageView);
                    if (weather.getInt(hour) <= 1) {
                        if (hour > 7 && hour < 18) {
                            currentWeather.setImageResource(R.drawable.ic_baseline_wb_sunny_64);
                        } else {
                            currentWeather.setImageResource(R.drawable.ic_baseline_moon_128);
                        }
                    } else if (weather.getInt(hour) >= 2 && weather.getInt(hour) <= 48) {
                        currentWeather.setImageResource(R.drawable.ic_baseline_wb_cloudy_128);
                    } else {
                        currentWeather.setImageResource(R.drawable.ic_baseline_thunderstorm_128);          //// CHANGE THIS TO STORM
                    }

                    for (int i = 0; i < hourlyTemps.size(); i++) {
                        TextView temps = hourlyTemps.get(i);
                        String s = Integer.toString((int) temp.getDouble(hour + i)) + "°";
                        temps.setText(s);
                    }

                    for (int i = 0; i < hourlyWeather.size(); i++) {
                        ImageView conditions = hourlyWeather.get(i);
                        int n = hour;
                        if (n + i > 23) {
                            n -= 24;
                        }
                        if (weather.getInt(hour+i) <= 1) {
                            if (n+i > 7 && n+i < 18) {
                                conditions.setImageResource(R.drawable.ic_baseline_yel_sunny_24);
                            } else {
                                conditions.setImageResource(R.drawable.ic_baseline_moon_24);
                            }
                        } else if (weather.getInt(hour+i) >= 2 && weather.getInt(hour+i) <= 48) {
                            conditions.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
                        } else {
                            conditions.setImageResource(R.drawable.ic_baseline_thunderstorm_24);
                        }
                    }

                    for (int i = 0; i < precipitation.size(); i++) {
                        TextView p = precipitation.get(i);
                        String s = Double.toString(dailyprec.getDouble(i)) + '"';
                        p.setText(s);
                    }

                    for (int i = 0; i < dailyWeather.size(); i++) {
                        ImageView w = dailyWeather.get(i);
                        if (dailyweather.getInt(i) <= 1) {
                            w.setImageResource(R.drawable.ic_baseline_yel_sunny_24);
                        } else if (dailyweather.getInt(i) >= 2 && dailyweather.getInt(i) <= 48) {
                            w.setImageResource(R.drawable.ic_baseline_wb_cloudy_24);
                        } else {
                            w.setImageResource(R.drawable.ic_baseline_thunderstorm_24);
                        }
                    }

                    for (int i = 0; i < highs.size(); i++) {
                        TextView h = highs.get(i);
                        String s = Integer.toString((int) high.getDouble(i)) + "°";
                        h.setText(s);
                    }

                    for (int i = 0; i < lows.size(); i++) {
                        TextView h = lows.get(i);
                        String s = Integer.toString((int) low.getDouble(i)) + "°";
                        h.setText(s);
                    }

                    TextView t = findViewById(R.id.currentHumidity);
                    String hum = Integer.toString(humidity.getInt(hour)) + "%";
                    t.setText(hum);
                    t = findViewById(R.id.currentDewPoint);
                    String dp = "Dew point: " + Integer.toString((int) dewpoint.getDouble(hour)) + '°';
                    t.setText(dp);
                    t = findViewById(R.id.precipitationSum);
                    String ps = Double.toString(prec.getDouble(hour)) + '"';
                    t.setText(ps);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }
}