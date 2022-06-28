package abstractfactory.rest;

import abstractfactory.impl.IServiceStackAbstractFactory;
import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 28/6/22
 * Time: 2:26 p. m.
 */

public class RestServiceStackImpl implements IServiceStackAbstractFactory {
  @Override
  public IEmployeeService getEmployeeService() {
    return new EmployeeServiceRestImpl();
  }

  @Override
  public IProductsService getProductsService() {
    return new ProductServiceRestImpl();
  }
}
