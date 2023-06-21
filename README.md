# Simulador-Zoo
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
