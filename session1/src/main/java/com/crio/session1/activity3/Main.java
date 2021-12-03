package com.crio.session1.activity3;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.File;
import java.io.IOException;

class Main {

  public void parseJsonJacksomatically(File inputFile, File outputFile) throws JsonParseException, JsonMappingException, IOException {
   // Initialize ObjectMapper
   // De-Serialize and print the POJOs
   // Serialize the POJOs to outputFile 
  }



  public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    Main main = new Main();

    // Input JSON files to be deserialized
    File trades = new File("src/main/java/com/crio/session1/activity3/trades.json");

    // POJO to be serialized to Output File
    File outputFile = new File("src/main/java/com/crio/session1/activity3/readOutput.json");

    main.parseJsonJacksomatically(trades, outputFile);


    System.out.println("Running completed");
  }
}

