package decorator.impl.message;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 18/7/22
 * Time: 2:10 p. m.
 */

public interface IMessage {
  public IMessage processMessage();
  public String getContent();
  public void setContent(String content);
}
