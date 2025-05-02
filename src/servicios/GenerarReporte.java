package servicios;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class GenerarReporte {
    
    private final String logo="/Reportes/logo3.png";
    
    public void reporteVentasFecha(Date fecha){
        try {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("src/Reportes/reporteVentaFecha.jasper");
            Map parametro = new HashMap();
            
            parametro.put("fecha", fecha);
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro, Conexion.obtener());
            JasperViewer jv=new JasperViewer(j, false);
            jv.setTitle("Reporte de ventas por fecha");
            jv.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error "+e);
        }
    }
    
    public void reporteVentasAnio(String anio){
        try {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("src/Reportes/reporteVentaAnio.jasper");
            Map parametro = new HashMap();
            
            parametro.put("anio", anio);
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro, Conexion.obtener());
            JasperViewer jv=new JasperViewer(j, false);
            jv.setTitle("Reporte de ventas por año");
            jv.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error "+e);
        }
    }
    
    public void reporteVentasEvento(String evento){
        try {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("src/Reportes/reporteVentaEvento.jasper");
            Map parametro = new HashMap();
            
            parametro.put("evento", evento);
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro, Conexion.obtener());
            JasperViewer jv=new JasperViewer(j, false);
            jv.setTitle("Reporte de ventas por evento");
            jv.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error "+e);
        }
    }
    
    
    public void ticket(){
        try {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("src/Reportes/ticket.jasper");
            Map parametro = new HashMap();
            
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro, Conexion.obtener());
            
            //JasperViewer jv=new JasperViewer(j, false);
            //jv.setTitle("ticket");
            //jv.setVisible(true);
            
            
            //Para imprimir directamente se debe utilizar esto
            JasperPrintManager.printReport(j, true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error "+e);
        }
    }
    
    
    public void ticketImagen(String usuario){
        try {
            JasperReport reporte= (JasperReport) JRLoader.loadObject("src/Reportes/ticket.jasper");
            Map parametro = new HashMap();
            
            parametro.clear();
            
            parametro.put("logo", this.getClass().getResourceAsStream(logo));
            parametro.put("usuario", usuario);
            
            JasperPrint j= JasperFillManager.fillReport(reporte, parametro, Conexion.obtener());
            
            JasperViewer jv=new JasperViewer(j, false);
            jv.setTitle("ticket");
            jv.setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error "+e);
        }
    }
    
}
