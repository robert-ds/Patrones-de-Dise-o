package command.impl;

import command.ICommand;

import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 22/8/22
 * Time: 3:38 p. m.
 */

public class ExitCommand implements ICommand {
  
  public static final String COMMAN_NAME = "exit";


  @Override
  public String getCommandName() {
    return COMMAN_NAME;
  }

  @Override
  public String execute(String[] args, OutputStream out) {
    System.exit(0);
    return null;
  }
}
