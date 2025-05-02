/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Point;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Arqueo;
import servicios.Conexion;
import servicios.TareaEvento;

/**
 *
 * @author Bambis
 */
public class frmArqueo extends javax.swing.JInternalFrame {

    private final TareaEvento tarea_arqueo=new TareaEvento();
    private Arqueo tablaArqueo;
    private List<Arqueo> arqueo;
    String nameEvento="";
    
    public frmArqueo() {
        initComponents();
        cargar_lista_arqueo();
    }

    private void cargar_lista_arqueo(){
        try{
            this.arqueo = this.tarea_arqueo.arqueoCajaRecuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) tblArqueo.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.arqueo.size();i++){
                dtm.addRow(new Object[]{
                    this.arqueo.get(i).getEvento(),
                    this.arqueo.get(i).getFecha(),
                    this.arqueo.get(i).getMontoInicial(),
                    this.arqueo.get(i).getMontoFinal()
                });
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros ");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase");        
        }   
    }
    
    private void cargar_lista_arqueo_fecha(String fecha){
        try{
            this.arqueo = this.tarea_arqueo.arqueoCajaPorFecha(Conexion.obtener(), fecha);
            DefaultTableModel dtm = (DefaultTableModel) tblArqueo.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.arqueo.size();i++){
                dtm.addRow(new Object[]{
                    this.arqueo.get(i).getEvento(),
                    this.arqueo.get(i).getFecha(),
                    this.arqueo.get(i).getMontoInicial(),
                    this.arqueo.get(i).getMontoFinal()
                });
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros ");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase");        
        }   
    }
    
    private boolean isNumeric(String cadena){
	try {
		Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArqueo = new javax.swing.JTable();
        btnBuscarFecha = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Arqueo de Caja"));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel4.setText("Monto inicial en caja:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addGap(55, 55, 55))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informe de Arqueo"));

        tblArqueo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                " Evento", "Fecha", "Monto Inicial", "Monto Final"
            }
        ));
        tblArqueo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblArqueoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblArqueo);

        btnBuscarFecha.setText("Buscar");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar por Fecha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarFecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarFecha))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String montoI = txtMonto.getText();
        int fila_seleccionada = tblArqueo.getSelectedRow();
        if(fila_seleccionada>=0){
        if(montoI.equals("")){
            JOptionPane.showMessageDialog(this, "Escriba el monto inicial que desea modificar.");
        } else {
            if(this.isNumeric(montoI)==true){
                
                  
                try {
                    tarea_arqueo.arqueoCajaEditar(Conexion.obtener(), nameEvento, Double.parseDouble(montoI));
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros ");
                }catch(ClassNotFoundException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase");        
                } 
                
            }else {
                JOptionPane.showMessageDialog(this, "Ingrese solamente números.");
            }
        }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
        this.cargar_lista_arqueo();
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblArqueoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArqueoMousePressed
       JTable tabla = (JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);
        if (evt.getClickCount() == 1) {
            nameEvento = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            txtMonto.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            
        }
    }//GEN-LAST:event_tblArqueoMousePressed

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
        
        if(jdcFecha.getDate()==null){
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha.");
        } else {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d");  
            String fechaSelect = dateFormat.format(jdcFecha.getDate());
            cargar_lista_arqueo_fecha(fechaSelect);
            if(tarea_arqueo.isF()==false){
                JOptionPane.showMessageDialog(this, "Arqueo de caja en la fecha: "+fechaSelect);
            } else {
                JOptionPane.showMessageDialog(this, "Objeto no encontrado");
                cargar_lista_arqueo();
            }
            
        }
        
        
    }//GEN-LAST:event_btnBuscarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable tblArqueo;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
