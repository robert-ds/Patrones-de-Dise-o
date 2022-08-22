package command.impl;

import java.io.File;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 22/8/22
 * Time: 3:36 p. m.
 */

public class DirCommand extends BaseCommand{

  public static final String COMMAND_NAME = "dir";

  @Override
  public String getCommandName() {
    return COMMAND_NAME;
  }

  @Override
  public void execute(String[] args, OutputStream out) {

    if(args == null || args.length < 2){
      write(out, COMMAND_NAME + " Argumentos insuficientes");
    }

    String operation = args[0];
    if("-D".equals(operation.toUpperCase())){
      write(out, deleteDir(args[1]));
    }else if("-N".equals(operation.toUpperCase())){
      write(out, newDir(args[1]));
    }else{
      write(out, "Se esperaba una operación correcta -d | -n");
    }

  }

  private String deleteDir(String url){

    try{
      File file = new File(url);

      if(!file.exists()){
        return "El archivo no existe";
      }

      if(!file.canWrite()){
        return "Orivilegios insuficientes";
      }

      file.delete();
      return "";
    }catch(Exception e){
      return "ERROR: " + e.getMessage();
    }

  }

  private String newDir(String url){

    try{
      File file = new File(url);

      if(file.exists()){
        return "El archivo ya existe";
      }

      file.mkdirs();
      return "";
    }catch(Exception e){
      return "ERROR: " + e.getMessage();
    }

  }
  
}
