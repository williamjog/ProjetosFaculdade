Exercício Jogo da velha

Jogo da Velha

O objetivo deste exercício é desenvolver um Jogo da Velha. No seu jogo, você deve representar o tabuleiro através de um array bidimensional de caracteres.
Para isso, você deve criar (no mínimo) as seguintes classes:

Classe JogoDaVelha: classe que recebe o tabuleiro do jogo como atributo.
No construtor da classe, receba por parâmetro um valor inteiro referente às dimensões do tabuleiro. Por exemplo, se o inteiro recebido for 3, o tabuleiro terá dimensões 3x3; caso o valor recebido seja 7, o tabuleiro terá dimensões 7x7, e assim sucessivamente. Com este valor recebido, inicialize o tabuleiro. Lembrando que o tamanho padrão de um tabuleiro é 3x3. Crie um construtor padrão, que inicializa o tabuleiro com esse tamanho, caso nenhum parâmetro seja informado.

Crie o método realizaJogada, que recebe dois inteiros (referentes a uma linha e uma coluna do tabuleiro) e um caractere, referente a jogada a ser realizada ('X' ou 'O'). Este método retorna verdadeiro ou falso, e simplesmente coloca no tabuleiro a jogada realizada. Caso já tenha uma jogada na posição indicada, o método retorna falso, indicando que a jogada não pode ser realizada. Caso a jogada seja realizada corretamente, o método retorna verdadeiro.

Crie um método chamado verificaGanhador, que retorna um valor booleano. Este método analisa o tabuleiro e retorna verdadeiro caso o jogo tenha um vencedor, e falso caso contrário. O jogo tem um vencedor caso as duas diagonais (principal e secundária) estejam preenchidas com o mesmo caractere ('X' ou 'O'), ou quando alguma linha estiver preenchida com o mesmo caractere ('X' ou 'O'), ou ainda quando alguma coluna estiver preenchida com o mesmo caractere ('X' ou 'O').

Na classe JogoDaVelha, faça o método toString, que retorna uma String que refere-se ao estado atual do tabuleiro.



Classe Jogador: possui um nome e uma quantidade de pontos.

No construtor de jogador, receba parâmetros para inicializar o nome dos atributos, e inicialize os pontos em zero;
Crie os métodos de acesso (getters e setters);
Crie o toString;


Principal: é a classe que possui o main. No main, faça o que se pede:

Crie dois jogadores, com nomes solicitados pelo teclado

Crie um objeto do tipo JogoDaVelha com um tamanho de tabuleiro informado pelo usuário via teclado

Desenvolva, utilizando os métodos criados nas classes JogoDaVelha e Jogador, a lógica do jogo da velha. Os jogadores devem indicar qual posição (linha e coluna) querem jogar. O primeiro jogador joga com o 'X', enquanto o segundo com a 'O'

Ao final de cada jogo, você deve aumentar a pontuação do jogador vencedor e perguntar se eles desejam jogar novamente. Quando os jogadores não quiserem mais jogar, imprima na tela as informações do jogador vencedor