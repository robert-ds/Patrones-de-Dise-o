package memento.gui;

import memento.impl.EmployeeCaretaker;
import memento.impl.EmployeeMemento;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA
 * Created By Robert Vásquez
 * Date: 7/9/22
 * Time: 3:55 p. m.
 */

public class EmployeeGUI extends javax.swing.JFrame {
  memento.entity.Employee employee = new memento.entity.Employee();
  private EmployeeCaretaker caretaker = new EmployeeCaretaker();

  public EmployeeGUI() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    nameTxt = new javax.swing.JTextField();
    lastNameTxt = new javax.swing.JTextField();
    empNumberTxt = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    prevBtn = new javax.swing.JButton();
    nextBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Patrón de diseño Memento ");

    jLabel1.setText("First name");

    jLabel2.setText("Last name");

    jLabel3.setText("Employee number");

    jButton1.setText("Save");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        save(evt);
      }
    });

    prevBtn.setText("<");
    prevBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        previous(evt);
      }
    });

    nextBtn.setText(">");
    nextBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        next(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(prevBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(empNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 141, Short.MAX_VALUE))
                            .addComponent(lastNameTxt)
                            .addComponent(nameTxt))))
                .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{jLabel1, jLabel2, jLabel3});

    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(prevBtn)
                    .addComponent(nextBtn))
                .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void save(java.awt.event.ActionEvent evt) {
    employee.setName(nameTxt.getText());
    employee.setLastName(lastNameTxt.getText());
    employee.setEmployeeNumber(empNumberTxt.getText());

    caretaker.addNewMemento(employee.createMemento());
    JOptionPane.showMessageDialog(this, "Estado Guardado");
  }

  private void previous(java.awt.event.ActionEvent evt) {
    EmployeeMemento menento = caretaker.getPreviousMemento();

    if (menento == null) {
      JOptionPane.showMessageDialog(this, "No existen ma estados");
      return;
    }

    employee.restoreMemento(menento);
    updateModel();
  }

  private void next(ActionEvent evt) {
    EmployeeMemento memento = caretaker.getNextMemento();

    if (memento == null) {
      JOptionPane.showMessageDialog(this, "No Esxisten mas estados");
      return;
    }

    employee.restoreMemento(memento);
    updateModel();

  }

  private void updateModel() {
    nameTxt.setText(employee.getName());
    lastNameTxt.setText(employee.getLastName());
    empNumberTxt.setText(employee.getEmployeeNumber());
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField empNumberTxt;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JTextField lastNameTxt;
  private javax.swing.JTextField nameTxt;
  private javax.swing.JButton nextBtn;
  private javax.swing.JButton prevBtn;

}