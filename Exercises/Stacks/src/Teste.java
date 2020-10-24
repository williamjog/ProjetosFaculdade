
public class Teste {

	public static void main(String[] args) {
		
		// Exercicio01
		// Dado o estado inicial das pilhas p1, p2 e p3 na figura abaixo, mostre o estado
		// final dessas mesmas pilhas ap�s as opera��es descritas no c�digo apresentado. 		
		StaticStack<Integer> p1 = new StaticStack<>(5);	
		StaticStack<Integer> p2 = new StaticStack<>(5);
		StaticStack<Integer> p3 = new StaticStack<>(5);
		
		p1.push(1);
		p1.push(2);
		p1.push(3);
		p1.push(4);
		
		try {
			int temp = p1.pop();
			p2.push(temp);
			p3.push(p1.pop());
			p2.push(p1.pop());
			temp = p1.pop();
			p3.push(temp);
			p1.push(p2.pop());
			p3.push(p2.pop());
			p3.push(p1.pop());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("----Exercicio 01----");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3 + "\n");
		
		// Exercicio02
		// Considere o c�digo a seguir, onde a classe MinhaPilha implementa a interface Stack:		
		StaticStack<Integer> p4 = new StaticStack<Integer>(5);
		StaticStack<Integer> p5 = new StaticStack<Integer>(5);
		StaticStack<Integer> p6 = new StaticStack<Integer>(5);
		
		 try { 
			 p4.push(10);
			 p4.push(20); 
			 p4.push(30);
			 p4.push(40);
			 p5.push(p4.pop());
			 p5.push(p4.pop());
			 p6.push(p4.pop());
			 p6.push(p4.pop());
			 p4.push(p5.pop());
			 p6.push(p5.pop());
			 p6.push(p4.pop());
			 
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("----Exercicio 02----");
		System.out.println(p4);
		System.out.println(p5); 
		System.out.println(p6 + "\n");
		
		// Exercicio03
		//M�todo implementado na classe StaticStack
		System.out.println("----Exercicio 03----");
		Integer[] arrayIntegers = p6.itemsExcept(30, p6);
		for (int i = 0; i < arrayIntegers.length; i++) {
			System.out.println(arrayIntegers[i]);
		}
		System.out.println("\n" + p6 + "\n");
		
		// Exercicio04
		//M�todo implementado na classe StaticStack
		System.out.println("----Exercicio 04----");		
		StaticStack<Integer> p7 = new StaticStack<Integer>(4);
		StaticStack<Integer> p8 = new StaticStack<Integer>(4);
		p7.push(100);
		p7.push(200); 
		p7.push(300);
		p7.push(400);
		p8.transferElements(p7, p8);
		System.out.println(p8 + "\n");
		
		// Exercicio05
		//M�todo implementado na classe StaticStack
		System.out.println("----Exercicio 05----");
		StaticStack<Integer> p9 = new StaticStack<Integer>(8);
		StaticStack<Integer> p10 = new StaticStack<Integer>(4);
				
		p9.push(0);
		p9.push(1);
		p9.push(2);
		p9.push(3);
		
		p10.push(4);
		p10.push(5);
		p10.push(6);
		p10.push(7);
		
		p9.prependStack(p9, p10);
		System.out.println(p9 + "\n");
		
		//Exerc�cio06
		//( Verdadeiro ) A sequ�ncia push(4); push(2); push(2); mul(); moo() resulta no valor 4 no topo da pilha. 
		
 		//( Falso )  O m�todo moo() inverte os dois elementos do topo da pilha. 
		
		//( Verdadeiro ) Supondo a pilha inicialmente vazia, a execu��o da sequ�ncia push(2); push(5);
		// push(3); mul(); push(1); add() deixa a pilha com um total de 2 elementos. 
		
		//( Falso ) A sequ�ncia push(8); push(5); sub() resulta no valor -3 no topo da pilha. 
		
		// ( Verdadeiro ) A express�o matem�tica 5 - 2 � 3 pode ser calculada pela sequ�ncia push(5); push(2);
		// push(3); mul(); sub().  
		
		
		//Exercicio07
		/*
		  Suponha que uma sequ�ncia de opera��es push e pop � realizada em uma pilha. As
		  opera��es push inserem, em ordem, n�mero inteiros de 0 a 9. As opera��es pop,
		  al�m de retirar o elemento do topo da pilha, exibem o valor desse elemento. Dentre
		  as sa�das abaixo, determine aquelas que s�o poss�veis. Por exemplo, a sa�da �1 2 0�
		  � poss�vel, podendo ser produzida pela sequ�ncia push(0); push(1); pop(); push(2);
		  pop(); pop(). Observe que os n�meros n�o precisam ser inseridos todos de uma �nica
		  vez na pilha. 
		  
		  a) Poss�vel
		  b) Imposs�vel
		  c) Imposs�vel
		  d) Poss�vel
		 */
		
		//Exercicio08
		//Esvazia as pilhas recebidas e forma uma nova.
		
		//Exerc�cio09
		// Implemente um m�todo que recebe uma pilha como par�metro e inverte a ordem dos
		// seus elementos. Use somente outras pilhas como estruturas auxiliares. 
		
		StaticStack<Integer> p11 = new StaticStack<Integer>(4);
		System.out.println("----Exercicio 09----");
		p11.push(0);
		p11.push(1);
		p11.push(2);
		p11.push(3);
		
		System.out.println(p11 + "\n");
		p11.flip(p11);
		System.out.println(p11 + "\n");
		
		// Exercicio10
		// Escreva um algoritmo para verificar se um dado elemento est� presente em uma pilha.
		// Em caso positivo, o algoritmo deve fornecer tamb�m a posi��o do item na pilha,
		// considerando a base como posi��o 0. A pilha deve permanecer a mesma ap�s a
		// execu��o do procedimento.
		System.out.println("----Exercicio 10----");
		System.out.println(p11 + "\n");
		System.out.println(p11.verifyElement(2) + "\n");
		

		/* Esse m�todo verifica se uma express�o matem�tica tem os par�nteses agrupados de
		forma correta, isto �:
		(1)se o n�mero de par�nteses � esquerda e � direita � igual; e
		(2)se todo par�ntese aberto � seguido, posteriormente, por um fechamento de
		par�ntese.
		Por exemplo, as express�es �((A+B)� e �A+B(� violam a regra (1) e as express�es
		�)A+B(-C� e �(A+B)) � (C+D� violam a regra (2). Um exemplo de express�o correta
		seria: �((A+B)-(C+D))�.
		O m�todo recebe como par�metro uma pilha que cont�m os caracteres da express�o
		matem�tica e retorna verdadeiro, se os par�nteses da express�o est�o agrupados de forma
		correta, ou falso, caso contr�rio. Uma pilha armazena apenas uma �nica express�o. Utilize
		o m�todo equals para a compara��o dos objetos. As express�es est�o armazenadas na
		pilha da direta para a esquerda, ou seja, os caracteres da direita s�o empilhados primeiro
		*/
		System.out.println("----Exercicio 11----");	
		StaticStack<Character> p12 = new StaticStack<Character>(13); // CORRETA
		p12.push(')');
		p12.push(')');
		p12.push('D');
		p12.push('+');
		p12.push('C');
		p12.push('(');
		p12.push('-');
		p12.push(')');
		p12.push('B');
		p12.push('+');
		p12.push('A');
		p12.push('(');
		p12.push('(');
		System.out.println(p12.checkBrackets(p12));
		
		StaticStack<Character> p13 = new StaticStack<Character>(6); // ERRADA
		p13.push(')');
		p13.push('B');
		p13.push('+');
		p13.push('A');
		p13.push('(');
		p13.push('(');
		System.out.println(p13.checkBrackets(p13));
		
		StaticStack<Character> p14 = new StaticStack<Character>(4); // ERRADA
		p14.push('(');
		p14.push('B');
		p14.push('+');
		p14.push('A');
		System.out.println(p14.checkBrackets(p14)); 
		
		StaticStack<Character> p15 = new StaticStack<Character>(7); // ERRADA
		p15.push('C');
		p15.push('-');
		p15.push('(');
		p15.push('B');
		p15.push('+');
		p15.push('A');
		p15.push(')');
		System.out.println(p15.checkBrackets(p15)); 
		
		StaticStack<Character> p16 = new StaticStack<Character>(13); // ERRADA
		p16.push('D');
		p16.push('+');
		p16.push('C');
		p16.push('(');
		p16.push(' ');
		p16.push('-');
		p16.push(' ');
		p16.push(')');
		p16.push(')');
		p16.push('B');
		p16.push('+');
		p16.push('A');
		p16.push('(');
		System.out.println(p16.checkBrackets(p16) + "\n"); // ERRADA	
		
		//Exercicio12
		System.out.println("----Exercicio 12----");
		StaticStack<Integer> p17 = new StaticStack<Integer>(9);
		p17.push(10);
		p17.push(15);
		p17.push(20);
		p17.push(25);
		p17.push(30);
		System.out.println(p17.contains(25)); // ENCONTRA
		System.out.println(p17.contains(31) + "\n"); // NAO EXISTE
		
		System.out.println("----Exercicio 13----");
		System.out.println(p17);
		p17.flip();
		System.out.println("\n" + p17 + "\n");
		
		System.out.println("----Exercicio 14----");
		StaticStack<Integer> p18 = new StaticStack<Integer>(4);
		p18.push(100);
		p18.push(150);
		p18.push(200);
		p18.push(250);
		System.out.println(p17 + "\n");
		p17.push(p18);
		System.out.println(p17 + "\n");
		
		System.out.println("----Exercicio 15----");
		StaticStack<Integer> p19 = new StaticStack<Integer>(4);
		p19.push(20);
		p19.push(10);
		p19.push(15);
		p19.push(25);
		
		StaticStack<Integer> p20 = new StaticStack<Integer>(4);
		p20.push(20);
		p20.push(10);
		p20.push(15);
		p20.push(25);
		
		StaticStack<Integer> p21 = new StaticStack<Integer>(4);
		p21.push(20);
		p21.push(10);
		p21.push(15);
		p21.push(19);
		
		System.out.println(p19.equals(p20)); // Igual
		System.out.println(p19.equals(p21)); // Diferente
		System.out.println(p20.equals(p21) + "\n"); // Diferente
		
		System.out.println("----Exercicio 16----");
		
		StaticStack<Integer> p22 = new StaticStack<Integer>(4);
		System.out.println(p21 + "\n");
		p22 = p21.clone(p21);
		System.out.println(p22); //CLONADO
	} 
}
