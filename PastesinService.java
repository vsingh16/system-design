Ref Link: https://www.youtube.com/watch?v=josjRSBqEBI
Requirment: We need to create a paste bin service, which supports below features:
1)Generate a unique url(key) for a content.
2)Return original content for a key.
3)URL will get expired after certain time.
4)User Login/ Anonymous User.
  
API Design:
1) String generateKey(Post : byte[])
2) byte[] getContent(String key) 

DB Design:
1)User Table(id, user name, created timestamp, other metadata)
2)Content Table(id, user id, S3 URL)

Iteration 1: client -> Application Server(supporting both APIS) -> DB

Iteration 2: Multiple client requests -> Load Balancer -> Application Server 1(supporting both APIS) -> DB 
                                                       -> Application Server 2(supporting both APIS) -> DB 
                                                       -> Application Server 3(supporting both APIS) -> DB 
                                                       
DBs can be partiioned by year and the further month

Unqiue Key Generation:
Approach 1: Generate key API can generate a random character, which we can check in DB if not exist return.
In case of collsion, we can again try generating next random. But with this approach generate API will take time.
  
 Approach2: We will have a separate service supporting unique key genration and retungin a unique key to genrarateKey service API. 
 This will consider current epoch timestamp(41 bits)+server id(10 bits) + counter(13 bits) using this combination, it will keep on generating keys and storing them in redis cache
 whenever a request for a new key comes, it will served from cache.
 There will be multiple  seervers where this Key generation servcie will be running.
   
 Expiry Part:  we will have a clean up service which will be a scheduled job checking records which are filling expiry condition, records will be removed from DB
 as well as in S3.
  

  
