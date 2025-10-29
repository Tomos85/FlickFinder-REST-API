# COM1008 - Software Engineering

# Assignment 1 - Report

**Student Name: Tomos Kelleher**

**Student ID: 6868308**

## 1.1 Proto Personas

### Persona 1

 **Chloe Smith - Film and Tv Student**

Chloe is 20 years old and is in her third year of her Film & TV degree at the University of Surrey. She grew up traveling between her home in London and film sets across Europe—her father, acclaimed director Johnny Smith, shoots dramas and documentaries. From a young age she accompanied him on set, learning about shot composition, actor direction, and how to direct a well‑told story. 

Now Chloe's main focus is on her  final‑year project which is  about modern documentary techniques, and wishes to use FlickFinder to aid her project by carrying out tasks such as researching directors’ complete filmographies, comparing visual styles, and building hand picked watchlists for inspiration.


### Persona 2

**George Roberts - Marketing Manager and Parent to two young children**

George is 44 years old and lives in reading where he works his busy 9-5 marketing job 5 days a week. George and his wife live a very busy and stressfull lifestyle having to balance their work and family life which is why its so important that the free time george does get with the kids is spent as effectivley as possible and browsing streaming sites for hours on end isnt what George wants to be doing on his Friday evening family movie nights.

George wishes to use the Flickfinder service to efficently find suitable and enjoyable movies that he and his family can watch either throughout the week or on their Friday Movie nights.

## 1.2 Scenario

**Chloes Research Essay**

Chloe has a very important piece of work which goes towards 70% of her module which she has to complete short time frame where she has to write a 500-word essay on movies featuring Leonardo DiCaprio  and compare his roles—but there is no way she will get it ready on time. She opens FlickFinder on her computer and enters “Leonardo DiCaprio” into the actor search field. FlickFinder instantly lists all films Leonardo DiCaprio has acted in, with every title, year of release, average rating, and his character's name.

To restrict her search, Chloe clicks on "Sort by Rating (high to low)" and uses a limit on five results. The first five movies come up: Inception as Dom Cobb, The Wolf of Wall Street as Jordan Belfort, Titanic  as Jack Dawson, The Revenant as Hugh Glass, and Catch Me If You Can as Frank Abagnale Jr. She bookmarks all movies to her Watchlist.

Then Chloe opens each movie's detail page separately. For Inception, she reads through the summary  and highlights how DiCaprio's character struggles with reality and memory; for Titanic, she examines Jack Dawson's emotional journey. FlickFinder presents this information in a concise, unvarying format, so Chloe is able to rapidly transfer key performance points to her  essay.

Within a much quicker time frame than her previous essays , Chloe finishes her research with FlickFinder secure in the knowledge that she has all the character insights she is looking for. She is now able to write her essay immediately saving  precious time and eliminating desperate manual searches and browsing on multiple sites.

## 1.3 User Stories

### User Story 1

**Display Recently Viewed Films**

As a logged in user,I want to be able to see my 5 most recently viewed films on my dashboard so that i can quickly pick up from when i left off.

### User Story 2

**Add Films to Watch List**

As a logged in user and busy parent, I want to be able to add films to a watch list so that I can watch them at a later date with my children.

### User Story 3

**Search Based of Actor**

As a guest viewer, I want to be able to search for films by actor so that I can view all the films that the specific actor is in.

### User Story 4

**Sort by Rating**

As a casual user, I want to be able to sort the films by their rating from high to low so that I can quickly see the highest rated films.

### User Story 5

**Search for Films by Title**

As a user, I want to be able to search for a film by it's title so I can quickly find the film im looking for.

### User Story 6

**Sort Films by Release Date**

As a student researching the evolution of films, I want to be able to sort the films by their release date so I can see how films have evolved over the years.

## 2 Critical Analysis and Reflection

### 2.1 Reflection
For my project I had to create a backend web service for a movie search service called Flick Finder which made use of a large database. Throughout my project I used Java, Javelin, and SQLite. The main aim was to produce an API that can fulfil users search requests whether that be searching for a film actor or a director. This would be done by making use of the large database we had been provided with. I used the MVC pattern for structuring the application, with database access, business logic, and handling of requests being clearly distinguished. Over the weeks given to complete the project, I was able to complete the Must-Have and Should-Have features which included listing all movies stored within the database, retrieving specific information on a particular film and listing people found within the database such as actors or directors.  I found that several aspects went well as well as identifying room for improvement when it came to future projects. I was able to get the basic functionality of the application to work as intended. The use of the DAO’s went well and I found it easy to develop the connection between the database and the backend. I followed the MVC pattern which resulted in good code organisation. However, there were aspects that could have been improved. Firstly, my overall time management for the project as I underestimated how long each section would take which resulted in me not being able to implement the could-have feature. More exception handling for database failures could also have been included.

### 2.2 Professional Aspects

When I was developing FlickFinder, I made sure to use the best practices of software development in order to comply with long-term maintainability, code quality and ethical standards. The MVC architecture was used in the project to enable a clean separation of logic, database operations, and routing. The use of DAOs helped to decouple SQL queries and facilitated testability and maintenance. If FlickFinder was to become a full mobile application, the system would also have to fulfil legal requirements such as compliance with the UK GDPR and Data Protection Act 2018. For example if saving accounts or favourites was a feature, the system would save user data securely, introduce consent flows, and implement privacy policies. Sustainability and efficiency would also become essential concerns. We can help make software more sustainable by reducing database calls, streamlining queries and returning minimal API responses to save power and make the app more efficient if scaled. Using Javalin and SQLite helped to make development easier by keeping server-side resource usage minimal. Accessibility and device compatibility would also need to be taken into consideration when looking at the FlickFinder application to ensure the software can meet all user needs and be compliant with legal accessibility standards.


## 3. References

Sommerville, I. (2016) *Software Engineering*. 10th ed. Harlow, England: Pearson Education.

SQLite. (2024) *SQLite Documentation*. Available at: https://www.sqlite.org/docs.html (Accessed: 2 May 2025).

Javalin. (2024) *Javalin: Lightweight Java and Kotlin Web Framework*. Available at: https://javalin.io (Accessed: 2 May 2025).

University of Surrey. (2025) *COM1028 Week 10 Lecture Slides – Sustainability in Software Engineering*. [Lecture slides].

