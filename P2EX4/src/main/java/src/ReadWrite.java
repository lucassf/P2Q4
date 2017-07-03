package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWrite {

  private boolean isInvalidInput(String s) {
    if (s == null) {
      return true;
    }

    Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
    Matcher matcher = pattern.matcher(s);

    return matcher.find() || s.isEmpty();
  }
  
  /**
  * Função que escreve em um arquivo especificado
  *
  * @author  Lucas S.
  * @version 1.0
  * @since   03-07-2017 
  */
  public String write(String filename,String[] writeLine) {
    String result = "";

    if (isInvalidInput(filename)) {
      return "Entrada invalida";
    }

    if (writeLine == null) {
      writeLine = new String[]{};
    }

    try {
      BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filename));
      for (int i = 0; i < writeLine.length; i++) {
        buffWrite.append(writeLine[i] + "\n");
      }
      buffWrite.close();
      result = "Escrita realizada";
    } catch (IOException e) {
      result = "Arquivo invalido";
    }
    return result;
  }

  /**
   * Função que le de um arquivo especificado
   *
   * @author  Lucas S.
   * @version 1.0
   * @since   03-07-2017 
   */
  public String read(String filename) {
    String result = "";

    if (isInvalidInput(filename)) {
      return "Entrada invalida";
    }

    try {
      BufferedReader br = new BufferedReader(new FileReader(filename));
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        result += currentLine + "\n";
      }
      br.close();
    } catch (IOException e) {
      result = "Arquivo inexistente";
    }

    return result;
  }
}
