
package Modele;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author oussema
 */
public class Principale extends javax.swing.JFrame {

    // importation des bibliotheques important
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Principale() {
        initComponents();
        //verification
        Connect();
        vo();
        TableEnregistrer();
        TableVoitureDisponible();
      
    }
    @SuppressWarnings("unchecked")
    //on va creer une methode pour se connecter a notre base location
    private void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voiture","root","");
            System.out.println("Connecter");
            
        
        } catch (ClassNotFoundException | SQLException e){
            //si il ya une erreur

        }
    } 
    private void vo(){
        try{
            Connect();
            String sql = "select matricule from voiture_enregistrer";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                jComboBox1.addItem(rs.getString("matricule"));
            }
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private boolean verify(String matricule, String nom, String prix) {
    // Vérification du matricule
    boolean is_valid = true;
    matValid13.setText("");
    nomValid13.setText("");
    prixValid13.setText("");
    if (matricule == null || !matricule.matches("[A-Za-z0-9-]+")) {
            matValid13.setText("matricule invalide");
        is_valid=false;
    }
    
    // Vérification du nom
    if (nom == null || !nom.matches("[A-Za-z0-9 ]+")) {
            nomValid13.setText("nom invalide");

        is_valid=false;
    }
    
    // Vérification du prix
    try {
        float prixFloat = Float.parseFloat(prix);
    } catch (NumberFormatException e) {
            prixValid13.setText("prix invalide");

        is_valid=false;
    }
    
    return is_valid;
}

    
    // creon la table d'affichage
    private void TableEnregistrer(){
        String[] voiture = {"Matricule", "Nom voiture", "Prix par jour"};
        String [] vue = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,voiture);
        
        String sql = "select * from voiture_enregistrer";
        try{
            Connect();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                vue[0] = rs.getString("matricule");
                vue[1] = rs.getString("nom");
                vue[2] = rs.getString("prix");
                model.addRow(vue);
            }
            //affichage dans la table
            jtable14.setModel(model);
            //toujours fermer la base de donnee
            con.close();
            
            
        } catch (SQLException e){
        }
    }
    
   
   
    
    private void TableVoitureDisponible(){
        String[] voiture = {"Matricule", "Nom voiture", "Prix voiture/jour"};
        String [] vue = new String[4];
        
        DefaultTableModel model = new DefaultTableModel(null,voiture);
        
        String sql = "select * from voiture_enregistrer";
        try{
            Connect();
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                vue[0] = rs.getString("matricule");
                vue[1] = rs.getString("nom");
                vue[2] = rs.getString("prix");
                model.addRow(vue);
            }
            //affichage dans la table
            jTable2.setModel(model);
            //toujours fermer la base de donnee
            con.close();
            
            
        } catch (SQLException e){
        }
    }
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jtable14 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        txtmatricule13 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtnomvoiture13 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtprix13 = new javax.swing.JTextField();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        matValid13 = new javax.swing.JLabel();
        nomValid13 = new javax.swing.JLabel();
        prixValid13 = new javax.swing.JLabel();
        jButton70 = new javax.swing.JButton();
        jButton71 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jButton72 = new javax.swing.JButton();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jButton75 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AGENCE DE LOCATION DE VOITURE");

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setText("Fermer");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jtable14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtable14.setName("table1"); // NOI18N
        jtable14.setRowHeight(25);
        jtable14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtable1MouseReleased(evt);
            }
        });
        jScrollPane15.setViewportView(jtable14);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 51));
        jLabel41.setText("MATRICULE VOITURES");

        txtmatricule13.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txtmatricule13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmatriculeActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 51));
        jLabel42.setText("NOM VOITURE");

        txtnomvoiture13.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 51));
        jLabel43.setText("PRIX VOITURE");

        txtprix13.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        jButton67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton67.setText("SUPPRIMER");
        jButton67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton68.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton68.setText("ENREGISTRER");
        jButton68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton69.setText("ACTUALISER");
        jButton69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        matValid13.setForeground(new java.awt.Color(255, 0, 0));

        nomValid13.setForeground(new java.awt.Color(255, 0, 0));

        prixValid13.setForeground(new java.awt.Color(255, 0, 0));

        jButton70.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton70.setText("Selectionner");
        jButton70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton71.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton71.setText("Modifier");
        jButton71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(txtmatricule13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(matValid13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton68, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtnomvoiture13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtprix13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nomValid13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(prixValid13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))))
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmatricule13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(matValid13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomValid13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnomvoiture13, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprix13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prixValid13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton68, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton67, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton69, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        jTabbedPane1.addTab("Enregistrement de Voitures", jPanel2);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jTable2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setRowHeight(25);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Voiture Disponibles", jPanel3);

        jPanel17.setBackground(new java.awt.Color(153, 153, 153));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setText("Select Voiture");

        jScrollPane16.setViewportView(jTextPane1);

        jButton72.setText("Ajout");
        jButton72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton72ActionPerformed(evt);
            }
        });

        jButton73.setText("Modifer");
        jButton73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton73ActionPerformed(evt);
            }
        });

        jButton74.setText("Supprimer");

        jButton76.setText("Actualiser");
        jButton76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton76ActionPerformed(evt);
            }
        });

        jButton75.setText("Select");
        jButton75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton75ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton73, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addComponent(jButton72, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton75, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton73, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton74, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89))
        );

        jTabbedPane1.addTab("Etat Voiture", jPanel17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        setSize(new java.awt.Dimension(1010, 503));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        MenuPrincipale pl = new MenuPrincipale();
        this.setVisible(false);
        pl.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Connect();
            pst = con.prepareStatement("UPDATE voiture_enregistrer SET nom = ?, prix = ? WHERE matricule = ?");
            pst.setString(1, txtnomvoiture13.getText());
            pst.setString(2, txtprix13.getText());
            pst.setString(3, txtmatricule13.getText());
            int rowsUpdated = pst.executeUpdate();
            con.close();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "voiture " + txtmatricule13.getText() + " mise à jour");
                TableEnregistrer();
                TableVoitureDisponible();
            } else {
                JOptionPane.showMessageDialog(null, "La voiture " + txtmatricule13.getText() + " n'a pas été trouvée dans la base de données.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectionner = jtable14.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)jtable14.getModel();
        txtmatricule13.setText(model.getValueAt(selectionner, 0).toString());
        txtnomvoiture13.setText(model.getValueAt(selectionner, 1).toString());
        txtprix13.setText(model.getValueAt(selectionner, 2).toString());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txtmatricule13.setText("");
        txtnomvoiture13.setText("");
        txtprix13.setText("");
        matValid13.setText("");
        nomValid13.setText("");
        prixValid13.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            boolean valid=verify(txtmatricule13.getText(),txtnomvoiture13.getText(),txtprix13.getText());
            if (valid){
                Connect();
                pst = con.prepareStatement("insert into voiture_enregistrer(matricule,nom,prix)"+"values(?,?,?)");
                pst.setString(1, txtmatricule13.getText());
                pst.setString(2, txtnomvoiture13.getText());
                pst.setString(3, txtprix13.getText());
                pst.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(null, "voiture "+txtmatricule13.getText()+" ajouter");
                TableEnregistrer();
                TableVoitureDisponible();}
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Connect();
            pst = con.prepareStatement("delete from voiture_enregistrer where matricule=?");
            int id = jtable14.getSelectedRow();
            String select = (String)jtable14.getValueAt(id, 0);
            pst.setString(1, select);
            pst.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, txtmatricule13.getText()+" supprimer");
            TableEnregistrer();
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtmatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmatriculeActionPerformed

    private void jtable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtable1MouseReleased

    }//GEN-LAST:event_jtable1MouseReleased

    private void jButton72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton72ActionPerformed
        try{
            Connect();
            pst = con.prepareStatement("insert into etat(matricule,discription)"+"values(?,?)");
            pst.setString(1, jComboBox1.getSelectedItem().toString());
            pst.setString(2, jTextPane1.getText());
            pst.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "etat "+jComboBox1.getSelectedItem().toString()+" ajouter");
        } catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton72ActionPerformed

    private void jButton75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton75ActionPerformed
                                        
    try {
        Connect();
        String matricule = jComboBox1.getSelectedItem().toString();
        pst = con.prepareStatement("SELECT discription FROM etat WHERE matricule = ?");
        pst.setString(1, matricule);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String description = rs.getString("discription");
            jTextPane1.setText(description);
        } else {
            jTextPane1.setText("");
            JOptionPane.showMessageDialog(null, "Aucune description trouvée pour le matricule sélectionné.");
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }


    }//GEN-LAST:event_jButton75ActionPerformed

    private void jButton76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton76ActionPerformed

        jTextPane1.setText("");
    
    }//GEN-LAST:event_jButton76ActionPerformed

    private void jButton73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton73ActionPerformed
        try {
            Connect();
            pst = con.prepareStatement("UPDATE etat SET discription = ? WHERE matricule = ?");
            pst.setString(1, jTextPane1.getText());
            pst.setString(2, jComboBox1.getSelectedItem().toString());
            int rowsUpdated = pst.executeUpdate();
            con.close();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "État de la voiture " + jComboBox1.getSelectedItem().toString() + " mis à jour");
            } else {
               JOptionPane.showMessageDialog(null, "La voiture " + jComboBox1.getSelectedItem().toString() + " n'a pas été trouvée dans la base de données.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton73ActionPerformed

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
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principale().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable jtable1;
    private javax.swing.JTable jtable10;
    private javax.swing.JTable jtable11;
    private javax.swing.JTable jtable12;
    private javax.swing.JTable jtable13;
    private javax.swing.JTable jtable14;
    private javax.swing.JTable jtable2;
    private javax.swing.JTable jtable3;
    private javax.swing.JTable jtable4;
    private javax.swing.JTable jtable5;
    private javax.swing.JTable jtable6;
    private javax.swing.JTable jtable7;
    private javax.swing.JTable jtable8;
    private javax.swing.JTable jtable9;
    private javax.swing.JLabel matValid;
    private javax.swing.JLabel matValid1;
    private javax.swing.JLabel matValid10;
    private javax.swing.JLabel matValid11;
    private javax.swing.JLabel matValid12;
    private javax.swing.JLabel matValid13;
    private javax.swing.JLabel matValid2;
    private javax.swing.JLabel matValid3;
    private javax.swing.JLabel matValid4;
    private javax.swing.JLabel matValid5;
    private javax.swing.JLabel matValid6;
    private javax.swing.JLabel matValid7;
    private javax.swing.JLabel matValid8;
    private javax.swing.JLabel matValid9;
    private javax.swing.JLabel nomValid;
    private javax.swing.JLabel nomValid1;
    private javax.swing.JLabel nomValid10;
    private javax.swing.JLabel nomValid11;
    private javax.swing.JLabel nomValid12;
    private javax.swing.JLabel nomValid13;
    private javax.swing.JLabel nomValid2;
    private javax.swing.JLabel nomValid3;
    private javax.swing.JLabel nomValid4;
    private javax.swing.JLabel nomValid5;
    private javax.swing.JLabel nomValid6;
    private javax.swing.JLabel nomValid7;
    private javax.swing.JLabel nomValid8;
    private javax.swing.JLabel nomValid9;
    private javax.swing.JLabel prixValid;
    private javax.swing.JLabel prixValid1;
    private javax.swing.JLabel prixValid10;
    private javax.swing.JLabel prixValid11;
    private javax.swing.JLabel prixValid12;
    private javax.swing.JLabel prixValid13;
    private javax.swing.JLabel prixValid2;
    private javax.swing.JLabel prixValid3;
    private javax.swing.JLabel prixValid4;
    private javax.swing.JLabel prixValid5;
    private javax.swing.JLabel prixValid6;
    private javax.swing.JLabel prixValid7;
    private javax.swing.JLabel prixValid8;
    private javax.swing.JLabel prixValid9;
    private javax.swing.JTextField txtmatricule;
    private javax.swing.JTextField txtmatricule1;
    private javax.swing.JTextField txtmatricule10;
    private javax.swing.JTextField txtmatricule11;
    private javax.swing.JTextField txtmatricule12;
    private javax.swing.JTextField txtmatricule13;
    private javax.swing.JTextField txtmatricule2;
    private javax.swing.JTextField txtmatricule3;
    private javax.swing.JTextField txtmatricule4;
    private javax.swing.JTextField txtmatricule5;
    private javax.swing.JTextField txtmatricule6;
    private javax.swing.JTextField txtmatricule7;
    private javax.swing.JTextField txtmatricule8;
    private javax.swing.JTextField txtmatricule9;
    private javax.swing.JTextField txtnomvoiture;
    private javax.swing.JTextField txtnomvoiture1;
    private javax.swing.JTextField txtnomvoiture10;
    private javax.swing.JTextField txtnomvoiture11;
    private javax.swing.JTextField txtnomvoiture12;
    private javax.swing.JTextField txtnomvoiture13;
    private javax.swing.JTextField txtnomvoiture2;
    private javax.swing.JTextField txtnomvoiture3;
    private javax.swing.JTextField txtnomvoiture4;
    private javax.swing.JTextField txtnomvoiture5;
    private javax.swing.JTextField txtnomvoiture6;
    private javax.swing.JTextField txtnomvoiture7;
    private javax.swing.JTextField txtnomvoiture8;
    private javax.swing.JTextField txtnomvoiture9;
    private javax.swing.JTextField txtprix;
    private javax.swing.JTextField txtprix1;
    private javax.swing.JTextField txtprix10;
    private javax.swing.JTextField txtprix11;
    private javax.swing.JTextField txtprix12;
    private javax.swing.JTextField txtprix13;
    private javax.swing.JTextField txtprix2;
    private javax.swing.JTextField txtprix3;
    private javax.swing.JTextField txtprix4;
    private javax.swing.JTextField txtprix5;
    private javax.swing.JTextField txtprix6;
    private javax.swing.JTextField txtprix7;
    private javax.swing.JTextField txtprix8;
    private javax.swing.JTextField txtprix9;
    // End of variables declaration//GEN-END:variables

}