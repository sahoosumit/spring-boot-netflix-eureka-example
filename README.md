### Spring Boot Netflix Eureka Demo

Simple demo of service registration and discovery using Netflix Eureka.

Initial work based on this guide:

https://spring.io/guides/gs/service-registration-and-discovery/

### Try it out

#### Eureka Discovery Server

Start the server

```
cd eureka-discovery-server
build :   ./gradlew build -t
run :   ./gradlew bootRun 
```

Visit the Netflix Eureka dashboard at http://localhost:8761

Note that there are no 'Instances' yet registered


#### Eureka Test Server

Start up a Test Server

```
cd test-server
build :   ./gradlew build -t
run :   ./gradlew bootRun
```

Visit the client directly at http://localhost:8090/service-instances

```

The `/instances` endpoint will take up to a minute to update, but should eventually
show all the instances of `eureka-client` that have been registered with the
Eureka Discovery Client.

```
You can also visit the Netflix Eureka dashoboard again now and see it listed there.



#### Access test-server service 

Start up a Test client
```
cd test-client
build :   ./gradlew build -t
run :   ./gradlew bootRun
```

The proxy automatically maps a route based on the service names it finds in the eureka
registry and uses client side load balancing.
