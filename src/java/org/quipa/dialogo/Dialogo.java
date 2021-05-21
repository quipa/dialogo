
package org.quipa.dialogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Dialogo {
  
  // TODO: This seems to be interpreter state?
  enum Status {
    OK,
    COMPILE_ERROR,
    RUNTIME_ERROR
  }
  
  enum Mode {
    MORPHOLOGICAL,
    LEXICAL,
    SYNTATICAL,
    SEMANTIC,;
  }
  
  private final Mode mode;
  
  Dialogo() {
    // default mode
    mode = Mode.MORPHOLOGICAL;
  }
  
  Dialogo(String mode) {
    switch (mode) {
      case "morf": this.mode = Mode.MORPHOLOGICAL;  break;
      case "lex" : this.mode = Mode.LEXICAL;        break;
      case "sin" : this.mode = Mode.SYNTATICAL;     break;
      case "sem" : this.mode = Mode.SEMANTIC;       break;
      default    : this.mode = Mode.MORPHOLOGICAL;
    }
  }
  
  public static void main(String[] args) throws IOException {
    switch (args.length) {
      case 0: new Dialogo().runPrompt(); break;
      case 1:
        switch (args[0]) {
          case "morf": case "lex": case "sin": case "sem":
            new Dialogo(args[0]).runPrompt(); break;
          default:
            new Dialogo().runFile(args[0]);
        }
        break;
      case 2:
        new Dialogo(args[0]).runFile(args[1]); break;
      default:
        System.out.println("Uso: dialogo [morf|lex|sin|sem] [documento]");
        System.exit(64);
    }
  }
  
  private void runFile(String path) throws IOException {
    
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
  
  private void runPrompt() throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
  
    greeting();
    
    // debug
    System.out.println("[" + mode + " MODE]\n");
    
    while (true) {
      System.out.print("-- ");
      String line = reader.readLine();
      
      if (line == null) break;
      run(line);
    }
    
    parting();
  }
  
  private Dialogo.Status run(String source) {
    
    // Morphological analysis.
    Morpheme.Analyser morpho = new Morpheme.Analyser(source);
    
    while (morpho.hasNext()) {
      try {
        System.out.println(morpho.next());
      } catch (DialogoError e) {
        System.out.println(e.report(source));
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
      "Bem-vindo ao 'Dialogo'! Para ajuda escreva 'ajuda.'\n");
  }
  
  private static void parting() {
    System.out.println("\n\nAté ao próximo 'Dialogo'!");
  }
  
}

