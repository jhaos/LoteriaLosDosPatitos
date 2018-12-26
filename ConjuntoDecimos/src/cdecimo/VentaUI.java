/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdecimo;

import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import static java.awt.event.KeyEvent.VK_DELETE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.plaf.SliderUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sergio
 */
public class VentaUI extends javax.swing.JPanel {

    private BDHelper bd;
    private Decimo d;
    
    /**
     * Creates new form listaIU
     */
    public VentaUI() {
        initComponents();
        this.btnVender.setEnabled(false);
        this.jSpinner1.setValue((int)0);
        this.jSlider1.setMaximum(0);
        this.jSlider1.setValue(0);
    }

    public void setBDHelper(BDHelper b) throws IOException{
        this.bd = b;
    }
    
    private void setValues(String number){
        d = bd.consultar(number);
        int valorCant = 0, valorVend=0;
        if(d!=null){
            valorCant = d.getCantidad();
            valorVend = d.getTotalVendidos();
            this.btnVender.setEnabled(true);

        }else{
            this.btnVender.setEnabled(false);
        }
        this.jSlider1.setMaximum(valorCant);
        this.jSlider1.setValue(0);
        this.disponibleTxt.setText(String.valueOf(valorCant));
        this.vendidosTxt.setText(String.valueOf(valorVend));
        this.jSpinner1.setValue(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputNumber = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSlider1 = new javax.swing.JSlider();
        jSpinner1 = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vendidosTxt = new javax.swing.JLabel();
        disponibleTxt = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnVender = new javax.swing.JButton();

        setBackground(new java.awt.Color(12, 89, 207));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_add_shopping_cart_white_36dp.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 52, -1, -1));

        inputNumber.setBackground(new java.awt.Color(12, 89, 207));
        inputNumber.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inputNumber.setForeground(new java.awt.Color(255, 255, 255));
        inputNumber.setText("Inserte número");
        inputNumber.setBorder(null);
        inputNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inputNumberMousePressed(evt);
            }
        });
        inputNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputNumberKeyPressed(evt);
            }
        });
        add(inputNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 52, 673, 36));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 95, 714, 10));

        jSlider1.setBackground(new java.awt.Color(204, 204, 204));
        jSlider1.setForeground(new java.awt.Color(255, 255, 255));
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 158, 643, -1));

        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(797, 158, 53, 36));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 318, 14, 200));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 714, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENDIDOS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 130, 55));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DISPONIBLE");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 158, 55));

        vendidosTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        vendidosTxt.setForeground(new java.awt.Color(255, 255, 255));
        vendidosTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vendidosTxt.setText("0000");
        add(vendidosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 416, 130, 38));

        disponibleTxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        disponibleTxt.setForeground(new java.awt.Color(255, 255, 255));
        disponibleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disponibleTxt.setText("0000");
        add(disponibleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 158, 38));

        btnCancelar.setBackground(new java.awt.Color(196, 62, 0));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 130, 50));

        btnVender.setBackground(new java.awt.Color(128, 226, 126));
        btnVender.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 158, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void inputNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputNumberMousePressed
        // TODO add your handling code here:
        this.inputNumber.setText("");

    }//GEN-LAST:event_inputNumberMousePressed

    private void inputNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumberKeyPressed
        // TODO add your handling code here:     
        String textoIntroducido = inputNumber.getText();
        if(evt.getKeyCode() != VK_BACK_SPACE && evt.getKeyCode()!= VK_DELETE){
            textoIntroducido += evt.getKeyChar();
        }        
        // Si busco un número entero, de 5 dígitos
        if(textoIntroducido.length()==5){
            this.setValues(textoIntroducido);
        }

    }//GEN-LAST:event_inputNumberKeyPressed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        // TODO add your handling code here:
        if((int)this.jSpinner1.getValue()<0){
            this.jSpinner1.setValue(0);
        }else if((int)this.jSpinner1.getValue()>this.jSlider1.getMaximum()){
           this.jSpinner1.setValue(this.jSlider1.getMaximum());
        }else{
            this.jSlider1.setValue((int) this.jSpinner1.getValue());
        }

    }//GEN-LAST:event_jSpinner1StateChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        this.jSpinner1.setValue((int) this.jSlider1.getValue());

    }//GEN-LAST:event_jSlider1StateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        String cod = this.inputNumber.getText();
        this.inputNumber.setText("Introduce un número válido");
        this.jSpinner1.setValue((int)0);
        this.jSlider1.setMaximum(0);
        this.jSlider1.setValue(0);
        this.disponibleTxt.setText("0000");
        this.vendidosTxt.setText("0000");
        String numero = cod.substring(12, 16);
        this.bd.eliminar(numero);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        // TODO add your handling code here:
       
        String cod = this.inputNumber.getText();
        int cantidad = (int) this.jSpinner1.getValue();
        
        this.bd.borrar(cod,cantidad);
        setValues(cod);
    }//GEN-LAST:event_btnVenderActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnVender;
    private javax.swing.JLabel disponibleTxt;
    private javax.swing.JTextField inputNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel vendidosTxt;
    // End of variables declaration//GEN-END:variables
}
