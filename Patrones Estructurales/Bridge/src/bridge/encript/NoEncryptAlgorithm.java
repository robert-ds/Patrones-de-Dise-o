package bridge.encript;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 14/7/22
 * Time: 3:26 p. m.
 */

public class NoEncryptAlgorithm implements IEncryptAlgorithm {


  @Override
  public String encrypt(String message, String password) throws Exception {
    return message;
  }
}
