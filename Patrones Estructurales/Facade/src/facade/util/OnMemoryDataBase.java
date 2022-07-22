package facade.util;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 22/7/22
 * Time: 2:39 p. m.
 */

public class OnMemoryDataBase {
  private static final HashMap<Long,Customer> CUSTOMER_MAP = new HashMap<>();
  private static final HashMap<String,Card> CARD_BINS = new HashMap<>();

  static{
    CUSTOMER_MAP.put(1L,new Customer(1L,"Robert Vasquez", 5000, "Suspendido"));
    CUSTOMER_MAP.put(2L,new Customer(2L,"Andres López", 300, "Suspendido"));
    CUSTOMER_MAP.put(3L,new Customer(3L,"Carmen Guy", 100, "Activo"));
    CUSTOMER_MAP.put(4L,new Customer(4L,"Antonio Paez", 100, "Baja"));

    CARD_BINS.put("123", new Card("123","VISA", "Credit"));
    CARD_BINS.put("124", new Card("124","MASTERCARD", "Debit"));
    CARD_BINS.put("121", new Card("121","Venture", "Credit"));
  }

  public static Customer findCustomerById(Long id){
    return CUSTOMER_MAP.get(id);
  }

  public static void changeCustomerStatus(Long id, String newStatus){
    Customer customer = findCustomerById(id);
    customer.setStatus(newStatus);
    System.out.println("Cambio de status del cliente " + customer.getName() + "" + newStatus);
  }

  public static boolean validateCardBins(String creditCardPrefix){
    if (CARD_BINS.containsKey(creditCardPrefix)) {
      String company = CARD_BINS.get(creditCardPrefix).getCompany();
      System.out.println("Targeta Válida > " + creditCardPrefix + ", " + company + "\n");
      return true;
    }else{
      System.out.println("Targeta inválida > \n");
      return false;
    }
  }

  public static String getCardCompany(String creditCardPrefix){
    if(CARD_BINS.containsKey(creditCardPrefix)){
      return CARD_BINS.get(creditCardPrefix).getCompany();
    }
    throw new RuntimeException("geta no existe");
  }

}
