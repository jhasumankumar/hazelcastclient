#    Sbring Boot Hazelcast client.

### It uses
    Hazalcast 3.7
    Spring Boot 1.4.0.RELEASE
    Java 8


This application connects to Hazelcast server cluster (one node only) on 127.0.0.1:5701 and perform all activity for map store and near cache .

#### Client configuration
      <hz:client id="client">
                <hz:group name="dev" password="password" />
                    <hz:network>
                    <hz:member>127.0.0.1:5701</hz:member>
                </hz:network>
    
            </hz:client>

### Code for server
   https://github.com/jhasumankumar/hazelcast/

# Test
Use rest client to test  - I have used  rest client to test different API's.


- POST method - http://localhost:9811/hazelcastclient/user - 
   

- GET method - http://localhost:9811/hazelcastclient/user?id={id} - Returns Content Object (from cache)
