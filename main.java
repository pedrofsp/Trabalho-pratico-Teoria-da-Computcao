import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList; 

public class main {

  public static boolean estadoExiste(String estado, ArrayList<Estado> arr){
    for (int i=0; i<arr.size(); i++){
      if (arr.get(i).getRepresentacao().equals("q" + (estado.length() - 1)))
      {
        return true;
      }
    }
    return false;
  }

  public static int tradutorEstado(String original){   
    return original.length();
  }

  public static void main(String[] args) {
    try {
      File f = new File("entrada.txt");
      Scanner readFile = new Scanner(f);
      String data;
      ArrayList<Estado> estadosCriados = new ArrayList<Estado>();
      String origem, leitura, destino, escrita, direcao;
      /* cria estados */

      // while (readFile.hasNextLine()) {
        data = readFile.nextLine();
        data = data.substring(3, data.length());
        
        String[] leituraSeparada = data.split("000");

        System.out.println("Maquina: => " +  leituraSeparada[0]);
        System.out.println("Palavra: => " + leituraSeparada[1]);
        
        
        String[] transicoes = leituraSeparada[0].split("00");

        String palavra = leituraSeparada[1];
        
        String[] auxArr;
        
        for (int i=0; i<transicoes.length; i++){
          auxArr = transicoes[i].split("0");
          origem = auxArr[0];
          leitura = auxArr[1];
          destino = auxArr[2];
          escrita = auxArr[3];
          direcao = auxArr[4];
          
          if(!estadoExiste(origem, estadosCriados)){ //caso o estado não exista
            Estado auxEstado = new Estado("q"+ (origem.length() - 1));
            estadosCriados.add(auxEstado);
          }

          if(!estadoExiste(destino, estadosCriados)){ //caso o estado não exista
            Estado auxEstado = new Estado("q"+ (destino.length() - 1));
            estadosCriados.add(auxEstado);
          }

          estadosCriados.get(origem.length() - 1).AdicionaTransicao(origem, leitura, destino, escrita, direcao);
        }   
      // }

      /* imprimir estados */

      for (int i = 0; i< estadosCriados.size(); i++){
        System.out.println("estado: " + estadosCriados.get(i).getRepresentacao());            
        for (int j = 0 ; j < estadosCriados.get(i).transicoes.size(); j++){
          System.out.println("transicao " + j + " origem : " + (tradutorEstado(estadosCriados.get(i).transicoes.get(j).getOrigem()) - 1));    
          System.out.println("transicao " + j + " destino : " + (tradutorEstado(estadosCriados.get(i).transicoes.get(j).getDestino()) - 1));    
        }
      }

      readFile.close();

      Maquina maquina = new Maquina();

      maquina.AdicionaEstado(estadosCriados.get(0), true);

      for (int i = 1; i< estadosCriados.size(); i++){
        maquina.AdicionaEstado(estadosCriados.get(i), false);
      }
    
      palavra = palavra.replace("111", Simbolo.B.getSimbolo());
      palavra = palavra.replace("11", Simbolo.b.getSimbolo());
      palavra = palavra.replace("1", Simbolo.a.getSimbolo());
      
      maquina.SetEntrada(palavra);
      
      maquina.printConteudoMaquina();
      
      for (int i=0; true; i++){ 
         if (maquina.Atuar()){
           System.out.println(i + "a execução");    
         }
        else break;
      }
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
