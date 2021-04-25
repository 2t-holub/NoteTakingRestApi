# NoteTakingRestApi
REST API, which works with users and their notes. The program implements the roles of administrator and regular user. In general, you can create a note, edit and delete it, view your notes.


The following list of technologies was used in the project: Spring Core, Spring Boot, Spring Data, Spring MVC, Spring Security, Maven, Lombok, MySQL.


User can:

- Get user list

- View profile of any user

- View list of own notes

- Get full information about any own note

- Post new note

- Update and delete notes


Additional admin features:

- View notes of all users

- Edit and delete notes of all users

- Delete user and all his notes


Different access is performed through the implementation of roles and permissions. 
Each role has a specific set of permissions. When calling a method, the user's role and the authorship of the note are checked.


You can also view the version without implementing the roles and using Spring Security. 
The usual REST API, notes are recorded in the database. To do this, go to the branch 'simpleRestWithDB'.
