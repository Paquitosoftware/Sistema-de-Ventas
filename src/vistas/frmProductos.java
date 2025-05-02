/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Point;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import servicios.Conexion;
import modelo.Producto;
import servicios.TareaProducto;
/**
 *
 * @author DesktopG
 */
public class frmProductos extends javax.swing.JInternalFrame {

    private final TareaProducto tarea_producto=new TareaProducto();
    private Producto tablaProducto;
    private List<Producto> producto;
    
    int idProductoX = 0;
    private final DefaultComboBoxModel modeloCategoria;
    private String nombre="";
    private String tipo="";
    
    public frmProductos() throws ClassNotFoundException {
        modeloCategoria = new DefaultComboBoxModel(new String[]{});
        initComponents();
        this.llenaComboBox();
        this.cargar_lista_producto();
    }
    
    private void cargar_lista_producto(){
        try{
            this.producto = this.tarea_producto.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) tblProductos.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getId_producto(),
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio(),
                    this.producto.get(i).getTipo(),
                    this.producto.get(i).getNombre_categoria()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase.");        
        }   
    }
    
    private void llenaComboBox() throws ClassNotFoundException {

        try {
            /* Realizamos la consulta a la base de datos*/
            String sql = "SELECT nombre FROM categoria ORDER BY nombre ASC";
            /* Se prepara la consulta */
            PreparedStatement categorias  = Conexion.obtener().prepareStatement(sql);
            /* Y se ejecuta en la siguiente línea */
            ResultSet ver = categorias.executeQuery();
            /* while recorremos el resultado generado por la consulta */
            while (ver.next()) {
                /*con el modelo adentro del wile se llena la con los resultados de la consulta con el metodo addElement*/
                int i = 0+1;
                modeloCategoria.addElement(ver.getString(i));
            }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this,"No se puede cargar la consulta SQL"+ex);
        }
    }
    
    private void cargar_lista_producto_nombre(){
        try{
            this.producto = this.tarea_producto.recuperarPorNombre(Conexion.obtener(), nombre);
            DefaultTableModel dtm = (DefaultTableModel) tblProductos.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getId_producto(),
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio(),
                    this.producto.get(i).getTipo(),
                    this.producto.get(i).getNombre_categoria()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los registros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase.");        
        }   
    } 
    
    private void cargar_lista_producto_tipo(){
        try{
            this.producto = this.tarea_producto.recuperarPorTipo(Conexion.obtener(), tipo);
            DefaultTableModel dtm = (DefaultTableModel) tblProductos.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getId_producto(),
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio(),
                    this.producto.get(i).getTipo(),
                    this.producto.get(i).getNombre_categoria()
                });   
            }
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surgido un error de SQL y no se ha podido recuperar los reguistros.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
           JOptionPane.showMessageDialog(this, "Ha surguido un error no se encuentra la clase.");        
        }   
    } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlAgregar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        lblProducto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        txtCosto = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jrbExhibicion = new javax.swing.JRadioButton();
        jrbPreparacion = new javax.swing.JRadioButton();
        pnlRegistro = new javax.swing.JPanel();
        lblProducto2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnImprimir = new javax.swing.JButton();
        jrbPrep = new javax.swing.JRadioButton();
        jrbExhib = new javax.swing.JRadioButton();
        btnImprimirPorTipo = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setForeground(java.awt.Color.white);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlAgregar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblProducto.setText("Producto: ");

        jLabel2.setText("Categoria");

        lblCantidad.setText("Tipo: ");

        lblCosto.setText("Costo");

        txtProducto.setEnabled(false);
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });

        cbxCategoria.setModel(modeloCategoria);
        cbxCategoria.setEnabled(false);
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        txtCosto.setEnabled(false);

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbExhibicion);
        jrbExhibicion.setText("Exhibición");
        jrbExhibicion.setEnabled(false);
        jrbExhibicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbExhibicionActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbPreparacion);
        jrbPreparacion.setText("Preparación");
        jrbPreparacion.setEnabled(false);

        javax.swing.GroupLayout pnlAgregarLayout = new javax.swing.GroupLayout(pnlAgregar);
        pnlAgregar.setLayout(pnlAgregarLayout);
        pnlAgregarLayout.setHorizontalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addComponent(lblProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(lblCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbExhibicion)
                    .addComponent(jrbPreparacion))
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblCosto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(259, 259, 259))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))))
        );
        pnlAgregarLayout.setVerticalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar))
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad)
                            .addComponent(lblCosto)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbPreparacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbExhibicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pnlRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        lblProducto2.setText("Producto");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Costo", "Tipo", "Categoria"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductosMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        btnImprimir.setText("Mostrar todo");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrbPrep);
        jrbPrep.setText("Prep.");

        buttonGroup2.add(jrbExhib);
        jrbExhib.setText("Exhib.");
        jrbExhib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbExhibActionPerformed(evt);
            }
        });

        btnImprimirPorTipo.setText("Mostrar por tipo");
        btnImprimirPorTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirPorTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegistroLayout = new javax.swing.GroupLayout(pnlRegistro);
        pnlRegistro.setLayout(pnlRegistroLayout);
        pnlRegistroLayout.setHorizontalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addComponent(lblProducto2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addGap(49, 49, 49)
                        .addComponent(btnImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jrbPrep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbExhib)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImprimirPorTipo))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo))
                .addContainerGap())
        );
        pnlRegistroLayout.setVerticalGroup(
            pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnImprimir)
                    .addComponent(jrbPrep)
                    .addComponent(jrbExhib)
                    .addComponent(btnImprimirPorTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                        .addGap(41, 41, 41))
                    .addGroup(pnlRegistroLayout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(30, 30, 30)
                        .addComponent(btnEditar)
                        .addGap(32, 32, 32)
                        .addComponent(btnEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("NombreUsuario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario Activo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(pnlAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblUsuario))
                            .addComponent(pnlRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        int fila_seleccionada = tblProductos.getSelectedRow();
        if (fila_seleccionada >= 0){
            
            this.tablaProducto = new Producto();
            String nombre = txtProducto.getText();
            String precio = txtCosto.getText();
            String tipo;
            String categoria = (String) cbxCategoria.getSelectedItem();
            
            this.tablaProducto.setId_producto(idProductoX);
            tablaProducto.setNombre(nombre);
            tablaProducto.setTipo("Preparacion");
            tablaProducto.setPrecio(precio);
            tablaProducto.setNombre_categoria(categoria);
            
            try {
                this.tarea_producto.editar(Conexion.obtener(), this.tablaProducto);
                this.cargar_lista_producto();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro. Error de Mysql.");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro. No se encuentra la clase.");
            }
            txtProducto.setText("");
            txtCosto.setText("");
            txtProducto.setEnabled(false);
            txtCosto.setEnabled(false);
            cbxCategoria.setEnabled(false);
            btnGuardar.setEnabled(false);
            
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
        
    }//GEN-LAST:event_txtProductoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        if(jrbPreparacion.isSelected()){
            tipo="Preparacion";
        } else if(jrbExhibicion.isSelected()){
            tipo="Exhibicion";
        }
        
        this.tablaProducto = new Producto();
        
        String nombre = txtProducto.getText();
        String precio = txtCosto.getText();
        //
        String categoria = (String) cbxCategoria.getSelectedItem();
        

        tablaProducto.setNombre(nombre);
        tablaProducto.setTipo(tipo);
        tablaProducto.setPrecio(precio);
        tablaProducto.setNombre_categoria(categoria);
        if(tipo.equals("")){
            JOptionPane.showMessageDialog(this, "Por favor llene los campos completos.");
        } else {
        txtProducto.setText("");
        txtCosto.setText("");
        tipo="";
        try {
            this.tarea_producto.guardar(Conexion.obtener(), this.tablaProducto);
            this.cargar_lista_producto();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }
        
        btnAgregar.setEnabled(false);
        txtProducto.setEnabled(false);
        txtCosto.setEnabled(false);
        cbxCategoria.setEnabled(false);
        jrbPreparacion.setEnabled(false);
        jrbExhibicion.setEnabled(false);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed

    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnAgregar.setEnabled(true);
        txtProducto.setEnabled(true);
        txtCosto.setEnabled(true);
        cbxCategoria.setEnabled(true);
        jrbPreparacion.setEnabled(true);
        jrbExhibicion.setEnabled(true);
        btnGuardar.setEnabled(false);
        txtProducto.setText("");
        txtCosto.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        cargar_lista_producto();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.nombre = txtBuscar.getText();
        this.cargar_lista_producto_nombre();
        if ("".equals(nombre)){
            JOptionPane.showMessageDialog(this, "Debes escribir lo que necesitas buscar.");
        }
        if(tarea_producto.isF()==true){
            JOptionPane.showMessageDialog(this, "Producto encontrado.");
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
        }
        
        this.nombre ="";
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnAgregar.setEnabled(false);
        txtProducto.setEnabled(true);
        txtCosto.setEnabled(true);
        cbxCategoria.setEnabled(true);
        btnGuardar.setEnabled(true);
        jrbPreparacion.setEnabled(true);
        jrbExhibicion.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMousePressed
        
        JTable tabla = (JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);
        if (evt.getClickCount() == 1) {
            idProductoX = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            txtProducto.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtCosto.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            
        }
        
    }//GEN-LAST:event_tblProductosMousePressed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila_seleccionada = tblProductos.getSelectedRow();
        if(fila_seleccionada >= 0){
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar esta categoria?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (decision == 0) {
                try {
                    this.tarea_producto.eliminar(Conexion.obtener(), this.producto.get(fila_seleccionada));
                    this.cargar_lista_producto();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro. Es probable que el producto tenga ventas asignadas.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.(clase no encontrada)");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jrbExhibicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbExhibicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbExhibicionActionPerformed

    private void jrbExhibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbExhibActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbExhibActionPerformed

    private void btnImprimirPorTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirPorTipoActionPerformed
        if(jrbPrep.isSelected()){
            tipo="Preparacion";
        } else if(jrbExhib.isSelected()){
            tipo="Exhibicion";
        }
        
        if(tipo.equals("")){
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de producto que desea ver.");
        } else {
        
        this.cargar_lista_producto_tipo();
        tipo="";
        }
    }//GEN-LAST:event_btnImprimirPorTipoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimirPorTipo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton jrbExhib;
    private javax.swing.JRadioButton jrbExhibicion;
    private javax.swing.JRadioButton jrbPrep;
    private javax.swing.JRadioButton jrbPreparacion;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblProducto2;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlRegistro;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
