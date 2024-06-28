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
## Services
* **User**: Entity
* **Post**: Entity
* **Comment** : Entity
* **GenerateFeed** : Service
* **GenerateProfile** : Service
* **OnePost** : Service
* **StrikeChecker** : Utility
## Mapping Features to Operations and Interdependencies
The mentioned features are implemented through the following relationship between the services
![diagram](LifeVoy-Page-3.jpg)

