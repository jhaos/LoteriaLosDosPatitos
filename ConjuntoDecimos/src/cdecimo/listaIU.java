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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sergio
 */
public class listaIU extends javax.swing.JPanel {

    BDHelper bd;
    
    /**
     * Creates new form listaIU
     */
    public listaIU() {
        initComponents();
        
        /* Centrar cabecera */
        TableCellRenderer rendererFromHeader = jTable1.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        
        /* Centrar columnas */
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        this.jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        this.jTable1.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        this.jTable1.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        this.jTable1.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );

    }

    public void setBDHelper(BDHelper b) throws IOException{
        this.bd = b;
        if(bd!=null)
            this.rellenarTabla(bd.getDecimos(0));

        System.out.println("Actualizamos bd");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(12, 89, 207));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/baseline_search_white_36dp.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 52, -1, -1));

        inputNumber.setBackground(new java.awt.Color(12, 89, 207));
        inputNumber.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inputNumber.setForeground(new java.awt.Color(255, 255, 255));
        inputNumber.setText("Inserte número o terminación");
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

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Código de barras", "Cantidad disponible", "Vendidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 1));
        jTable1.setRowHeight(30);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(6);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(22);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 136, 981, 408));
    }// </editor-fold>//GEN-END:initComponents

    private void inputNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputNumberMousePressed
        // TODO add your handling code here:
        this.inputNumber.setText("");
        rellenarTabla(bd.getDecimos(0));

    }//GEN-LAST:event_inputNumberMousePressed

    private void inputNumberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNumberKeyPressed
        // TODO add your handling code here:
        //Si busco por una terminación (entre 0 y 9 cada vez, o borrar o delete)
        
        String textoIntroducido = inputNumber.getText();
        System.out.println("Input: "+textoIntroducido);
        if(evt.getKeyCode() != VK_BACK_SPACE && evt.getKeyCode()!= VK_DELETE){
            textoIntroducido += evt.getKeyChar();
            System.out.println("Input + key: "+textoIntroducido);
        }else{
            textoIntroducido = textoIntroducido.substring(0, textoIntroducido.length()-1); //Quitar caracter borrado
            System.out.println("Input + key: "+textoIntroducido);
        }
        if(textoIntroducido.length() >0 && textoIntroducido.length() <=5){
            if((evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') || evt.getKeyCode() == VK_BACK_SPACE || evt.getKeyCode()== VK_DELETE){
                if(evt.getKeyCode() == VK_BACK_SPACE || evt.getKeyCode()== VK_DELETE){
                    System.out.println("Se borra caracter");
                }
                System.out.println("Se consulta el numero "+ textoIntroducido);
                ArrayList<Decimo> terminaciones = this.bd.consultarTerminacion(textoIntroducido);
                for(Decimo t: terminaciones) System.out.println(t.toString());
                rellenarTabla(terminaciones);
                /*if(!terminaciones.isEmpty()){
                    rellenarTabla(terminaciones);
                }*/
            }
        }
        // Si busco un número entero, de 5 dígitos
        else if(textoIntroducido.length()==5){
            Decimo d = this.bd.consultar(textoIntroducido);
        }
        // Si no busco ningún caracter
        else if(textoIntroducido.length() == 0){
            rellenarTabla(bd.getDecimos(0));
        }
    }//GEN-LAST:event_inputNumberKeyPressed

    
    private void rellenarTabla(ArrayList<Decimo> lista){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for(int i=model.getRowCount()-1; i>=0; --i)
            model.removeRow(i);
        Object rowData[] = new Object[4];
        for(Decimo d:lista){
            rowData[0] = d.getNumeroDecimo();
            rowData[1] = d.getCodigoBarras();
            rowData[2] = d.getCantidad();
            rowData[3] = d.getTotalVendidos();
            model.addRow(rowData);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}