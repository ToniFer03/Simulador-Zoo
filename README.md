# Projeto-2-POO---G17
Notas sobre o projeto:
  Existe uma classe menu que funciona como menu principal, possui variavel menuId que servira para guardar no decorrer do programa do programa a opção escolhida pelo usuario. Existe tambem um ArrayList que serve para guardar os objetos, que a lista vai executar.
  Cada opção apresentada no menu possui então a sua propria classe, baseada na classe abstrata OpcaoMenu. Esta classe possui uma variavel chamada parentMenu, que guarda a qual menu pertence a opcao que vai ser executada (e permite voltar para esse menu apos executar). Tambem possui o metodo abstrato executarOpcao() que permitira a essa opcao realizar a ação pretendida e ainda um metodo concreto, que permite voltar ao menu principal.
