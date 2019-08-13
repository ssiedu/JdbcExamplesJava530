
import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pro
 */
public class IncrementForm extends java.awt.Frame {
    private Connection con;
    private PreparedStatement ps;
    
    public IncrementForm() {
        initComponents();
        setSize(400,400);
        try{
            con=Data.connect();
            String sql="UPDATE EMP SET SAL=SAL+? WHERE ENO=?";
            ps=con.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        t1 = new java.awt.TextField();
        t2 = new java.awt.TextField();
        button1 = new java.awt.Button();
        label3 = new java.awt.Label();
        button2 = new java.awt.Button();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(null);

        label1.setText("ECode");
        add(label1);
        label1.setBounds(70, 60, 70, 30);

        label2.setText("Amount");
        add(label2);
        label2.setBounds(70, 120, 60, 30);
        add(t1);
        t1.setBounds(210, 60, 100, 30);
        add(t2);
        t2.setBounds(210, 120, 100, 30);

        button1.setLabel("Increase");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1);
        button1.setBounds(150, 180, 70, 40);
        add(label3);
        label3.setBounds(60, 280, 290, 40);

        button2.setLabel("Exit");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        add(button2);
        button2.setBounds(150, 230, 70, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        try{
            String s1=t1.getText();//eno
            String s2=t2.getText();//amount
            ps.setInt(1, Integer.parseInt(s2));
            ps.setInt(2, Integer.parseInt(s1));
            int n=ps.executeUpdate();
            if(n==1){
                label3.setText("Salary Increased....");
            }else{
                label3.setText("Give Correct Eno....");
            }
            t1.setText(""); t2.setText("");
            t1.requestFocus();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_button2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncrementForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.TextField t1;
    private java.awt.TextField t2;
    // End of variables declaration//GEN-END:variables
}
