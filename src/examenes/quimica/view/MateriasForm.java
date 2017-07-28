/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes.quimica.view;

import examenes.quimica.db.MateriasDAO;
import examenes.quimica.excepciones.ExaQException;
import examenes.quimica.modelo.Materia;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class MateriasForm extends FormBase {
    private static final long serialVersionUID = 8665258952930841555L;
    
    private MateriasDAO materiasDAO;
    private int idMatSelected;

    /**
     * Creates new form MateriasForm
     */
    public MateriasForm() {
        initComponents();
        materiasDAO = new MateriasDAO();
        limpiarTabla(tblMaterias);
        List<Materia> materias = materiasDAO.buscar("");
        llenarTabla(materias);
        lblEditando.setVisible(false);
    }
    
    private void llenarTabla(List<Materia> materias) {
        if (materias != null && !materias.isEmpty()) {
            DefaultTableModel modelo = (DefaultTableModel) tblMaterias.getModel();
            for (Materia mat : materias) {
                modelo.addRow(new Object[]{mat.getId(), mat.getNombre()});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        lblEditando = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Materias");

        jLabel1.setText("Nombre:");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarForma(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMaterias(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMateria(evt);
            }
        });

        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Materia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarRegistro(evt);
            }
        });
        jScrollPane1.setViewportView(tblMaterias);
        if (tblMaterias.getColumnModel().getColumnCount() > 0) {
            tblMaterias.getColumnModel().getColumn(0).setResizable(false);
            tblMaterias.getColumnModel().getColumn(1).setResizable(false);
        }

        lblEditando.setForeground(new java.awt.Color(255, 0, 51));
        lblEditando.setText("EDITANDO....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEditando, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnBuscar)
                    .addComponent(btnGuardar)
                    .addComponent(lblEditando))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarForma(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarForma
        txtNombre.setText(null);
        lblEditando.setVisible(false);
        limpiarTabla(tblMaterias);
    }//GEN-LAST:event_limpiarForma

    private void buscarMaterias(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMaterias
        List<Materia> materias = materiasDAO.buscar(txtNombre.getText() != null ? txtNombre.getText() : "");
        if (materias != null && !materias.isEmpty()) {
            llenarTabla(materias);
        } else {
            limpiarTabla(tblMaterias);
            agregarMensajeError("No se encontraron resultados");
        }
    }//GEN-LAST:event_buscarMaterias

    private void guardarMateria(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarMateria
        if (txtNombre.getText() == null || txtNombre.getText().isEmpty()) {
            agregarMensajeError("El nombre de la materia es requerido");
            return;
        }
        try {
            if (lblEditando.isVisible()) {
                materiasDAO.actualizar(new Materia(idMatSelected, txtNombre.getText()));
                agregarMensajeExito("Se actualizó correctamente la materia");
            } else {
                materiasDAO.guardar(txtNombre.getText());
                agregarMensajeExito("Se guardó correctamente la materia");
            }
            limpiarForma(evt);
            buscarMaterias(evt);
        } catch (ExaQException ex) {
                agregarMensajeError(ex.getMessage());
            }
    }//GEN-LAST:event_guardarMateria

    private void seleccionarRegistro(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarRegistro
        DefaultTableModel model = (DefaultTableModel) tblMaterias.getModel();
        idMatSelected = (Integer) model.getValueAt(tblMaterias.getSelectedRow(), 0);
        if (idMatSelected > 0) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Desea editar los datos de la materia?", 
                    "Advertencia", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                lblEditando.setVisible(true);
                txtNombre.setText((String) model.getValueAt(tblMaterias.getSelectedRow(), 1));
            }
        }
    }//GEN-LAST:event_seleccionarRegistro


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEditando;
    private javax.swing.JTable tblMaterias;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
