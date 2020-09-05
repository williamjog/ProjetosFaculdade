Exercício 1 

Nesta semana, o IBOPE vai ouvir entre 1500 e 2000 eleitores para saber as intenções de voto. Entretanto, o instituto precisa de um método para calcular os resultados. Assim sendo, crie a classe Candidato, que possui um nome, um partido e um inteiro que representa a quantidade de intenções de voto obtidas na pesquisa. Depois disto, crie uma classe chamada IBOPE. Nesta classe, crie um método chamado candidatoMaisBemColocado, que recebe um array unidimensional de Candidato e retorna o candidato (objeto do tipo Candidato) que está melhor colocado na pesquisa. Atente para o seguinte:

o método candidatoMaisBemColocado deve ser recursivo.

Naturalmente, você deve criar a classe Candidato.

No método recursivo, caso o array seja nulo, você deve lançar uma exceção do tipo ArrayNotPossibleException, que deve ser criada por você

Exercício 2 

Crie uma classe chamada PrincipalIBOPE. Nesta classe, crie o método main. No main, considere entre 1 e 1000 candidatos (com informações vindas através de sorteios no código) e simule uma pesquisa de intenção de voto (também com valores aleatórios). No seu array de Candidato, sempre devem ser inseridos dois candidatos: um que representa os votos em branco (nome e partido Branco) e um que representa os indecisos (nome e partido Indeciso). Imprima todas as informações da pesquisa (ou seja, os candidatos e as intenções de voto de cada um deles) e, ao final, imprima as informações do candidato mais bem colocado na pesquisa simulada.
