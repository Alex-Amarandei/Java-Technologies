Create a JSF application for managing the submission of documents into a repository.

The application will allow the following:
  - An authentication mechanism based on username and password
  - Register new users and assign them a specific role
  - The possibility to upload a document (for authors) and to view all uploaded documents (for admin) and each uploaded document will have a uniquely generated registration number
  
Use Contexts and Dependency Injection (CDI) for:
  - the management of application's beans (@Inject) and transactions (@Transactional)
  - decoupling the components using dependency injection
  - decoupling orthogonal concerns
  - decoupling bussines concerns
  - implementing at least one event-based comunication
  - data validation, using Bean Validation annotations
