/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Point;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import servicios.Conexion;
import servicios.TareaUsuario;

/**
 *
 * @author DesktopG
 */
public class frmUsuarios extends javax.swing.JInternalFrame {

    private final TareaUsuario tarea_usuario=new TareaUsuario();
    private Usuario tablaUsuario;
    private List<Usuario> usuario;
    int idUsuarioX = 0;
    int rol=0;
    String tipoRol="ggg";
    private String nombre="";
    
    public frmUsuarios() {
        initComponents();
        this.cargar_lista_usuarios();
    }

    private void cargar_lista_usuarios(){
        try{
            this.usuario = this.tarea_usuario.imprimirTodo(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) tblUsuarios.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.usuario.size();i++){
               
                if(this.usuario.get(i).getRol()==1){
                    tipoRol="Administrador";
                }else {
                    tipoRol="Vendedor";
                }
                dtm.addRow(new Object[]{
                    this.usuario.get(i).getId_usuario(),
                    this.usuario.get(i).getNombre(),
                    this.usuario.get(i).getApellidoP(),
                    this.usuario.get(i).getApellidoM(),
                    this.usuario.get(i).getUsuario(),
                    this.usuario.get(i).getContrasena(),
                    tipoRol
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
    
    private void cargar_lista_usuarios_nombre(){
        try{
            this.usuario = this.tarea_usuario.recuperarPorNombre(Conexion.obtener(), nombre);
            DefaultTableModel dtm = (DefaultTableModel) tblUsuarios.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.usuario.size();i++){
                if(this.usuario.get(i).getRol()==1){
                    tipoRol="Administrador";
                }else {
                    tipoRol="Vendedor";
                }
                dtm.addRow(new Object[]{
                    this.usuario.get(i).getId_usuario(),
                    this.usuario.get(i).getNombre(),
                    this.usuario.get(i).getApellidoP(),
                    this.usuario.get(i).getApellidoM(),
                    this.usuario.get(i).getUsuario(),
                    this.usuario.get(i).getContrasena(),
                    tipoRol
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        lblNUsuario = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        llblTipo = new javax.swing.JLabel();
        jrbVendedor = new javax.swing.JRadioButton();
        jrbAdmin = new javax.swing.JRadioButton();
        btnAgregar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtApellidoM = new javax.swing.JTextField();
        lblApellidos1 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuarios");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Todos los Usuarios"));

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Usuario", "Contraseña", "Tipo"
            }
        ));
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblNUsuario.setText("Nombre:");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnImprimir.setText("Mostrar Todo");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(80, 80, 80)
                        .addComponent(btnImprimir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNUsuario)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Usuario"));

        lblNombre.setText("Nombre:");

        lblApellidos.setText("Apellido Paterno:");

        lblUsuario.setText("Usuario:");

        lblContrasena.setText("Contraseña:");

        llblTipo.setText("Tipo:");

        buttonGroup1.add(jrbVendedor);
        jrbVendedor.setText("Vendedor");
        jrbVendedor.setEnabled(false);

        buttonGroup1.add(jrbAdmin);
        jrbAdmin.setText("Administrador");
        jrbAdmin.setEnabled(false);

        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtNombre.setEnabled(false);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellidoP.setEnabled(false);

        txtUsuario.setEnabled(false);

        btnGuardar.setText("Guardar Cambios");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtApellidoM.setEnabled(false);

        lblApellidos1.setText("Apellido Materno:");

        txtContrasena.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblApellidos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblApellidos)
                            .addComponent(lblNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txtApellidoP))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(llblTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbAdmin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsuario)
                            .addComponent(lblContrasena))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar)
                            .addComponent(btnGuardar))
                        .addGap(108, 108, 108))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(llblTipo)
                            .addComponent(jrbVendedor)
                            .addComponent(jrbAdmin))
                        .addGap(6, 6, 6)))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContrasena)
                            .addComponent(lblApellidos1)
                            .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblApellidos)
                        .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsuario)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(42, 42, 42))
        );

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUser.setText("NombreUsuario");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuario Activo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblUser))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUser))
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        String nombre = txtNombre.getText();
        String apPat = txtApellidoP.getText();
        String apMat = txtApellidoM.getText();
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        
        
        if(nombre.equals("")||apPat.equals("")||usuario.equals("")||contrasena.equals("")){
            JOptionPane.showMessageDialog(this, "Por favor llene los campos correctamente.");
        } else {
        if(jrbVendedor.isSelected()){
            rol=2;
        } else if(jrbAdmin.isSelected()){
            rol=1;
        }
        
        this.tablaUsuario=new Usuario(); 
        
         if(rol==0){
            JOptionPane.showMessageDialog(this, "Por favor especifique el tipo de usuario.");
        } else {
             tablaUsuario.setNombre(nombre);
             tablaUsuario.setApellidoP(apPat);
             tablaUsuario.setApellidoM(apMat);
             tablaUsuario.setUsuario(usuario);
             tablaUsuario.setContrasena(contrasena);
             tablaUsuario.setRol(rol);
             
             try {
                if(tarea_usuario.validaUsuario(Conexion.obtener(), usuario)){
                    JOptionPane.showMessageDialog(this, "El usuario ya está registrado.");
                } else {
                    this.tarea_usuario.guardar(Conexion.obtener(), this.tablaUsuario);
                    this.cargar_lista_usuarios();
                    btnAgregar.setEnabled(false);
                    txtNombre.setEnabled(false);
                    txtApellidoP.setEnabled(false);
                    txtApellidoM.setEnabled(false);
                    txtUsuario.setEnabled(false);
                    txtContrasena.setEnabled(false);
                    jrbAdmin.setEnabled(false);
                    jrbVendedor.setEnabled(false);
                }
                
                
                
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
                }
                
        }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        
        btnGuardar.setEnabled(false);
        btnAgregar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellidoP.setEnabled(true);
        txtApellidoM.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtContrasena.setEnabled(true);
        jrbAdmin.setEnabled(true);
        jrbVendedor.setEnabled(true);
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMousePressed
        
        JTable tabla = (JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);
        if (evt.getClickCount() == 1) {
            idUsuarioX = Integer.parseInt(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            txtNombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtApellidoP.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
            txtApellidoM.setText(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
            txtUsuario.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
            txtContrasena.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());
            
        }
        
    }//GEN-LAST:event_tblUsuariosMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        btnAgregar.setEnabled(false);
        btnGuardar.setEnabled(true);
        txtNombre.setEnabled(true);
        txtApellidoP.setEnabled(true);
        txtApellidoM.setEnabled(true);
        txtUsuario.setEnabled(true);
        txtContrasena.setEnabled(true);
        jrbAdmin.setEnabled(true);
        jrbVendedor.setEnabled(true);
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        int fila_seleccionada = tblUsuarios.getSelectedRow();
        if (fila_seleccionada >= 0){
        
        String nombre = txtNombre.getText();
        String apPat = txtApellidoP.getText();
        String apMat = txtApellidoM.getText();
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();
        
        
        if(nombre.equals("")||apPat.equals("")||usuario.equals("")||contrasena.equals("")){
            JOptionPane.showMessageDialog(this, "Por favor llene los campos correctamente.");
        } else {
        if(jrbVendedor.isSelected()){
            rol=2;
        } else if(jrbAdmin.isSelected()){
            rol=1;
        }
        
        this.tablaUsuario=new Usuario(); 
        
         if(rol==0){
            JOptionPane.showMessageDialog(this, "Por favor especifique el tipo de usuario.");
        } else {
             tablaUsuario.setId_usuario(idUsuarioX);
             tablaUsuario.setNombre(nombre);
             tablaUsuario.setApellidoP(apPat);
             tablaUsuario.setApellidoM(apMat);
             tablaUsuario.setUsuario(usuario);
             tablaUsuario.setContrasena(contrasena);
             tablaUsuario.setRol(rol);
             
             try {
                 
                this.tarea_usuario.editar(Conexion.obtener(), this.tablaUsuario);
                this.cargar_lista_usuarios();
                
                
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
                }
             
             System.out.println(tarea_usuario.isF());
                if(tarea_usuario.isF()==false){
                    JOptionPane.showMessageDialog(this, "El usuario ya está registrado, escriba un nombre de usuario diferente o use el mismo que tenía");
                } else {
                btnGuardar.setEnabled(false);
                txtNombre.setEnabled(false);
                txtApellidoP.setEnabled(false);
                txtApellidoM.setEnabled(false);
                txtUsuario.setEnabled(false);
                txtContrasena.setEnabled(false);
                jrbAdmin.setEnabled(false);
                jrbVendedor.setEnabled(false);
                }
        }
        }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int fila_seleccionada = tblUsuarios.getSelectedRow();
        if(fila_seleccionada >= 0){
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar esta categoria?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (decision == 0) {
                try {
                    this.tarea_usuario.eliminar(Conexion.obtener(), this.usuario.get(fila_seleccionada));
                    this.cargar_lista_usuarios();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.(clase no encontrada)");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.");
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        
        this.cargar_lista_usuarios();
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        this.nombre = txtBuscar.getText();
        this.cargar_lista_usuarios_nombre();
        if ("".equals(nombre)){
            JOptionPane.showMessageDialog(this, "Debes escribir el nombre del usuario que desees buscar.");
            this.cargar_lista_usuarios();
        }
        if(tarea_usuario.isF()==true){
            JOptionPane.showMessageDialog(this, "Usuario encontrado.");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
        }
        
        this.nombre ="";
        
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbAdmin;
    private javax.swing.JRadioButton jrbVendedor;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidos1;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblNUsuario;
    private javax.swing.JLabel lblNombre;
    public static javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel llblTipo;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
