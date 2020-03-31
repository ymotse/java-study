
				/* 				METODOS  COM  PARAMETROS			 */
package estudos;
/* Construir uma aplicacao bancaria, e a primeira Classe
 * projetada foi a Classe 'Conta', com os atributos 'cliente'e 'saldo'.
 * Utilizando a conta voce pode utilizar as seguintes operacoes bancarias:
 * 		- exibir saldo dessa conta;
 *		- sacar valores dessa conta;
 		- depositos nesta conta;
 		- transferencia de valores;
 */
public class Conta {  //Classe do tipo Publica

	// criar os atributos, e acessa-los na classe 'ContaTeste'
	String cliente; // criando o atributo 'cliente'
	double saldo; // criando o atributo 'saldo'
	
	
	
	void exibeSaldo(){ //criando metodo SEM parametros(sem retorno)'exibeSaldo'
		System.out.println(cliente+" seu saldo � "+saldo);
					 }
	
	
	void saca(double valor /* <- isso eh um parametro*/){ //criando metodo COM parametros(sem retorno)'saca'
		//deduzir do saldo o valor do saque
	saldo = saldo - valor; // ou 	saldo -= valor;		
													   }

void deposita(double valor /* <- isso eh um parametro*/){ //criando metodo com parametros(sem retorno)'deposita'
	saldo += valor;
													   }

void transferePara(Conta destino, double valor){	//metodo com dois parametros
	this.saca(valor);
	destino.deposita(valor); // 'destino' eh o nome da nova conta

											   }



public static void main(String[] args) {
	// PUBLIC STATIC sao os modificadores
	// VOID eh o tipo de retorno
	// MAIN eh o metodo
	// (STRING []ARGS) sao os argumentos
	// { dentro das chaves esta o corpo do metodo }
	
	Conta conta = new Conta(); //chamando a Classe 'Conta', criaremos uma 'conta' (CRIANDO UMA INST�NCIA)
	conta.cliente = "Isac"; //acessando o atributo 'cliente', e dando um nome ao cliente
	conta.saldo = 1_000.00; //acessando o atributo 'saldo', e dando um valor ao saldo
	conta.exibeSaldo(); //exibir o saldo (metodo) criado na classe 'Conta'
	
	conta.saca(100); //fazendo um saque acessando o metodo 'saca' (saque de 100)
	conta.exibeSaldo(); //exibir o saldo (metodo) criado na classe 'Conta'

	conta.deposita(500); //depositando acessando o metodo 'deposita' (deposito de 500)
	conta.exibeSaldo(); //exibir o saldo (metodo) criado na classe 'Conta'
	
	Conta destino = new Conta();
	destino.cliente = "Joao";
	destino.saldo = 2_000.00;
	
	destino.exibeSaldo();
	
	conta.transferePara(destino,1000.00);
	conta.exibeSaldo();
	destino.exibeSaldo();
			} //fechando o metodo MAIN
	} //fechando a classe