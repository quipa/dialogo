
package org.quipa.dialogo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

enum Status {
  
  // based on UNIX sysexits codes
  OK(0),
  USAGE(64),
  IO(66),
  COMPILE(65),
  RUNTIME(70);
  
  final int code;
  
  Status(int code) {
    this.code = code;
  }
  
}


public class Main {

  public static void main(String[] args) throws IOException {
    Status status;
    
    switch (args.length) {
      case 0:
        status = run(); break;
      case 2: status = run(mode(args[0]), args[1]); break;
      case 1:
        String arg = args[0];
        switch (arg) {
          case "morf":
          case "lex" :
          case "sin" :
          case "sem" : status = run(mode(arg)); break;
          default    : status = run(arg); break;
        } break;
      default:
        System.out.println("Uso: dialogo [morf|lex|sin|sem] [documento]");
        status = Status.USAGE;
    }
    
    System.exit(status.code);
  }
  
  // Interactive mode
  public static Status run() {
    return run(Mode.standard);
  }
  
  public static Status run(Mode mode) {
    // greeting
    System.out.println("Bem-vindo ao 'Dialogo'!\n");
    var interpreter = new Interpreter(mode);
    
    try {
      var reader = new BufferedReader(new InputStreamReader(System.in));
      
      // Interpret Loop
      while (true) {
        System.out.print("-- ");
        String line = reader.readLine();
        
        if (line == null) break;
        
        System.out.println(interpreter.call(line));
      }
      
    } catch (IOException e) {
      System.out.println("Erro na digitação do texto");
    }
    
    // parting
    System.out.println("\n\nAté ao próximo 'Dialogo'!");

    return Status.OK;
  }
  
  // Batch mode
  public static Status run(String path) {
    return run(Mode.standard, path);
  }
  
  public static Status run(Mode mode, String path) {
    var interpreter = new Interpreter(mode);
    try {
      var source = Files.readString(Paths.get(path));
        System.out.println(interpreter.call(source));
    } catch (DialogoErrors errors) {
      for (var e : errors) {
        System.out.println(e);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Documento não encontrado.");
      return Status.IO;
    } catch (IOException e) {
      System.out.println("Houve um problema com o documento.");
      return Status.IO;
    }
    
    return Status.OK;
  }
  
  public static Mode mode(String arg) {
    switch (arg) {
      case "morf": return Mode.MORPHOLOGICAL;
      case "lex" : return Mode.LEXICAL;
      case "sin" : return Mode.SYNTATICAL;
      case "sem" : return Mode.SEMANTIC;
      default    : return Mode.standard;
    }
  }
  
}

