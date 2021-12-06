// classe principal do projeto sobre solucao do problema de paradas
// Alunos:
// Pedro Henrique Falleiros Sampaio Presotto - 201911255
// Yan Gustavo Andrade Pisani - 201911224

// para compilar o programa, roda-se o seguinte comando
// "javac main.java"
// para executar o programa
// "java main <nome do arquivo para leitura>"


import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; 

public class main {

  /*Funcao retorna true caso um estado ja exista em um ArrayList de estado*/
  public static boolean estadoExiste(String estado, ArrayList<Estado> arr){
    for (int i=0; i<arr.size(); i++){
      if (arr.get(i).getRepresentacao().equals("q" + (estado.length() - 1)))
      {
        return true;
      }
    }
    return false;
  }

  /* Funcoes auxiliares tradutoras */
  public static int tradutorEstado(String original){   
    return original.length();
  }

  public static String tradutorDirecao(String original){
      if(original.equals("1")) return "direita";
      return "esquerda";
  }

  public static String tradutorLeituraEscrita(String palavra){
    if(palavra.equals("1")){
      return "a";
    }
    
    if(palavra.equals("11")){
      return "b";
    }

    return "B";
  }

  public static void main(String args[]) {
    try {
      File f = new File(args[0] + ".txt");
      Scanner readFile = new Scanner(f);
      String data;
      ArrayList<Estado> estadosCriados = new ArrayList<Estado>();
      String origem, leitura, destino, escrita, direcao;

      data = readFile.nextLine(); //leitura primeira linha do arquivo

      data = data.substring(3, data.length()); //ignora o primeiro delimitador 000, do inicio da entrada
      
      String[] leituraSeparada = data.split("000"); //divide a string entre maquina e palavra

      System.out.println("Maquina: => " +  leituraSeparada[0]);  //printa unario correspondente a maquina
      System.out.println("Palavra: => " + leituraSeparada[1] + "\n"); //printa unario correspondente a palavra
      
      String[] transicoes = leituraSeparada[0].split("00"); //obtem todas as transicoes

      String palavra = leituraSeparada[1]; //obtem a palavra ja separada anteriormente
      
      String[] auxArr; //inicializacao de um array auxiliar de string
      
      for (int i=0; i<transicoes.length; i++){
        auxArr = transicoes[i].split("0"); //separacao dos atributos de cada transicao existente
        origem = auxArr[0];  //origem da transicao i
        leitura = auxArr[1]; //leitura da transicao i
        destino = auxArr[2]; //destino da transicao i
        escrita = auxArr[3]; //escrita da transicao i
        direcao = auxArr[4]; //direcao da transicao i
        
        if(!estadoExiste(origem, estadosCriados)){ //caso o estado correpondente a origem da transicao i não exista
          Estado auxEstado = new Estado("q"+ (origem.length() - 1)); //cria um novo estado
          estadosCriados.add(auxEstado); //armazena novo estado no ArrayList de estados criados
        }

        if(!estadoExiste(destino, estadosCriados)){ //caso o estado correpondente a destino da transicao i estado não exista
          Estado auxEstado = new Estado("q"+ (destino.length() - 1)); //cria um novo estado
          estadosCriados.add(auxEstado); //armazena novo estado no ArrayList de estados criados
        }

        estadosCriados.get(origem.length() - 1).AdicionaTransicao(origem, leitura, destino, escrita, direcao); //atribui transicao ao estado correpondente a origem
      }   

      /* Imprime estados e suas transicoes*/
      for (int i = 0; i< estadosCriados.size(); i++){
        System.out.println("Estado: " + estadosCriados.get(i).getRepresentacao());            
        for (int j = 0 ; j < estadosCriados.get(i).transicoes.size(); j++){
          System.out.println("---- Transicao " + j + ":");
          System.out.println("--------Origem   : q" + (tradutorEstado(estadosCriados.get(i).transicoes.get(j).getOrigem()) - 1));
          System.out.println("--------Leitura  : "  + tradutorLeituraEscrita(estadosCriados.get(i).transicoes.get(j).getLeitura()));
          System.out.println("--------Escrita  : "  + tradutorLeituraEscrita(estadosCriados.get(i).transicoes.get(j).getEscrita()));  
          System.out.println("--------Direcao : "  + tradutorDirecao((estadosCriados.get(i).transicoes.get(j).getDirecao())));   
          System.out.println("--------Destino  : q" + (tradutorEstado(estadosCriados.get(i).transicoes.get(j).getDestino()) - 1 + "\n"));
        }
      }

      System.out.println();

      readFile.close();

      Maquina maquina = new Maquina(); //cria objeto maquina

      maquina.AdicionaEstado(estadosCriados.get(0), true); //adiciona o estado inicial ao ArrayList estadosCriados da maquina

      for (int i = 1; i< estadosCriados.size(); i++){
        maquina.AdicionaEstado(estadosCriados.get(i), false); //adiciona os demais estados na maquina
      }
    
      palavra = palavra.replace("111", Simbolo.B.getSimbolo()); //substui 111 por 'B' na palavra de entrada
      palavra = palavra.replace("11", Simbolo.b.getSimbolo()); //substui 11 por 'b' na palavra de entrada
      palavra = palavra.replace("1", Simbolo.a.getSimbolo()); //substui 1 por 'a' na palavra de entrada
      
      System.out.println("Palavra: " + palavra); //imprime a palavra com as letras do alfabeto e zeros

      maquina.SetEntrada(palavra); //passa variavel palavra como palavra de entrada para a maquina
      
      maquina.printConteudoMaquina(); //printa o conteudo da fita da maquina
      
      //for (int i=0; true; i++){ 
      //   if (maquina.Atuar()){
      //     System.out.println(i + "a execução");    
      //   }
      //  else break;
      //}
      
    } catch (FileNotFoundException e) {
      System.out.println("Ocorreu um erro");
      e.printStackTrace();
    }
  }
}
