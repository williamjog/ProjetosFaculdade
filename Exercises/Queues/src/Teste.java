public class Teste {

	public static void main(String[] args) {
		
		// 1. Considere o trecho de c�digo abaixo, onde f � uma fila com capacidade para 5
		// elementos e que est� inicialmente vazia: 
		
				StaticQueue<Integer> f = new StaticQueue<Integer>(5);
		
				f.enqueue(1);
				f.enqueue(3);
				f.enqueue(5);
				f.enqueue(7);
				f.enqueue(9);		
				f.dequeue();
				f.dequeue();		
				f.enqueue(2);
				f.enqueue(4);		
				f.dequeue();	
				f.enqueue(3);
				System.out.println("---------Exercicio 1---------");
				System.out.println(f);
			
				// Assinale V ou F para os itens a seguir:
				
		/*			
				( Falso ) A ordem final dos elementos na fila (�ltimo println executado) � {2, 4, 3, 7, 9} A ordem � {7, 9, 2, 4, 3}
				( Verdadeiro ) N�o acontece exce��o alguma no c�digo acima
		*/
		
		/*
		      2.Implemente, em uma classe qualquer, um m�todo que recebe duas filas q1 e q2 de
				inteiros e transfere os elementos da segunda para a primeira de modo que eles fiquem
				na frente dos originais. Exemplo: supondo q1 = {1, 2, 3, 4} e q2 = {5, 6, 7, 8}, ap�s
				a chamada do m�todo devemos ter q1 = {5, 6, 7, 8, 1, 2, 3, 4} e q2 = {}. Dica: use
				uma fila auxiliar.
		*/
				System.out.println("\n---------Exercicio 2---------");
				StaticQueue<Integer> f1 = new StaticQueue<Integer>(8);
				StaticQueue<Integer> f2 = new StaticQueue<Integer>(4);
				
				f1.enqueue(1);
				f1.enqueue(2);
				f1.enqueue(3);
				f1.enqueue(4);
				
				f2.enqueue(5);
				f2.enqueue(6);
				f2.enqueue(7);
				f2.enqueue(8);

				System.out.println(f1);
				System.out.println(f2);	
				f1 = f1.prependQueue(f1, f2);
				System.out.println(f1);
				
//			  3.Implemente, em uma classe qualquer, um m�todo que remove todas as ocorr�ncias
//				de um determinado elemento em uma fila de caracteres. Considere a assinatura a
//				seguir: 
				System.out.println("\n---------Exercicio 3---------");
				
				StaticQueue<Character> f3 = new StaticQueue<Character>(16);
				f3.enqueue('G');
				f3.enqueue('R');
				f3.enqueue('�');
				f3.enqueue('F');
				f3.enqueue('M');
				f3.enqueue('I');
				f3.enqueue('O');
				f3.enqueue('F');
				System.out.println(f3);
				f3 = f3.exterminateFromQueue(f3, 'F');
				System.out.println(f3);
				
				
//			 4.Implemente o m�todo contains, definido abaixo, que informa se a fila cont�m
//			   determinado elemento. 
				System.out.println("\n---------Exercicio 4---------");
				System.out.println(f3.contains('G')); // CONTEM
				System.out.println(f3.contains('F')); // NAO CONTEM
				
				
//			 5.Implemente um m�todo que inverte a ordem dos elementos da fila. 
				System.out.println("\n---------Exercicio 5---------");
				System.out.println(f3);
				f3.flip();
				System.out.println(f3);
				
				
//			  6.Implemente uma sobrecarga do m�todo enqueue que recebe como par�metro uma
//				fila, em vez de um elemento. Esse m�todo deve adicionar ao final da fila corrente os
//				elementos da fila passada como par�metro, mantendo a ordem original. 
				System.out.println("\n---------Exercicio 6---------");
				f3.flip();
				System.out.println(f3);
				StaticQueue<Character> f4 = new StaticQueue<Character>(6);
				f4.enqueue('>');
				f4.enqueue('I');
				f4.enqueue('N');
				f4.enqueue('T');
				f4.enqueue('E');
				f4.enqueue('R');
				f3.enqueue(f4);
				System.out.println(f3);
				
//			  7.Implemente o m�todo abaixo, que insere um elemento na primeira posi��o da fila. 
				System.out.println("\n---------Exercicio 7---------");
				System.out.println(f3);
				f3.enqueueWithPriority('O');
				System.out.println(f3);
				
//			  8.Implemente um m�todo equals para a fila. Uma fila ser� igual a outra se contiver
//				os mesmos elementos, dispostos na mesma ordem. Para comparar os elementos, use
//				tamb�m o m�todo equals. 
				System.out.println("\n---------Exercicio 8---------");
				System.out.println(f3.equals(f4));
				System.out.println(f3.equals(f3));
				
//				9. Implemente um m�todo clone para a fila. Esse m�todo deve retornar uma nova fila
//				contendo os mesmos elementos da atual. Os elementos em si n�o devem ser
//				duplicados. 
				System.out.println("\n---------Exercicio 9---------");
				System.out.println(f3);
				f4 = f3.clone();
				System.out.println(f4);
				
//				10.Considerando a classe StaticQueue, mostre como ficaria o array interno
//				(elements) do objeto q ao fim da execu��o do c�digo a seguir:
				System.out.println("\n---------Exercicio 10---------");
				StaticQueue<Integer> q = new StaticQueue<Integer>(5);
				try {
					q.enqueue(9);
					q.enqueue(8);
					q.enqueue(5);
					q.enqueue(2);
					q.dequeue();
					q.dequeue();
					q.enqueue(1);
					q.enqueue(2);
					q.enqueue(3);
					q.enqueue(7);
				} catch (Exception e) {
					System.err.println(e.toString());
				}
				System.out.println("Acontece uma exce��o de Overflow.");
					
				
//				11. Implemente o m�todo split, de acordo com a assinatura definida a seguir, que
//				divide a fila em duas partes. A fila corrente deve permanecer somente com os elementos
//				do in�cio at� a primeira ocorr�ncia de element, inclusive. O restante dos elementos deve
//				ser retornado em uma nova fila. Para comparar os elementos, utilize o m�todo equals.
				System.out.println("\n---------Exercicio 11---------");
				System.out.println(f4);
				StaticQueue<Character> f5 = new StaticQueue<Character>(10);
				f5 = f4.split('>');
				System.out.println(f4);
				System.out.println(f5);
				
				
//				12. Implemente um m�todo que percorra a fila e mova para o final todas as
//				ocorr�ncias de um determinado elemento. 
				System.out.println("\n---------Exercicio 12---------");
				System.out.println(f4);
				f4.moveToBackAllOccurrencesOf('O');
				System.out.println(f4);
				
//				13. Implemente na classe StaticQueue um m�todo que aumente a capacidade de
//				armazenamento da fila, se necess�rio, para o valor passado como par�metro. Os
//				elementos atuais devem ser preservados. 
				System.out.println("\n---------Exercicio 13---------");
				System.out.println(f4);
				System.out.println(f4.size());
				f4.ensureCapacity(20);
				System.out.println(f4);
				System.out.println(f4.size());
	}

}
