package cristopher_flores_chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Alex
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    public Cliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msg_c = new javax.swing.JTextField();
        enviar_c = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chat_c = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(msg_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 410, 30));

        enviar_c.setText("Enviar");
        enviar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviar_cActionPerformed(evt);
            }
        });
        getContentPane().add(enviar_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 110, 30));

        chat_c.setColumns(20);
        chat_c.setRows(5);
        jScrollPane1.setViewportView(chat_c);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviar_cActionPerformed
        try{
            String msgout="";
            msgout=msg_c.getText().trim();
            dout.writeUTF(msgout);
        }catch (IOException e){
            
        }
    }//GEN-LAST:event_enviar_cActionPerformed

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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
        try{
            s=new Socket("127.0.0.1",1201);
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream()); 
            String msgin="";
            while (!msgin.equals("exit")){
                msgin=din.readUTF();
                chat_c.setText(chat_c.getText().trim()+"\n Server\t"+msgin);
            }
        }catch (IOException e){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea chat_c;
    private javax.swing.JButton enviar_c;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField msg_c;
    // End of variables declaration//GEN-END:variables
}
