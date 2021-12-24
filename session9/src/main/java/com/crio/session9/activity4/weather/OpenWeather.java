package com.crio.session9.activity4.weather;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;



// Class that wraps functionality to connect to the openweathermap API and get data back.


public class OpenWeather implements WeatherApi {

    private RestTemplate restTemplate;

  public OpenWeather(){
  
  }
  public OpenWeather(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  private String buildWeatherUrl(Double lat, Double lon) {
    String appId = "7f7ff184d89d00f68c9440eb1fcf47a5";
    return "https://api.openweathermap.org/data/2.5/forecast"
        + "?lat=" + lat.toString() + "&lon=" + lon.toString() + "&appid=" + appId;
  }

  private boolean forecastRainFromWeatherReport(JsonNode root, LocalDateTime tripStartDay,
    LocalDateTime tripEndDay) throws IOException {
    JsonNode list = root.path("list");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    boolean goingToRain = false;
    if (list.isArray()) {
      for (final JsonNode node : list) {
        JsonNode allWeather = node.path("weather");

        if (allWeather.isArray()) {
          for (final JsonNode weatherInfo : allWeather) {

            LocalDateTime startTimeOfWeatherInfo = LocalDateTime
                .parse(node.path("dt_txt").asText(), dateTimeFormatter);

            LocalDateTime endTimeOfWeatherInfo = startTimeOfWeatherInfo.plusMinutes(179);

            boolean condition1 = startTimeOfWeatherInfo.isAfter(tripStartDay)
                && startTimeOfWeatherInfo.isBefore(tripEndDay);
            boolean condition2 = tripStartDay.isAfter(startTimeOfWeatherInfo)
                && tripEndDay.isBefore(endTimeOfWeatherInfo);

            if (condition1 || condition2) {
              if (weatherInfo.path("description").asText().contains("rain")) {
                goingToRain = true;
              }
            }
          }
        }
      }
    }

    return goingToRain;
  }

  @Override
  public boolean rainForecastAt(Double lat, Double lon,
      LocalDateTime tripStartsAt, LocalDateTime tripEndsAt) {

    String weatherUrl = buildWeatherUrl(lat, lon);
    System.out.println(weatherUrl);
    ResponseEntity<String> response = restTemplate.getForEntity(weatherUrl, String.class);

    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(response.getBody());

      boolean rainExpected = forecastRainFromWeatherReport(root, tripStartsAt, tripEndsAt);

      return rainExpected;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
@Override
public Double maxTemperature(Double lat, Double lon, LocalDateTime tripStartsAt, LocalDateTime tripEndsAt) {
    // TODO Auto-generated method stub
    return null;
}

}