package Iterator.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 17/8/22
 * Time: 1:48 p. m.
 */

public class Employee implements IContainer<Employee> {

  private String name;
  private String role;
  private List<Employee> subordinates;

  public Employee(String role, String puesto, Employee... subordinates){
    this.name = role;
    this.role = puesto;
    this.subordinates = Arrays.asList();
  }

  @Override
  public IIterator<Employee> createIterator() {
    return new TreeEmployeeIterator();
  }

  private class TreeEmployeeIterator implements IIterator<Employee> {

    private LinkedList<Employee> list = new LinkedList<Employee>();
    private int index = 0;

    public TreeEmployeeIterator(){
      addRecursive(Employee.this);
    }

    public void addRecursive(Employee employee){
      list.add(employee);

      if(employee.getSubordinates() != null){
        for(Employee subordinate: employee.getSubordinates()){
          addRecursive(subordinate);
        }
      }
    }

    @Override
    public boolean hasNext() {
      if(list.isEmpty()){
        return false;
      }

      return index < list.size();
    }

    @Override
    public Employee next() {

      if(!hasNext()){
        throw new RuntimeException("No hay Mas elementos");
      }
      return list.get(index++);
    }
  }

  public void setSubordinates(List<Employee> subordinates){
    this.subordinates = subordinates;
  }

  public void addSubordinate(Employee subordinate){
    if(subordinate == null){
      subordinates = new ArrayList<>();
    }
    subordinates.add(subordinate);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "name='" + name + '\'' +
        ", role='" + role + '\'' +
        '}';
  }

  // Getters and Setters

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public List<Employee> getSubordinates() {
    return subordinates;
  }

}
