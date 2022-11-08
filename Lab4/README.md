# Lab 4

## Table of Contents

1. [Compulsory](#compulsory)
2. [Homework](#homework)
3. [Bonus](#bonus)
4. [Notable Contributions](#notable-contributions)

## Compulsory

**Task:** _Implement an efficient way for obtaining connections to the database._

- _Configure a connection pool and a JDBC resource using an administrative tool (such as GlassFish/Payara Console or asadmin)._

- _Create DataSource objects using either JNDI directly or resource injection._

**Solution:**

- The JDBC Connection Pool and the JDBC Resource were created from the admin console of Payara on [localhost:4848](localhost:4848)

- The database credentials (_username, password, port number, database name_) were introduced using the console at the moment of creating the Connection Pool

<br>

## Homework

**Task:** _Create the pages using templates:_

- _`page.xhtml`: describing the general aspect of the application pages: header, content, footer. The header should display the title and might include a menu bar._

- _The footer will display a copyright notice and the current version of the aplication. The header, footer and the menu bar should all be in separate `.xhtml` files._

- _`dataView.xhtml`: a generic page for displaying data as a list, dataTable, etc._

- _`dataEdit.xhtml`: a generic page for editing data. This could be a dialog containing a generic form._

**Solution:**

- Each of the requested pages is separate and has its own file

- The header includes a menu bar used for navigating between the three views (namely: _home, edit, tournament_)

- The footer includes the copyright notice, version and author

- `dataView.xhtml`: shows the teams as a table

- `dataEdit.xhtml`: allows the user to add a new team to the table by using a form inside a dialog

- `tournament.xhtml`: allows the user to see the matches of the tournament

<br>

## Bonus

**Task:** _Create a composite component that describes a datatable with support for CRUD operations. Rewrite the pages for managing the teams and the cities in order to use the composite component._

**Solution:** Handled as required.

<br>

## Notable Contributions

- Aesthetically-Pleasing Front-End using CSS
- Provided Screenshots

- Very Clear Readme.md
- Adherence to Java Naming Conventions
- Documented using Javadocs
- Javadoc Site Can Be Found at `target/site/index.html`
