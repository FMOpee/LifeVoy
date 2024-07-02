# LifeVoy
## Subtitle
An web service based backend server for a twitter-esque dummy software. 
## Features
1. New user can open a new account.
2. Old user can login.
3. User can post a post.
4. User can like a post.
5. User can dislike a post.
6. User can comment under a post.
7. User can reply under a comment.
8. User can see an individual post that will show the post and the comments and replies under it.
9. User can follow other users
10. User can unfollow other users
11. User can see a home feed that would show all the posts that have been made buy users they follow.
12. User can see a profile for any users where all the posts that user made along with their follower and following count will be shown
13. User can see who a user follows.
14. User can see who follows a user.
15. Each Post, Comment, Reply will be checked for strikable parts. If it contains that, user will receive a strike and the post/comment/reply will not be posted. after a certain number of strike, a user will be permanently banned from posting, commenting or replying.
16. Send Messages to other users
17. See previous messages with a user chronologically
18. See a list of all the conversation with the last message of each conversation. 
## Services
* **User**: Entity
* **Post**: Entity
* **Comment** : Entity
* **GenerateFeed** : Service
* **GenerateProfile** : Service
* **OnePost** : Service
* **StrikeChecker** : Utility
* **Messaging**: Entity
## Mapping Features to Operations and Interdependencies
The mentioned features are implemented through the following relationship between the services
![diagram](LifeVoy-Page-3.jpg)
## Principles
#### User
The User Service is running in the 8081 port, whose wsdl file is available at: http://localhost:8081/ws/user.wsdl 
SoapUI Configuration File: [User Configuration](/SoapUI%20Configurations/LifeVoy-v2-User-soapui-project.xml) 


This service 
* has a standardized Service Contract in form of this wsdl file
* have reasonably loose coupling
* is reusable 
* is autonomous (doesnt have any dependencey)
* is stateless (each call is its own thing)
Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### Post
The Post Service is running in the 8082 port, whose wsdl file is available at: http://localhost:8082/ws/post.wsdl
SoapUI Configuration File: [Post Configuration](/SoapUI%20Configurations//Lifevoy-v2-Post-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is reusable 
* is autonomous (doesnt have any dependencey other than the utility service)
* is stateless (each call is its own thing)
The service was too central for it to have loose coupling. Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### Comment
The Comment Service is running in the 8083 port, whose wsdl file is available at: http://localhost:8083/ws/comment.wsdl
SoapUI Configuration File: [Comment Configuration](/SoapUI%20Configurations/Lifevoy-v2-Comment-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is reusable 
* have reasonably loose coupling
* is autonomous (doesnt have any dependencey other than the utility service)
* is stateless (each call is its own thing)
Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### Messaging
The Messaging Service is running in the 9000 port, whose wsdl file is available at: http://localhost:9000/ws/messaging.wsdl
SoapUI Configuration File: [Messaging Configuration](/SoapUI%20Configurations/LifeVoy-V2-Messaging-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is reusable 
* is completely decoupled
* is autonomous (doesnt have any dependencey at all)
* is stateless (each call is its own thing)
Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### Generate Feed
The GenerateFeed Service is running in the 8084 port, whose wsdl file is available at: http://localhost:8084/ws/feed.wsdl
SoapUI Configuration File: [Generate Feed Configuration](/SoapUI%20Configurations/Lifevoy-v2-Feed-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is stateless (each call is its own thing)
It isnt reusable due to being a task service and specific for a task. This is dependent on 2 entity services making it more coupled and less autonomous. Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### Generate Profile
The GenerateProfile Service is running in the 8085 port, whose wsdl file is available at: http://localhost:8085/ws/profile.wsdl
SoapUI Configuration File: [Profile Configuration](/SoapUI%20Configurations/LifeVoy-v2-Profile-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is stateless (each call is its own thing)
It isnt reusable due to being a task service and specific for a task. This is dependent on 2 entity services making it more coupled and less autonomous. Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### OnePost
The OnePost Service is running in the 8086 port, whose wsdl file is available at: http://localhost:8086/ws/onepost.wsdl
SoapUI Configuration File: [One Post Configuration](/SoapUI%20Configurations/LifeVoy-v2-OnePost-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is stateless (each call is its own thing)
It isnt reusable due to being a task service and specific for a task. This is dependent on 2 entity services making it more coupled and less autonomous. Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.

#### Strike Checker
The StrikeCheck Service is running in the 8087 port, whose wsdl file is available at: http://localhost:8087/ws/strikecheck.wsdl
SoapUI Configuration File: [Strike Checker Configuration](/SoapUI%20Configurations/LifeVoy-v2-StrikeCheck-soapui-project.xml) 

This service 
* has a standardized Service Contract in form of this wsdl file
* is reusable 
* is completely decoupled
* is autonomous (doesnt have any dependencey at all)
* is stateless (each call is its own thing)
Abstraction wasnt possible due to the project being too simplistic in nature. Discoverability was out of scope. composability wasnt implemented due to time constrains.



