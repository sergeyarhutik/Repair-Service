  [![Build Status](https://travis-ci.org/sergeyarhutik/Repair-Service.svg?branch=master)](https://travis-ci.org/sergeyarhutik/Repair-Service)
  [![Coverage Status](https://coveralls.io/repos/github/sergeyarhutik/Repair-Service/badge.svg)](https://coveralls.io/github/sergeyarhutik/Repair-Service)
  
  # Repair Service Application

  Demo project for Repair Service with two entities: “Client” and “Device”, related as one to many.
    
  ## Prerequisites
    
  jdk11  
  maven 3+  
  
  ## Installing  
  > mvn clean install  
  
  ## Running the tests  
  > mvn clean test  
  
  ### Server test
  
  For server test jetty plugin can be used
  
      mvn jetty:run 
      
  Open [http://localhost:8080](http://localhost:8080/hello) 
  
  
  ## REST server
  
  Start REST app:
    
    cd rest-app
    mvn jetty:run
  
  ### Try CURL requests
  
  Get all clients:
  
    curl -v localhost:8088/clients  
   
  Create new client via REST:
   
    curl -H "Content-Type: application/json" -X POST -d '{"clientId":null,"clientName":"xyz"}' -v localhost:8088/client 