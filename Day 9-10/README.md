> **Important – first-time login:**  
> Although the app seeds H2 with sample *books*, **no pre-hashed users are created.**  
> **Register a new user via `POST /register` and then log in with that same username + password** to obtain your JWT.  
> Attempting to log in with the hard-coded data.sql accounts will fail, because their passwords are not stored in BCrypt format.
