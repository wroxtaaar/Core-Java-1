package com.crio.session9.activity4;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.crio.session9.activity4.log.UncaughtExceptionHandler;
import com.crio.session9.activity4.weather.OpenWeather;
import com.crio.session9.activity4.weather.WeatherUnlocked;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.client.RestTemplate;


public class WeatherAdvisorApplication {

    public static void main(String[] args) {
      Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
      ThreadContext.put("runId", UUID.randomUUID().toString());
  
      List <WeatherInput> weatherInputList = new ArrayList<WeatherInput>(){
        {
          add(new WeatherInput(12.9762,77.6033,"2019-05-29 08:15","2019-05-29 09:15","v1"));
          add(new WeatherInput(13.9762,78.6033,"2019-05-29 08:15","2019-05-29 09:15","v2"));
          add(new WeatherInput(14.9762,79.6033,"2019-05-29 08:15","2019-05-29 09:15","v1"));
          add(new WeatherInput(15.9762,80.6033,"2019-05-29 08:15","2019-05-29 09:15","v2"));
          add(new WeatherInput(16.9762,81.6033,"2019-05-29 08:15","2019-05-29 09:15","v1"));
          add(new WeatherInput(17.9762,82.6033,"2019-05-29 08:15","2019-05-29 09:15","v2"));
          add(new WeatherInput(18.9762,83.6033,"2019-05-29 08:15","2019-05-29 09:15","v1"));
          add(new WeatherInput(19.9762,84.6033,"2019-05-29 08:15","2019-05-29 09:15","v2"));
          add(new WeatherInput(20.9762,85.6033,"2019-05-29 08:15","2019-05-29 09:15","v1"));
          add(new WeatherInput(21.9762,86.6033,"2019-05-29 08:15","2019-05-29 09:15","v2"));
        }
      };
  
      long startTime = System.currentTimeMillis();
      getWeatherStatusSingleThreaded(weatherInputList);
      long endTime = System.currentTimeMillis();
      long duration = endTime - startTime;
  
      System.out.println("Single Thread Duration: " + String.valueOf(duration));
  
  
      startTime = System.currentTimeMillis();
      int numberOfThreads = Runtime.getRuntime().availableProcessors(); // Should be strictly > 0
      getWeatherStatusMultithreaded(weatherInputList,numberOfThreads);
      endTime = System.currentTimeMillis();
      duration = endTime - startTime;
    
      System.out.println("Number of Threads: " + numberOfThreads + " Multi Thread Duration: " + String.valueOf(duration));
  
    }
  
    public static void getWeatherStatusMultithreaded(List<WeatherInput> weatherInputList, int numOfThreads) {
  
  
      ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
      List<Future<Boolean>> responses = weatherInputList.stream().map(weatherInput -> executorService.submit(() -> {
        WeatherAdvisor weatherAdvisor = null;
      RestTemplate restTemplate = new RestTemplate();
      if(weatherInput.getApiVersion().equals("v1")){
        weatherAdvisor = new WeatherAdvisor(new OpenWeather(restTemplate));
      } else {
        weatherAdvisor = new WeatherAdvisor(new WeatherUnlocked(restTemplate));
      }
      return weatherAdvisor.rainExpected(weatherInput.getLatitude(),weatherInput.getLongitude(),weatherInput.getTripStartsAt(), weatherInput.getTripEndsAt());
      })).collect(Collectors.toList());;
  
      responses.forEach(response -> {
        try {
          System.out.println("Multi Thread: "+ response.get());
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (ExecutionException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      });
  
      executorService.shutdown();
  }
  
    public static void getWeatherStatusSingleThreaded(List<WeatherInput> weatherInputList) {
      List<Boolean> responses = new ArrayList<>();
      WeatherAdvisor weatherAdvisor = null;
      RestTemplate restTemplate = new RestTemplate();
      for(WeatherInput weatherInput: weatherInputList){
      
        if(weatherInput.getApiVersion().equals("v1")){
          weatherAdvisor = new WeatherAdvisor(new OpenWeather(restTemplate));
        } else {
          weatherAdvisor = new WeatherAdvisor(new WeatherUnlocked(restTemplate));
        }
        responses.add(weatherAdvisor.rainExpected(weatherInput.getLatitude(),weatherInput.getLongitude(),weatherInput.getTripStartsAt(), weatherInput.getTripEndsAt()));
      }
  
      responses.forEach(response -> {
      
          System.out.println("Single Thread: "+ response);
      
      });
    }
  
  }
  
