# Code written in Java simulating a Zoo's Operation

## Table of contents
- [Function of the code](#a-function-code-that-immitates-a-ticket-machine-in-a-metro-system-done-in-the-context-of-a-university-project)
- [Commit Rules](#rules-to-follow-before-a-commit)
- [Branches](#rules-for-branches)
- [Requirements](#requirements)
- [Setup](#how-to-setup-the-tools)
- [User Manual](#how-to-use-the-code)
- [Video Demo](#video-demonstration-of-the-repository)
- [Resume of the code](#Resume-of-the-code)


## Demo project for programming using OOP - A console base game that simulates the operation of a Zoo in the real world

Game written in Java to simulate the functioning of a Zoo in the real world, allows you to for example add animals and instalations to 
the Zoo and simulate what will happen in a year. Simulates the food and cage costs of an animal, the money it brings to the zoo based
on its own characteristics as well as if the animal will die based on its age or have a baby.
If the Zoo is badly managed and the current account of the Zoo goes negative the chances of animals escaping the Zoo increase.
Other factors such as if the animal in question is the same as the animal on the chinese new year will have an impact on the money it brings.


## Rules to follow before a commit

The commits must follow this rules:

    type [scope optional]: description

The commits must be atomic, only one objective

### Types

The available types with their respective emojis:  
🏗️build - Changes to the project build  
🔄️ci - Changes to the continuous integration cycle  
📄docs - Changes to project documentation  
🎨style - Changes related to the styling of the code  
✨feat - Changes that add new features  
🐛fix - Changes to fix errors (bugs) in the code  
🏎️perf - Changes to improve performance of the project  
🧹refactor - Refactoring of the code  
🔙revert - Reverting a previous commit  
🧮test - Changes to the unit tests of the code  
💡chore - Changes that do not alter the project code

### Scope:

The name of the component affected by the changes, example:
Compiler, readme, forms

### Description:

Brief description of the changes made, must be in english, present verb form of the imperative and without a full stop, example:
feat(validations): implement messageServer-side validations


## Rules for Branches

Must be used when implementing a new feature, working on a new release or fixing a bug in the code, when finished the development on that branch it can be merged with the main branch.
There are two types of branches always present on the repository:

    main/master
    dev/name-of-developer

There can also exist temporary branches like:

    feat/<nome-da-funcionalidade>
    bug/<descrição-do-erro>
    release/<ID da release>
    <ID do issue>/<descrição-do-issue>

The branch names must be short and explain its purpose, can't contain special characters of white spaces;


## Requirements

Java 19 and an IDE that supports Maven


##  How to use the code (With Intellij)

1. Open the project with Intellij
2. Search for MavenProject1 class inside the main folder and run it
3. Choose if you want to load the data from the files or create new data
4. Play the game 


## Video demonstration of the repository

https://youtu.be/8-a-2YvnVL8  
  

## Resume of the code
### Reader Classes and Text Files:
There are two cases:

Objects on Separate Lines:
For cases where each object is on a separate line, the Reader class reads each line and uses tokens separated by the delimiter (-) to split the object’s attributes.

Zoo File (More Complex Arrays):
For the Zoo file, which contains various arrays that can be initialized, a system is used where the first token of each line acts as an indicator for which array the information belongs to.

### Text File Formats:
CaracEspecies (Species Characteristics) and CaracIndividuais (Individual Characteristics) files follow the format:
Characteristic Name - Value;

Nome Artistico (Artistic Name) file format:
Name

Especie (Species) file format:
Name - Life Expectancy - Base Attractiveness - Base Food Cost - Birth Probability - Number of Species Characteristics - Indexes of Species Characteristics

Zoo file format:

For the id (ini):
Accounting Balance - Escape Probability

For the id (tdani):
Name - Age - Species Index - Number of Individual Characteristics - IDs of Characteristics

For the id (inst):
Max Capacity - Worker Cost - Cleaning Cost - Number of Animals - Animal IDs

### Helper Classes:
There are static helper classes that assist other parts of the program without needing to instantiate them. These include AuxRand and ComplexMath.

AuxRand:
Used for generating and assisting with random elements required by the program.
Example: getRandomEspecie() returns a random species from the ArrayList containing all species.

ComplexMath:
Used for calculating more complex logic such as whether an animal should die, be born, among others.

### Main Classes:
These are the most important classes in the program:

Animal:
Composed of name, age, and an array of unique individual characteristics (mutations).
Includes various functions, for example, to calculate attractiveness based on available information.

Especie (Species):
Composed of the species name, average life expectancy, base attractiveness, base food cost, birth probability, and an array of species characteristics.

Instalação (Enclosure/Installation):
Composed of worker cost, cleaning cost, and initial values for both.

Nome Artistico (Artistic Name):
Only contains the name.

Zoo:
Composed of the accounting balance, escape probability, and several arrays to store:  
All animals  
Animals without enclosures  
Enclosures  
The zoo’s obituary (deceased animals)  

### Menu System:
There are two abstract classes for the menus:

menuBase:
Serves as the base for all existing menus and includes many useful methods.

opcaosMenu (MenuOption):
Serves as the base for all menu options and also contains several useful methods.

Initial Menu:
Lets the user choose whether to input objects manually or read them from a file.

Menu AdqAnimalCarc:
Used to acquire an animal with certain characteristics/mutations.

Menu DigitarDados:
A menu that allows creating objects with PR (possibly "project responsible") approval.
