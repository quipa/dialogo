
package org.quipa.dialogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Dialogo {
  
  enum Status {
    OK,
    COMPILE_ERROR,
    RUNTIME_ERROR
  }
  
  enum Mode {
    MORPHOLOGICAL,
    LEXICAL,
    SYNTATICAL,
    SEMANTIC,
  }
  
  public static void main(String[] args) throws IOException {
    if (args.length > 1) {
      System.out.println("Uso: dialogo [documento]");
      System.exit(64);
    } else if (args.length == 1) {
      runFile(args[0]);
    } else {
      runPrompt();
    }
  }
  
  private static void runFile(String path) throws IOException {
    
    byte[] bytes = Files.readAllBytes(Paths.get(path));
    Dialogo.Status status = run(new String(bytes, Charset.defaultCharset()));
    
    switch (status) {
      case COMPILE_ERROR:
        System.exit(65);
        break;
      case RUNTIME_ERROR:
        System.exit(70);
        break;
    }
  }
  
  private static void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
  
    greeting();
    
    while (true) {
      System.out.print("-- ");
      String line = reader.readLine();
      
      if (line == null) break;
      run(line);
    }
    
    parting();
  }
  
  private static Dialogo.Status run(String source) {
    
    Dialogo.Mode mode = Dialogo.Mode.MORPHOLOGICAL;
    
    // Morphological analysis.
    Morpheme.Analyser morpho = new Morpheme.Analyser(source);
    List<Morpheme> morphemes = morpho.analyse();
    if (morpho.hadError) {
      return Dialogo.Status.COMPILE_ERROR;
    }
    
    if (mode == Dialogo.Mode.MORPHOLOGICAL) {
      System.out.println("[MODE Morphological]");
      for (Morpheme m: morphemes) {
        System.out.println(m);
      }
    }
    
    /* TODO: Lexical analysis.
    Lexeme.Analyser lex = new Lexical.Analyser(morphemes);
    List<Lexeme> lexemes = lex.analyse();
    if (lex.hadError) {
      return Dialogo.Status.COMPILE_ERROR;
    }
    */
    
    /* TODO: Syntatic analyis.
    Syntagma.Analyser syn = new Syntax.Analyser(lexemes);
    List<Syntagma> syntagmas = syn.analyse();
    if (syn.hadError) {
      return Dialogo.Status.COMPILE_ERROR;
    }
    */
    
    /* TODO: Semantic analysis.
    Sememe.Analyser sem = new Sememe.Analyser(syntagmas);
    * List<Sememe> sememes = sem.analyse();
    if (sem.hadError) {
      return Dialogo.Status.RUNTIME_ERROR;
    }
    */
    
    return Dialogo.Status.OK;
    
    // System.out.println("Você disse: " + source);
  }
  
  private static void greeting() {
    System.out.println(
      "Bem-vindo ao 'Dialogo'! Para ajuda escreva 'ajuda.'");
    System.out.println();
  }
  
  private static void parting() {
    System.out.println();
    System.out.println();
    System.out.println("Até mais 'dialogar'!");
  }
  
}

