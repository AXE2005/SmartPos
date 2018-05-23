//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2017 Alejandro Camargo & previous Openbravo POS works
//    https://unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.sales;

import com.openbravo.data.gui.ComboBoxValModel;
import java.awt.Component;
import java.util.List;

/**
 * @author JG
 * @author adrian
 */
public class JProductAttListItem extends javax.swing.JPanel implements JProductAttEditI {

    private final String attid;
    private ComboBoxValModel model;

    /** Creates new form JProductAttListItem
     * @param attid
     * @param label
     * @param value
     * @param values */
    public JProductAttListItem(String attid, String label, String value, List<String> values) {

        this.attid = attid;

        initComponents();

        jLabel1.setText(label);

        values.stream().forEach((item) -> {
            jValues.addItem(item);
        });
        jValues.setSelectedItem(value);
    }

    /**
     *
     */
    @Override
    public void assignSelection() {
        java.awt.EventQueue.invokeLater(() -> {
            jValues.requestFocus();
        });
    }

    /**
     *
     * @return
     */
    @Override
    public String getAttribute() {
        return attid;
    }

    /**
     *
     * @return
     */
    @Override
    public String getValue() {
        if (jValues.getSelectedItem() == null) {
            return (String) jValues.getEditor().getItem();
        } else {
            return (String) jValues.getSelectedItem();        
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Component getComponent() {
        return this;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jValues = new javax.swing.JComboBox();

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(110, 30));

        jValues.setEditable(true);
        jValues.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jValues.setPreferredSize(new java.awt.Dimension(200, 30));
        jValues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jValuesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jValues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jValuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jValuesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jValuesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jValues;
    // End of variables declaration//GEN-END:variables

}
