package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.ReadWrite;

public class P2Test {

  private ReadWrite readWriteClass = new ReadWrite();

  @Test
public void readInsecureFileNameTest() {
    String filename = "abaster@virus.com";
    assertEquals("Entrada invalida",readWriteClass.read(filename));
  }

  @Test
public void readEmptyFileNameTest() {
    String filename = "";
    assertEquals("Entrada invalida",readWriteClass.read(filename));
  }

  @Test
public void readNullFileNameTest() {
    assertEquals("Entrada invalida",readWriteClass.read(null));
  }

  @Test
public void readNotExistingFileTest() {
    String filename = "abaster1.txt";
    assertEquals("Arquivo inexistente",readWriteClass.read(filename));
  }

  @Test
public void writeInsecureFileNameTest() {
    String filename = "abaster%virus.com";
    assertEquals("Entrada invalida",readWriteClass.write(filename,new String[]{}));
  }

  @Test
public void writeNullLinesTest() {
    String filename = "abaster.txt";
    assertEquals("Escrita realizada",readWriteClass.write(filename,null));
  }

  @Test
public void writeToFileTest() {
    String filename = "abaster.txt";
    assertEquals("Escrita realizada",readWriteClass.write(filename, new String[]{"uau"}));
  }

  @Test
public void writeToDirectoryTest() {
    String filename = "src";
    assertEquals("Arquivo invalido",readWriteClass.write(filename, new String[]{"uau"}));
  }

  @Test
public void writeToThanReadFileTest() {
    String filename = "abaster.txt";
    assertEquals("Escrita realizada",readWriteClass.write(filename, new String[]{"uau"}));
    assertEquals("uau\n",readWriteClass.read(filename));
  }
}
