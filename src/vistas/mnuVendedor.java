/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;
import modelo.Venta;
import servicios.Conexion;
import servicios.GenerarReporte;
import servicios.TareaProducto;
import servicios.TareaVenta;

/**
 *
 * @author DesktopG
 */
public class mnuVendedor extends javax.swing.JFrame {

    private final DefaultComboBoxModel modeloCategoria;
    private final TareaProducto tarea_producto=new TareaProducto();
    private final TareaVenta tarea_venta=new TareaVenta();
    private Venta tablaVenta;
    
    private List<Producto> producto;
    String nombreProducto="";
    String costo="";
    String costoF="";
    String tipo="";
    DefaultTableModel prodVta;
    int i=0;
    double acumtotal=0;
    
    
    public mnuVendedor() throws ClassNotFoundException {
        modeloCategoria = new DefaultComboBoxModel(new String[]{});
        
        initComponents();
        this.cargar_lista_producto();
        this.llenaComboBox();
        
        
        //Fecha del Sistema
        Date fecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
        lblFecha.setText(formato.format(fecha));
        //Hora del Sistema
        Timer tiempo=new Timer(100, new mnuVendedor.horas());
        tiempo.start();
    }
    
    class horas implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Date hora=new Date();
            String pmam="hh:mm:ss a";
            SimpleDateFormat format=new SimpleDateFormat(pmam);
            Calendar hoy = Calendar.getInstance();
            lblHora.setText(String.format(format.format(hora), hoy));
            
        }
    }

    
    
    private void cargar_lista_producto(){
        try{
            this.producto = this.tarea_producto.recuperarTodas(Conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) tblProducto.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio()
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
    
    
    private void cargar_lista_producto_categoria(String cat){
        try{
            this.producto = this.tarea_producto.recuperarPorCategoria(Conexion.obtener(), cat);
            DefaultTableModel dtm = (DefaultTableModel) tblProducto.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio()
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
    
    private void cargar_lista_producto_tipo(){
        try{
            this.producto = this.tarea_producto.recuperarPorTipo(Conexion.obtener(), tipo);
            DefaultTableModel dtm = (DefaultTableModel) tblProducto.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio()
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
    
    private void cargar_lista_producto_nombre(String nombre){
        try{
            this.producto = this.tarea_producto.recuperarPorNombre(Conexion.obtener(), nombre);
            DefaultTableModel dtm = (DefaultTableModel) tblProducto.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio()
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
    
    private boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    private boolean isNumericD(String cadena){
	try {
		Double.parseDouble(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public void prueba(){
        System.out.println(tblProducto.getColumnCount());
        try{
            this.producto = this.tarea_producto.recuperarTodas(Conexion.obtener());
            String t[]={"i", "c"};
            DefaultTableModel dtm=new DefaultTableModel(null, t){
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    if(columna==2){
                        return true;
                    } else {
                        return false;
                    }
                }
                
            };
            dtm = (DefaultTableModel) tblProducto.getModel();
            dtm.setRowCount(0);
            for(int i =0; i<this.producto.size();i++){
                dtm.addRow(new Object[]{
                    this.producto.get(i).getNombre(),
                    this.producto.get(i).getPrecio()
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
    
    public boolean validaProdVta(){
        
        try{
                for(int x=0;x<prodVta.getRowCount();x++){
                String n= (String) prodVta.getValueAt(x, 0);
                //System.out.println(n);
                    if(nombreProducto.equals(n)){
                       return true;              
                    } else {
                        System.out.println("No hay ese producto");
                    }
                }
            }catch(NullPointerException ex){
            System.out.println("Message"+ex);
            }
        
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlVender = new javax.swing.JPanel();
        btnVender = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblProductoVenta = new javax.swing.JTable();
        btnEliminardeLista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblEvento = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlAgregar = new javax.swing.JPanel();
        jcbCategoria = new javax.swing.JComboBox<>();
        lblCategoria = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducto = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBuscarCat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jrbPrep = new javax.swing.JRadioButton();
        jrbExhib = new javax.swing.JRadioButton();
        btnBuscarTipo = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CECONEXPO - Sistema de Ventas");

        pnlVender.setBorder(javax.swing.BorderFactory.createTitledBorder("Venta"));

        btnVender.setText("Realizar Venta");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        tblProductoVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Costo", "Cantidad", "Subtotal"
            }
        ));
        tblProductoVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductoVentaMousePressed(evt);
            }
        });
        jScrollPane12.setViewportView(tblProductoVenta);

        btnEliminardeLista.setText("Quitar Producto");
        btnEliminardeLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminardeListaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Total: $");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setText("0.00");

        lblEvento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEvento.setText("Evento de ceconexpo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Evento:");

        javax.swing.GroupLayout pnlVenderLayout = new javax.swing.GroupLayout(pnlVender);
        pnlVender.setLayout(pnlVenderLayout);
        pnlVenderLayout.setHorizontalGroup(
            pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVenderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVenderLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlVenderLayout.createSequentialGroup()
                                .addComponent(btnEliminardeLista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVender)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVenderLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlVenderLayout.setVerticalGroup(
            pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVenderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblEvento)
                        .addComponent(jLabel3))
                    .addGroup(pnlVenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminardeLista)
                        .addComponent(btnVender)))
                .addGap(27, 27, 27))
        );

        pnlAgregar.setBorder(javax.swing.BorderFactory.createTitledBorder("Asigancion de Productos"));

        jcbCategoria.setModel(modeloCategoria);

        lblCategoria.setText("Categoria:");

        txtCantidad.setText("1");

        lblCantidad.setText("Cantidad:");

        tblProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Producto", "Costo"
            }
        ));
        tblProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProducto);

        jLabel1.setText("Buscar por Nombre:");

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

        btnBuscarCat.setText("Buscar por Categoria");
        btnBuscarCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCatActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo:");

        buttonGroup1.add(jrbPrep);
        jrbPrep.setText("Preparación");

        buttonGroup1.add(jrbExhib);
        jrbExhib.setText("Exhibición");

        btnBuscarTipo.setText("Buscar por Tipo");
        btnBuscarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTipoActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar productos");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton1.setText("Mostrar Todos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAgregarLayout = new javax.swing.GroupLayout(pnlAgregar);
        pnlAgregar.setLayout(pnlAgregarLayout);
        pnlAgregarLayout.setHorizontalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnBuscarTipo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbExhib)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addComponent(jrbPrep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(lblCategoria)))))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCat))
                        .addGap(33, 33, 33)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar)
                                .addGap(58, 58, 58)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAgregarLayout.createSequentialGroup()
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnAgregar)))
                .addContainerGap())
        );
        pnlAgregarLayout.setVerticalGroup(
            pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAgregarLayout.createSequentialGroup()
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCategoria)
                                    .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addComponent(btnBuscarCat))))
                    .addGroup(pnlAgregarLayout.createSequentialGroup()
                        .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2))
                            .addGroup(pnlAgregarLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jrbPrep)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbExhib)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarTipo)))
                .addGap(18, 18, 18)
                .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addGroup(pnlAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCantidad)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUser.setText("Usuario");

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario Activo:");

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFecha.setText("FECHA");

        lblHora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHora.setText("HORA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlVender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha)
                    .addComponent(lblHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlVender, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        
        Date fecha = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d");  
        String fechaS = dateFormat.format(fecha);
        
        String usuario = lblUser.getText();
        String evento = lblEvento.getText();
        
        String recibido = JOptionPane.showInputDialog(this, "Ingrese la cantidad de dinero recibida por el cliente.");
        //System.out.println(recibido);
        if(this.isNumeric(recibido)==true){
            double cantRecibida = Double.parseDouble(recibido);
            if(cantRecibida>=acumtotal){
                String name="";
                String cost="";
                int cant=0;
                Double subT=0.00;
                double cambio = cantRecibida - acumtotal;
                JOptionPane.showMessageDialog(this, "Cambio: "+cambio);
                tablaVenta = new Venta();
                tablaVenta.setFecha(fechaS);
                tablaVenta.setUsuario(usuario);
                tablaVenta.setEvento(evento);
                tablaVenta.setCantRecibida(recibido);
                tablaVenta.setCambio(String.valueOf(cambio));
                tablaVenta.setTotal(String.valueOf(acumtotal));


                try {
                    //System.out.println("Fila:_"+prodVta.getRowCount());
                    //System.out.println("Columna:_"+prodVta.getColumnCount());
                    this.tarea_venta.guardarVenta(Conexion.obtener(), tablaVenta);
                    if(tarea_venta.isInsGreat()==false){
                        JOptionPane.showMessageDialog(this, "Error al insertar en venta");
                    } else {
                        for(int x=0;x<prodVta.getRowCount();x++){
                            for(int z=0;z<prodVta.getColumnCount();z++){
                                if(z==0){
                                    name=(String) prodVta.getValueAt(x, z);
                                }else if(z==1){
                                    cost=(String) prodVta.getValueAt(x, z);
                                } else if(z==2){
                                    cant=(int) prodVta.getValueAt(x, z);
                                } else if(z==3){
                                    subT=(Double) prodVta.getValueAt(x, z);
                                    //System.out.println("Nombre: "+name+"___ Costo: "+cost+"___ Cantidad: "+cant+"___ SubTotal: "+subT);
                                    tablaVenta.setProducto(name);
                                    tablaVenta.setCantidad(cant);
                                    tablaVenta.setSubTotal(String.valueOf(subT));

                                    //this.tarea_venta.guardarProductoVenta(Conexion.obtener(), name, cant, String.valueOf(subT));
                                    this.tarea_venta.guardarProductoVenta2(Conexion.obtener(), tablaVenta);
                                }
                            }
                        }
                            int num = prodVta.getRowCount();
                            for(int i=0;i<num;i++){
                                prodVta.removeRow(0);
                            }
                            JOptionPane.showMessageDialog(this, "Venta realizada con éxito.");
                            GenerarReporte n=new GenerarReporte();
                            n.ticketImagen(usuario);
                            acumtotal=0.00;
                            lblTotal.setText(String.valueOf(acumtotal));
                            i=0;
                    }
                } catch (NullPointerException npe){
                    JOptionPane.showMessageDialog(this, " ERROR, no se han agregado propductos a la venta "+ npe);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro de la venta. Error de Mysql.");
                } catch (ClassNotFoundException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro de la venta. No se encuentra la clase.");
                }
          
        
                    /*
                    System.out.println(recibido);
                    System.out.println(this.isNumeric(recibido));
                    */
            } else {
                JOptionPane.showMessageDialog(this, "La cantidad recibida es menor que el total de la venta.");
            }
            
        
        } else {
            if(recibido!=null)
            JOptionPane.showMessageDialog(this, " Solo debe ingresar números.");
        }
             
        
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        int n=0;
        if(this.isNumeric(txtCantidad.getText())){
            int cantidad = Integer.parseInt(txtCantidad.getText());
            int fila_seleccionada = tblProducto.getSelectedRow();

            if(this.validaProdVta()==true){
                JOptionPane.showMessageDialog(this, "Ese producto ya esta registrado en la venta");
            } else {
            if(fila_seleccionada >= 0){
            try{

                /* Aqui se recupera el id del producto por nombre y el costo, almacenando en la variable n*/
                n=this.tarea_producto.validarProductoNombre(Conexion.obtener(), nombreProducto, costo);

                /*Obtenemos una lista de información para almacenar en this.producto*/
                this.producto = this.tarea_producto.recuperarPorId(Conexion.obtener(), n);
                prodVta = (DefaultTableModel) tblProductoVenta.getModel();
                /* aqui indicamos en que fila se pondrá la informacion por lo que hay un contrador "i" que nos indica
                la fila de la tabla donde se insertara el producto*/
                prodVta.setRowCount(i);
                /* recuperamos la informacion del metodo utilizado previamente*/
                prodVta.addRow(new Object[]{
                        this.producto.get(0).getNombre(),
                        this.producto.get(0).getPrecio(), 
                        cantidad,
                        Double.parseDouble(this.producto.get(0).getPrecio())*cantidad
                    });



            } catch (SQLException ex) {
                //Logger.getLogger(mnuVendedor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ey no te pases de listo_"+ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(mnuVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            /* aqui hay dos acumuladores con "i" indicamos la siguiente fila si se quiere insertar otro producto
            a la tabla. Y con acumtotal almacenamos el total de la venta*/
            acumtotal+=Double.parseDouble(this.producto.get(0).getPrecio())*cantidad;
            i++; 

            lblTotal.setText(String.valueOf(acumtotal));
            txtCantidad.setText("1");
            txtCantidad.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.");
            }

            /*if(n==0){
                 JOptionPane.showMessageDialog(this, "Producto no agregado");
             }*/  
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un valor correcto en la cantidad.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void tblProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoMousePressed
        
        JTable tabla = (JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);
        if (evt.getClickCount() == 1) {
            nombreProducto=(tabla.getValueAt(tabla.getSelectedRow(), 0).toString());
            costo=(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
            txtCantidad.requestFocus();
            
        }
    }//GEN-LAST:event_tblProductoMousePressed

    private void tblProductoVentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductoVentaMousePressed
        try {
            JTable tabla = (JTable) evt.getSource();
            Point punto = evt.getPoint();
            int row = tabla.rowAtPoint(punto);
            costoF=(tabla.getValueAt(tabla.getSelectedRow(), 3).toString());
        } catch (NullPointerException ex) {
            System.out.println("Message: "+ex);
        }
        
        
        
    }//GEN-LAST:event_tblProductoVentaMousePressed

    private void btnEliminardeListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminardeListaActionPerformed
        int fila_seleccionada = tblProductoVenta.getSelectedRow();
        if(fila_seleccionada >= 0){
            if(this.isNumericD(costoF)){
            acumtotal = acumtotal - Double.parseDouble(costoF);
            lblTotal.setText(String.valueOf(acumtotal));
            //System.out.println("Precio: "+costo);
            //System.out.println("Sub Total: "+costoF);
            //System.out.println("Total: "+acumtotal);
            JOptionPane.showMessageDialog(this, "Se ha quitado el producto de la lista de venta.");
            prodVta.removeRow(fila_seleccionada);
            i--;
            } else {
                JOptionPane.showMessageDialog(this, "Esta fila no contiene un producto agregado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.");
        }
        
    }//GEN-LAST:event_btnEliminardeListaActionPerformed

    private void btnBuscarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTipoActionPerformed
        
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
        
    }//GEN-LAST:event_btnBuscarTipoActionPerformed

    private void btnBuscarCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCatActionPerformed
        String categoria = (String) jcbCategoria.getSelectedItem();
        //System.out.println(categoria);
        this.cargar_lista_producto_categoria(categoria);
        
        if(tarea_producto.isF()==false){
            JOptionPane.showMessageDialog(this, "No hay productos de categoria: "+categoria);
            this.cargar_lista_producto();
            
        } 
    }//GEN-LAST:event_btnBuscarCatActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = txtBuscar.getText();
        this.cargar_lista_producto_nombre(nombre);
        if ("".equals(nombre)){
            JOptionPane.showMessageDialog(this, "Debes escribir lo que necesitas buscar.");
        }
        if(tarea_producto.isF()==true){
            JOptionPane.showMessageDialog(this, "Producto encontrado.");
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.");
            this.cargar_lista_producto();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.cargar_lista_producto();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mnuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mnuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mnuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mnuVendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mnuVendedor().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(mnuVendedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarCat;
    private javax.swing.JButton btnBuscarTipo;
    private javax.swing.JButton btnEliminardeLista;
    private javax.swing.JButton btnVender;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JRadioButton jrbExhib;
    private javax.swing.JRadioButton jrbPrep;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCategoria;
    public static javax.swing.JLabel lblEvento;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTotal;
    public static javax.swing.JLabel lblUser;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlAgregar;
    private javax.swing.JPanel pnlVender;
    private javax.swing.JTable tblProducto;
    private javax.swing.JTable tblProductoVenta;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
