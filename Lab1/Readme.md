# Lab 1

## Compulsory

**Task:** _Create a servlet that receives a word and returns an HTML page containing the letters of that word presented as an ordered list._

**Solution:** The servlet handles a POST request that has the user's given word as a parameter. The word is then broken up into characters and they are outputted as items of an ordered list. Blank spaces are ignored.

<br>

## Homework

**Task:** _Modify the servlet above such that:_

- _It receives an integer as a parameter, called size, and it returns all the permutations of length size of the given letters. If the size is 0 (default), it will return all the sequences._

- _If the servlet has access to a server-side file containing a list of acceptable words (a dictionary), it will return only the sequences forming valid words._

- _This list should be large enough; you may use aspell to generate a text file containing English words, or anything similar: WordNet, dexonline, etc._

- _The servlet invocation will be done using a simple HTML form. The servlet will return the response as an HTML page._

**Solution:** The servlet uses the same POST request as above that has the user's given word as a parameter. The substring anagrams are created and validated as follows:

- The size is validated to be a number that is between 0 and the length of the given word. Any misfit is interpreted as 0.

- The corresponding substrings are generated via backtracking.

- The dictionary retrieved via the **aspell** generated file is stored in memory in a list of pairs between the words themselves and a `Python Counter`-like object (_i.e. a hashmap mapping each character of the word with its frequency_).

- For each of the generated substrings, a `Counter` is created and matched against the existing ones in the list above. If a match is found, the corresponding word is added to the output set.

- By performing the filtering like this, there is no need to generate permutations for each of the potential words and the process is, thus, much more efficient.

- The validated words in the set are then outputted one after the other.

## Bonus

**Task:** _Invoke the service from a desktop application (Java, Python, .NET, etc.). In this case, the servlet must respond with a simple text containing the list of words, instead of an HTML page._

- _Modify the servlet so it logs all the requests and results. Write in the server log the following information about each request: the HTTP method used, the IP-address of the client, the user-agent, the client language(s) and the parameters of the request._

**Solution:** Self-Explanatory, app was built using Python 3.10.

<br>

## Notable Contributions

- Very clear Readme.md
- Adherence to Java Naming Conventions
- Documented using Javadocs
- Javadoc site can be found at `target/site/index.html`
- Efficient way of handling substring anagram validation
