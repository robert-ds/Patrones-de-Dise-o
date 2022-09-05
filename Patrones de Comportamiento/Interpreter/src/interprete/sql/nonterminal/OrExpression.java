package interprete.sql.nonterminal;

import interprete.sql.Context;
import interprete.sql.InterpreteException;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 5/9/22
 * Time: 2:59 p. m.
 */

public class OrExpression implements StatementExpression{

  private StatementExpression leftStatement;
  private StatementExpression rightStatement;

  public OrExpression(StatementExpression leftStatement, StatementExpression rightStatement){
    this.leftStatement = leftStatement;
    this.rightStatement = rightStatement;
  }

  @Override
  public Object interpret(Context context) throws InterpreteException {
    Boolean leftReslt = (Boolean) leftStatement.interpret(context);
    Boolean rightReslt = (Boolean) rightStatement.interpret(context);
    return leftReslt || rightReslt;
  }

  @Override
  public String toString() {
    return "( " + leftStatement.toString() +
        " OR" + rightStatement.toString() + " )";
  }
}
