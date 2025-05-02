/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Point;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Evento;
import modelo.Venta;
import servicios.Conexion;
import servicios.GenerarReporte;
import servicios.TareaEvento;
import servicios.TareaVenta;

/**
 *
 * @author DesktopG
 */
public class frmReporteVenta extends javax.swing.JInternalFrame {

    private final TareaVenta tarea_venta=new TareaVenta();
    private Venta tablaVenta;
    private List<Venta> venta;
    int idVentaX = 0;
    int opcion=0;
    String nombreEvento="";
    
    
    
    private final TareaEvento tarea_evento=new TareaEvento();
    private Evento tablaEvento;
    private List<Evento> evento;
    int accion = 0;
    int idEventoX = 0;
    String Evento="";
    String Fecha="";
    
    
    
    public frmReporteVenta() {
        initComponents();
        cargar_lista_ventas();
        cargar_lista_eventos();
    }

    
    private void cargar_lista_ventas(){
        try{
            this.venta = this.tarea_venta.imprimirVentas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) tblVenta.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.venta.size();i++){
                dtm.addRow(new Object[]{
                    this.venta.get(i).getId_venta(),
                    this.venta.get(i).getUsuario(),
                    this.venta.get(i).getProducto(),
                    this.venta.get(i).getCantidad(),
                    this.venta.get(i).getFecha(),
                    this.venta.get(i).getSubTotal()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error y no se encuentra la clase.");        
        }   
    }
    
    
    private void cargar_reporte_ventas_fecha(String fecha){
        try{
            this.venta = this.tarea_venta.imprimirVentasFecha(Conexion.obtener(), fecha);
            DefaultTableModel dtm = (DefaultTableModel) tblVenta.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.venta.size();i++){
                dtm.addRow(new Object[]{
                    this.venta.get(i).getId_venta(),
                    this.venta.get(i).getUsuario(),
                    this.venta.get(i).getProducto(),
                    this.venta.get(i).getCantidad(),
                    this.venta.get(i).getFecha(),
                    this.venta.get(i).getSubTotal()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error y no se encuentra la clase.");        
        }   
    }
    
    private void cargar_reporte_ventas_evento(String evento){
        try{
            this.venta = this.tarea_venta.imprimirVentasEvento(Conexion.obtener(), evento);
            DefaultTableModel dtm = (DefaultTableModel) tblVenta.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.venta.size();i++){
                dtm.addRow(new Object[]{
                    this.venta.get(i).getId_venta(),
                    this.venta.get(i).getUsuario(),
                    this.venta.get(i).getProducto(),
                    this.venta.get(i).getCantidad(),
                    this.venta.get(i).getFecha(),
                    this.venta.get(i).getSubTotal()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error y no se encuentra la clase.");        
        }   
    }
    
    
    private void cargar_reporte_ventas_anio(Integer evento){
        try{
            this.venta = this.tarea_venta.imprimirVentasAnio(Conexion.obtener(), evento);
            DefaultTableModel dtm = (DefaultTableModel) tblVenta.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.venta.size();i++){
                dtm.addRow(new Object[]{
                    this.venta.get(i).getId_venta(),
                    this.venta.get(i).getUsuario(),
                    this.venta.get(i).getProducto(),
                    this.venta.get(i).getCantidad(),
                    this.venta.get(i).getFecha(),
                    this.venta.get(i).getSubTotal()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error y no se encuentra la clase.");        
        }   
    }
    
    
    private void cargar_lista_eventos(){
        try{
            this.evento = this.tarea_evento.eventosPorFecha(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) tblEvento.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.evento.size();i++){
                dtm.addRow(new Object[]{
                    this.evento.get(i).getNombre(),
                    this.evento.get(i).getFecha(),
                });
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los reguistros ");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase");        
        }   
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlReporte = new javax.swing.JPanel();
        jrbAnio = new javax.swing.JRadioButton();
        jrbEvento = new javax.swing.JRadioButton();
        jrbFecha = new javax.swing.JRadioButton();
        btnElegir = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jycAnio = new com.toedter.calendar.JYearChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEvento = new javax.swing.JTable();
        btnGenerar = new javax.swing.JButton();
        pnlRegistro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reporte de Ventas");

        pnlReporte.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Reporte"));

        buttonGroup1.add(jrbAnio);
        jrbAnio.setText("Año");

        buttonGroup1.add(jrbEvento);
        jrbEvento.setSelected(true);
        jrbEvento.setText("Evento");

        buttonGroup1.add(jrbFecha);
        jrbFecha.setText("Fecha Especifica");

        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Visualizar Reporte");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jdcFecha.setEnabled(false);

        jycAnio.setEnabled(false);

        tblEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Evento", "Fecha"
            }
        ));
        tblEvento.setEnabled(false);
        tblEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEventoMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblEvento);

        btnGenerar.setText("Generar Reporte");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReporteLayout = new javax.swing.GroupLayout(pnlReporte);
        pnlReporte.setLayout(pnlReporteLayout);
        pnlReporteLayout.setHorizontalGroup(
            pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReporteLayout.createSequentialGroup()
                .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlReporteLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGenerar))
                    .addGroup(pnlReporteLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbAnio)
                            .addComponent(jrbEvento)
                            .addComponent(btnElegir)
                            .addComponent(jrbFecha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jycAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        pnlReporteLayout.setVerticalGroup(
            pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReporteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReporteLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirmar)
                            .addComponent(btnGenerar)))
                    .addGroup(pnlReporteLayout.createSequentialGroup()
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbEvento)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbAnio)
                        .addGap(3, 3, 3)
                        .addGroup(pnlReporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jrbFecha)
                            .addComponent(jycAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(btnElegir)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnlRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Informaciòn a mostrar"));

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Venta", "Vendedor", "Producto", "Cantidad", "Fecha", "SubTotal"
            }
        ));
        jScrollPane1.setViewportView(tblVenta);

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario Activo:");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("NombreUsuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario))
                .addGap(18, 18, 18)
                .addComponent(pnlReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        opcion=0;
        
        if(jrbEvento.isSelected()){
            tblEvento.setEnabled(true);
            jycAnio.setEnabled(false);
            jdcFecha.setEnabled(false);
            opcion=1;
        } else if(jrbAnio.isSelected()){
            jycAnio.setEnabled(true);
            tblEvento.setEnabled(false);
            jdcFecha.setEnabled(false);
            opcion=2;
            
        } else if(jrbFecha.isSelected()){
            jdcFecha.setEnabled(true);
            tblEvento.setEnabled(false);
            jycAnio.setEnabled(false); 
            opcion=3;
        }
        
        if(opcion==0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una de las opciones para generar los reportes");
        }
        
        
    }//GEN-LAST:event_btnElegirActionPerformed

    private void tblEventoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventoMousePressed
        try {
        JTable tabla = (JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);
        if (evt.getClickCount() == 1) {
            Evento = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            Fecha = String.format(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        }
        
        
        } catch (ArrayIndexOutOfBoundsException ec) {
            JOptionPane.showMessageDialog(this, "Selecciona el tipo de reporte 'evento' para seleccionar filas");
            System.out.println("Mensaje: "+ec);
        }
        
    }//GEN-LAST:event_tblEventoMousePressed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        if(opcion==1){
            
            this.cargar_reporte_ventas_evento(Evento);
            
            
        } else if(opcion==2){
            
            this.cargar_reporte_ventas_anio(jycAnio.getValue());
            
            
        } else if(opcion==3){
            
            if(jdcFecha.getDate()==null){
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha.");
            } else {
                
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d"); 
                String fecha = dateFormat.format(jdcFecha.getDate());
                this.cargar_reporte_ventas_fecha(fecha);
            }
            
            
            
        } else if(opcion==0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una de las opciones para generar los reportes");
        }
        
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        GenerarReporte n=new GenerarReporte();
        
        if(opcion==1){
            int fila_seleccionada=0;
            if(fila_seleccionada>=0){
               n.reporteVentasEvento(Evento);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor selecciona un evento de la tabla de eventos.");
            }
            
            
        } else if(opcion==2){
            String year=String.valueOf(jycAnio.getValue());
            n.reporteVentasAnio(year);
        } else if(opcion==3){
            if(jdcFecha.getDate()==null){
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha.");
                } else {
                DateFormat dateFormat = new SimpleDateFormat("d-MM-yyyy");
                n.reporteVentasFecha(jdcFecha.getDate());
        
            }
        } else if(opcion==0){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una de las opciones para generar los reportes");
        }
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnGenerar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JRadioButton jrbAnio;
    private javax.swing.JRadioButton jrbEvento;
    private javax.swing.JRadioButton jrbFecha;
    private com.toedter.calendar.JYearChooser jycAnio;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JPanel pnlReporte;
    private javax.swing.JTable tblEvento;
    private javax.swing.JTable tblVenta;
    // End of variables declaration//GEN-END:variables
}
