//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2017 Alejandro Camargo
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

package com.openbravo.pos.ticket;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.gui.ListQBFModelNumber;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.loader.SerializerWrite;
import com.openbravo.data.loader.SerializerWriteBasic;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.reports.ReportEditorCreator;
import java.awt.Component;
import java.util.List;

/**
 *
 * @author JG uniCenta
 */
public class ProductFilter1 extends javax.swing.JPanel implements ReportEditorCreator {
    
    private SentenceList m_sentcat;
    private ComboBoxValModel m_CategoryModel;

    /** Creates new form JQBFProduct */
    public ProductFilter1() {

        initComponents();
    }
    
    /**
     *
     * @param app
     */
    public void init(AppView app) {
         
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");

        m_sentcat = dlSales.getCategoriesList();
        m_CategoryModel = new ComboBoxValModel();          
        m_jCboName.setModel(ListQBFModelNumber.getMandatoryString());
        m_jCboUnits.setModel(ListQBFModelNumber.getMandatoryString());        

    }
    
    /**
     *
     * @throws BasicException
     */
    public void activate() throws BasicException {

        List catlist = m_sentcat.list();
        catlist.add(0, null);
        m_CategoryModel = new ComboBoxValModel(catlist);
        m_jCategory.setModel(m_CategoryModel);
    }
    
    /**
     *
     * @return
     */
    public SerializerWrite getSerializerWrite() {
        return new SerializerWriteBasic(
                new Datas[] {
                    Datas.OBJECT, Datas.STRING, 
                    Datas.OBJECT, Datas.STRING, 
                    Datas.OBJECT, Datas.STRING,
                    Datas.OBJECT, Datas.STRING});
    }

    /**
     *
     * @return
     */
    public Component getComponent() {
        return this;
    }
   
    /**
     *
     * @return
     * @throws BasicException
     */
    public Object createValue() throws BasicException {
        
        if (m_jBarcode.getText() == null || m_jBarcode.getText().equals("")) {

            return new Object[] {
                m_jCboName.getSelectedItem(), m_jName.getText(),
                m_CategoryModel.getSelectedKey() == null 
                    ? QBFCompareEnum.COMP_NONE 
                    : QBFCompareEnum.COMP_EQUALS, m_CategoryModel.getSelectedKey(),
                QBFCompareEnum.COMP_NONE, null,
                m_jCboUnits.getSelectedItem(), m_jUnits.getText()                
            };
        } else {            
            // Filtro por codigo de barras.
            return new Object[] {
                QBFCompareEnum.COMP_NONE, null,
                QBFCompareEnum.COMP_NONE, null,
                QBFCompareEnum.COMP_RE, "%" + m_jBarcode.getText() + "%",
                QBFCompareEnum.COMP_NONE, null                
            };
        }
    } 
 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jBarcode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        m_jCategory = new javax.swing.JComboBox();
        m_jCboName = new javax.swing.JComboBox();
        m_jName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        m_jCboUnits = new javax.swing.JComboBox();
        m_jUnits = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(946, 50));

        m_jBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jBarcode.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText(AppLocal.getIntString("label.prodbarcode")); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText(AppLocal.getIntString("label.prodcategory")); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("label.prodname")); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(70, 30));

        m_jCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCategory.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jCboName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCboName.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jName.setPreferredSize(new java.awt.Dimension(150, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText(AppLocal.getIntString("label.produnits")); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(50, 30));

        m_jCboUnits.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jCboUnits.setPreferredSize(new java.awt.Dimension(150, 30));

        m_jUnits.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m_jUnits.setPreferredSize(new java.awt.Dimension(50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jCboName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jBarcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jCboUnits, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jCboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(m_jCboUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(m_jUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField m_jBarcode;
    private javax.swing.JComboBox m_jCategory;
    private javax.swing.JComboBox m_jCboName;
    private javax.swing.JComboBox m_jCboUnits;
    private javax.swing.JTextField m_jName;
    private javax.swing.JTextField m_jUnits;
    // End of variables declaration//GEN-END:variables
    
}