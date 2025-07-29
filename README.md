# Code written in Java simulating a Zoo's Operation

## Table of contents
- [Function of the code](#a-function-code-that-immitates-a-ticket-machine-in-a-metro-system-done-in-the-context-of-a-university-project)
- [Commit Rules](#rules-to-follow-before-a-commit)
- [Branches](#rules-for-branches)
- [Requirements](#requirements)
- [Setup](#how-to-setup-the-tools)
- [User Manual](#how-to-use-the-code)
- [Video Demo](#video-demonstration-of-the-repository)


## A console base game that simulates the operation of a Zoo in the real world

Game written in Java to simulate the funtioning of a Zoo in the real world, allows you to for example add animals and instalations to 
the Zoo and simulate what will happen in a year. Simulates the food and cage costs of an animal, the money it brings to the zoo based
on its own characteristics as well as if the the animal will die based on its age or have a baby.
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

TODO  


## Notas
Notas sobre o projeto:

Classes Reader e ficheiros de texto:
  Existem dois casos, para os casos em que cada objeto se encontra em linhas distintas, para cada linha lida pela classe reader são utilizados tokens com o delimitador (-) para separar os atributos dos objetos. No caso do Zoo, onde possui varios arrays que podem ser inicializados, é utilizado um sistema onde o primeiro token de cada linha serve de indicador para qual dos arrays essa informação se destina.

  Ficheiros de texto CaracEspecies, e CaracIndividuais seguem a formatação:
    Nome da Caracteristica - Valor;

  Ficheiro Nome artistico segue a formatação:
    Nome

  Ficheiro Especie segue a formatação:
    Nome - Esperança de Vida - atratividadeBase - custoRacao - probNascimento - nº caracteristicas da especie - index das caracteristicas de especie

  Ficheiro Zoo segue a formatação:
    Para o id(ini):
      Saldo Contabilistico - Probabilidade de fugir

    Para o id(tdani):
    Nome - idade - index da especie - nº caracteristicas individuais - id's das caracteristicas

    Para o id(inst):
    Lotação maxima - Custo Trabalhadores - Custo Limpeza - Nº Animais - Id dos animais


Classes Auxiliares:
  Existem classes auxiliares, Static que funcionam como auxiliares para realizar várias funções uteis a outras classes no programa sem ser necessário que se instancie um objeto desta classe. São as classes AuxRand e ComplexMath.

  AuxRand:
    Existe para calcular e auxiliar nas partes do programa ditadas que necessitam que se crie/obtenha resultados ou objetos aleatorios para outras partes do programa. Exemplo de getRandomEspecie(), que retorna uma especie ao calhas do ArrayList que possui todas as especies.

  ComplexMath:
    Existe para calcular com funções mais complexas, se um animal deve morrer, nascer entre outros.  


Classes Principais:
  Sãos as classes mais importantes do nosso programa.

  Animal:
    Composto por nome, idade, e um array de caracteristicas individuais unico para tal animal (mutação). Possuir várias funções que por exemplo, permitem calcular a atritividade baseada na informção possível.

  Especie: 
    Composto por nome da especie, esperança media de vida, atratividadeBase, custoRacaobase, probNascimento, e um array de caracteristicas de especie;

  Instação:
    Composto por custoTrabalhadores, custoLimpeza, custoTrabalhadoresInicial, custoLimpezaInicial();

  Nome Artistico:
    Apenas o nome;

  Zoo:
    Composto por saldoContabilistico, probFugir assim como varios arrays como um para guardar todos os animais, todos os animais sem instação, instações e o obituario de todos os animais do zoo;


Para os menus, existem duas classes abstratas:
  A primeira menuBase, serve como base para todos os menus que existem e possui vários metodos uteis;
  A segunda opcaosMenu, serve como base para todas as opcoes de menu e possuir vários metodos uteis;

  Menu inicial serve para escolher se queremos digitar os objetos ou le-los de um ficheiro;
  Menu AdqAnimalCarc serve para adquirir um animal com certas caracteristicas/mutações;
  Menu digitarDados é um menu que nos permite criar os objetos com aprovação do PR;

  Cada menu tera o seu metodo showMenu() que mostra o menu. E para algumas pessoas é dado a um cacifo;
