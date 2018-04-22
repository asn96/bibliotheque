
 package Authentification;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author KINGBOURY
 */
	
 
    public class Authentification extends JFrame {
        
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public static void main(String[] args) {

			Authentification name = new Authentification();
		}
    
  
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
  
   public String login="";
   
    Frame[] fra =Authentification.getFrames();
    
    public String password="";
 public Authentification(){
    
    
    
    
       jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(550, 335));
        setResizable(true);
        setVisible(true);
        setTitle("Authentification");
    

        jPanel1.setBackground(new java.awt.Color(153, 51, 0));
        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("LOGIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(190, 140, 50, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("MOT DE PASSE");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 200, 150, 16);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(250, 140, 130, 22);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(250, 200, 130, 22);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Valider");
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 260, 90, 25);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Annuler");
        jPanel1.add(jButton2);
        jButton2.setBounds(270, 260, 100, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("bookshelves-in-library-getty_573x300.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 300);
        
          try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 400);
        
       

         pack();
    
        setLocationRelativeTo(null);
        
        jButton1.addActionListener(new Acces());
        
        jButton2.addActionListener(new Annuler());

    
    }
 
 	static class  Connexion{
 		public static Connection connecter() {
 			Connection c1 = null;
 			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url= "jdbc:mysql://localhost:3306/bibliotheque";
	            
	            String user="root"; 
	            
	            String pass="test";
	            
	            try {
					 c1 =DriverManager.getConnection(url, user, pass);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            System.out.println("Connection bien etablie");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c1;
			
		}
 	}
    
     class Acces implements ActionListener {
           
        

            public void actionPerformed(ActionEvent e){
                
                String h1="";
                
                String h2="";
                    try{
            Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM connection where Identifiant='"+1+"'");
            
            b.first();
            
            h1=b.getString("Login");
            
            h2=b.getString("Password");
        
          
                    }
        catch(Exception ex){
            ex.printStackTrace();
        }
                    
                    if(jTextField1.getText().equals(h1) && jPasswordField1.getText().equals(h2)){
                    
                        setVisible(false);
                        
                        BiblioCare care = new BiblioCare();
                    
                        JOptionPane jop1 = new JOptionPane();
                        JOptionPane.showMessageDialog(null, "Bienvenue", "Acces",JOptionPane.INFORMATION_MESSAGE);
                        jop1.setVisible(true);  
                    
                    
                    
                    }
                    else{
                    
                        JOptionPane jop1 = new JOptionPane();
                        JOptionPane.showMessageDialog(null, "Informations incorrectes", "Erreur",JOptionPane.ERROR_MESSAGE);
                        jop1.setVisible(true);  
                    
                    
                    }
            }
     
     
     }
     
       class Annuler implements ActionListener {
           
        

            public void actionPerformed(ActionEvent e){
                
                setVisible(false);
            }
       
       
       }
       
 public class BiblioCare extends JFrame {
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public JMenuItem j10;
    public JMenuItem j11;
    public JMenuItem j12;
    public JMenuItem j13;
    private javax.swing.JPanel jPanel2;
    public JMenu men;
    public JMenuItem j15;
    public JMenuItem j16;
    
     change ch;
     
     info inf;
     
     add ad;
     
     ouvadd ad1;
     
     info1 inf1;
     
     Ajoupre ad2;
     
     info2 inf2;
     
     info3 inf3;
     
     reservation ref;
     
     info5 ih;

  
    
    public BiblioCare(){
        
          
   
        
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        j15 = new JMenuItem();
        j16 = new JMenuItem();
        j10 = new JMenuItem();
        j11 = new JMenuItem();
        j12=new JMenuItem();
        j13 = new JMenuItem();
        men = new JMenu();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(550, 355));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");
    

        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("bookshelves-in-library-getty_573x300.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 300);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 660, 370);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Compte");

        jMenuItem1.setText("Parametres");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon("home.jpg")); // NOI18N
        jMenuItem2.setText("Deconnection");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Adherent");

        jMenuItem3.setText("Nouveau");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Information");
        jMenu3.add(jMenuItem4);
        
        j10.setText("Supprimer");
        jMenu3.add(j10);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Stock");

        jMenuItem5.setText("Ajouter un Ouvrage");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Stock totale");
        jMenu2.add(jMenuItem6);
        
        j12.setText("Stock disponible");
        jMenu2.add(j12);
        
        j11.setText("Supprimer");
        jMenu2.add(j11);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Prets");

        jMenuItem7.setText("Nouveau");
        jMenu4.add(jMenuItem7);

        jMenuItem8.setText("Information");
        jMenu4.add(jMenuItem8);
        
        j13.setText("supprimer");
        
        jMenu4.add(j13);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Reservation");

        jMenuItem9.setText("Nouvelle");
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("Information");
        jMenu5.add(jMenuItem10);

        jMenuBar1.add(jMenu5);
        
        men.setIcon(new javax.swing.ImageIcon("important.gif"));
        
        j15.setText("Information sur Le logiciel");
        men.add(j15);
        
        j16.setText("Informations sur le devoloppeur");
        men.add(j16);
        
        men.setText("Information");
        jMenuBar1.add(men);

        setJMenuBar(jMenuBar1);

        pack();
        
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        setLocationRelativeTo(null);
      
         jMenuItem1.addActionListener(new parametre());
    
         jMenuItem2.addActionListener(new retour());
         
         jMenuItem3.addActionListener(new Ajou());
         
         jMenuItem4.addActionListener(new inf());
         
         jMenuItem5.addActionListener(new ouv());
         
         j10.addActionListener(new supp());
         
         jMenuItem6.addActionListener(new inf1());
         
         jMenuItem7.addActionListener(new Ajo());
         
         j11.addActionListener(new supp1());
         
         j12.addActionListener(new total());
         
         j13.addActionListener(new supp3());
         
         jMenuItem8.addActionListener(new total2());
         
         jMenuItem9.addActionListener(new Ajou6());
         
         jMenuItem10.addActionListener(new Toute());
         
     //    men.addActionListener(new cou());
         
         j16.addActionListener(new cou());
         
         j15.addActionListener(new cou1());
    
    }
    
     class cou1 implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                descri ri = new descri();
            }

               
     
     }
      class cou implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                conce retu = new conce();
            }

               
     
     }
    
    public class conce extends JFrame {
     private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    
   
    public conce(){
    initComponents();
    
    }
      private void initComponents() {


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(225, 375));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");

       jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        
        jLabel8.setIcon(new javax.swing.ImageIcon("10924743_595462973932115_6869325000350285057_n(2).jpg")); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("NOM: ELHADJI BABACAR DIALLO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Adresse Mail: babacardiallo595@gmail.com");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Telephone: 77 606 39 51");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 210, 340);
        
           try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        pack();
          setLocationRelativeTo(null);
    }// </editor-fold>                        

}
    public class descri extends JFrame{
    
     private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    
    public descri(){
    
    initComponents();
    
    }
    
     private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        setPreferredSize(new java.awt.Dimension(344, 300));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");


        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIBLIOCARE");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Concepteur: ELHADJI BABACAR DIALLO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date de creation: 19 Avril 2018");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Version: Version1.0");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setToolTipText("Description");
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("BIBLIOCARE est un logiciel qui facilite");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 50, 250, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Travail d'un bibliothequaire.");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 80, 200, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Il propose au gerant des fonctionnalites");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 110, 280, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("adequates a son travail quotidient");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 140, 240, 16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 340, 270);

        pack();
        
         setLocationRelativeTo(null);
    }// </editor-fold>                        

    
}

   

    class total2 implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                inf3 = new info3();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(inf3)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem8.setEnabled(false);}
                
                else{jMenuItem8.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
      }
    
    class Toute implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                ih = new info5();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(ih)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem10.setEnabled(false);}
                
                else{jMenuItem10.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
      }
     class Ajou6 implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                ref = new reservation();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(ref)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem9.setEnabled(false);}
                
                else{jMenuItem9.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
      }
    
        class total implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                inf2 = new info2();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(inf2)){
                    
                    s=s+1;
                
                }
                
                if(s==1){j12.setEnabled(false);}
                
                else{j12.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
      }
     class Ajo implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                ad2 = new Ajoupre();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(ad2)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem7.setEnabled(false);}
                
                else{jMenuItem7.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
      }
    
      class ouv implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                ad1 = new ouvadd();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(ad1)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem5.setEnabled(false);}
                
                else{jMenuItem5.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
      }
      
     class inf1 implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                inf1 = new info1();
                       
                
                int s=0;
              
                try{
            
        
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(inf1)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem6.setEnabled(false);}
                
                else{jMenuItem6.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
     }
    
      class inf implements ActionListener {

            public void actionPerformed(ActionEvent e){
                  int s=0;
                 
                
                try{
            
        
                inf = new info();
                
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(inf)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem4.setEnabled(false);}
                
                else{jMenuItem4.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
             
            
            }
      
      
      }
         class supp3 implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant du pret!", "Information !",JOptionPane.QUESTION_MESSAGE);
               
            if(hosp.isEmpty()==true){
                
                try {
                    
                } catch (Exception r) {
                }
            
            }
            else{
                int ph=0;
            try{
            Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM pret WHERE Identifiant='"+hosp+"'");
 
            b.first();
            
            ph=b.getInt("Idl");
            
            
            }catch(Exception loi){}
            
                    try{
                    	Connection c1 = Connexion.connecter();
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM pret WHERE Identifiant='"+hosp+"'");
 
            b.first();
            
            b.updateInt("Etat", 1);
            
            b.updateRow();
            
           }
            catch(Exception ko){}
                    
                                          try{
                                        	  Connection c1 = Connexion.connecter();
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM dispo WHERE Idl='"+ph+"'");
 
            b.first();
            
            int lol=b.getInt("exemplaire");
            
            b.updateInt("exemplaire", (lol+1));
            
            b.updateRow();
            
           }catch(Exception kol){}
            
            
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Suppression effectuee", "Suppression",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);  
            
            
  }
            }         
           
 }
         class supp1 implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant du livre!", "Information !",JOptionPane.QUESTION_MESSAGE);
               
            if(hosp.isEmpty()==true){
                
                try {
                    
                } catch (Exception r) {
                }
            
            }
            else{
            
                    try{
                    	Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            a.executeUpdate("DELETE FROM ouvrage WHERE Identifiant='"+hosp+"'");
            
           }
            catch(Exception ko){}
            
            
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Suppression effectuee", "Suppression",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);  
            
            
  }
            }         
           
 }
      
               class supp implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant de l'adherent!", "Information !",JOptionPane.QUESTION_MESSAGE);
               
            if(hosp.isEmpty()==true){
                
                try {
                    
                } catch (Exception r) {
                }
            
            }
            else{
            
                    try{
                    	Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            a.executeUpdate("DELETE FROM emprunteur WHERE Identifiant='"+hosp+"'");
            
           }
            catch(Exception ko){}
            
            
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Suppression effectuee", "Suppression",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);  
            
            
  }
            }         
           
 }
    
    
         class Ajou implements ActionListener {
             
               public void actionPerformed(ActionEvent e){
                   
                       int s=0;
                 
                
                try{
            
        
                ad = new add();
                
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(ad)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem3.setEnabled(false);}
                
                else{jMenuItem3.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                   
               }
             
         }
    
        class retour implements ActionListener {
           
        
            public void actionPerformed(ActionEvent e){
                
                JOptionPane pg = new JOptionPane();
                
                int option =JOptionPane.showConfirmDialog(null, "Voulez vous vraiment vous deconnectez?","Deconnection",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
               
                if(option == JOptionPane.OK_OPTION){
            
                setVisible(false);
                
                Authentification o = new Authentification();
                
                }
                else{
                
                }
                
            }
       
       
       
            
    }
    
      
   class parametre implements ActionListener {
           
        
            public void actionPerformed(ActionEvent e){
            
                int s=0;
                 
                
                try{
            
        
                ch = new change();
                
                for(int i=0;i<=1000000000;i++){
                
                if(fra[i].equals(ch)){
                    
                    s=s+1;
                
                }
                
                if(s==1){jMenuItem1.setEnabled(false);}
                
                else{jMenuItem1.setEnabled(false);}
                
                
                }
                
              
            }catch(Exception pl){}
                
            }
       
       
       } 

 public class change extends JFrame{
    
  
     private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    public  JButton val = new JButton("Fermer");
    
    public change(){
    
        
          jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
         setPreferredSize(new java.awt.Dimension(558, 430));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");
    

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon("admine1 (1).png")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 20, 200, 180);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LOGIN:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(310, 100, 50, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mot de passe:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(260, 150, 100, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Parametres Compte");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(230, 10, 250, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(370, 100, 80, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("...............");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(370, 140, 70, 22);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Changement ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("LOGIN");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 40, 37, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Mot de passe");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 90, 87, 16);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(140, 40, 150, 22);
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(140, 90, 150, 22);
        
        
        val.setBackground(new java.awt.Color(255, 255, 255));
        
        val.setFont(new java.awt.Font("Tahoma", 1, 13)); 
        
        ImageIcon icon5 = new ImageIcon("retour.jpg"); 
        
        val.setIcon(icon5);
        
        val.setIconTextGap(icon5.getIconWidth());
        
        val.setBounds(160, 130, 120, 25);
        
        jPanel1.add(val);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Appliquer");
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 130, 100, 25);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(220, 210, 300, 170);
        
        String pos="";
        
                            try{
                            	Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            int h=1;
            
            ResultSet b = a.executeQuery("SELECT * FROM connection WHERE Identifiant='"+h+"'");
            
            b.first();
 
            pos=b.getString("Login");
            
           
     
      }catch(Exception er){
          
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,er.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                                     
        
      }
         jLabel5.setText(pos);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 560, 410);
        
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        pack();
        
        setLocationRelativeTo(null);
        
       
         val.addActionListener(new retour());
        
         jButton1.addActionListener(new appliquer());
    
    
    
    }
    
    class retour implements ActionListener {
           
        
            public void actionPerformed(ActionEvent e){
            
                setVisible(false);
                jMenuItem1.setEnabled(true);
                
            }
       
       
       
            
    }
    
           class appliquer implements ActionListener {
           
        
            public void actionPerformed(ActionEvent e){
                
                  
                JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'ancien mot de passw!", "Information !",JOptionPane.QUESTION_MESSAGE);
            
                 String passe="";
                                   try{
                                	   Connection c1 = Connexion.connecter();
            
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM connection WHERE Identifiant='"+1+"'");
            
           b.first();
           
           passe=b.getString("Password");
           
     
      }catch(Exception er){
        
      
      }
                  if(!hosp.equals(passe)){JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Mot de passe incorrecte", "ERROR",JOptionPane.ERROR_MESSAGE);}
                  else{
                          try{
                        	  Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM connection WHERE Identifiant='"+1+"'");
            
          while(b.next()){
 
            b.updateString("Login", jTextField1.getText());
            
            b.updateString("Password", jPasswordField1.getText());
            
            b.updateRow();
        
          }    
           
     
      }catch(Exception er){
        
      }
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"modifications appliquees", "Information",JOptionPane.INFORMATION_MESSAGE);
                                     
                        jLabel5.setText(jTextField1.getText());
            }
       
       jTextField1.setText("");
       
       jPasswordField1.setText("");
       }
           } 
}
  
   
    public class info1 extends JFrame{
         
          
         
          
          
          DefaultTableModel table;
          
          JTable t;
          
          JTextField f32=new JTextField(); 
          
          JLabel l32=new JLabel("Filtrer");
          
          JButton bn1 = new JButton("Fermer");
          
          JButton bn2 = new JButton("Rechercher");
          
          JButton b3 = new JButton("Imprimer");
          
          JButton b4 = new JButton("Modifier");
      
          
          public info1(){
          
         this.setSize(800,600);
       
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        this.setLocationRelativeTo(null);
       
        this.setResizable(true);
       
        this.setVisible(true);
        
        this.setLayout(null);
        
        
        JPanel p32=new JPanel();
        
        l32.setForeground(new java.awt.Color(255, 255, 255));
        
        l32.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setBackground(new java.awt.Color(255,255,255));
         
         bn2.setBackground(new java.awt.Color(255,255,255));
         
        
       
        p32.setLayout(null);
        
    
        p32.setBounds(5, 510, 785, 55);
        
        p32.setBackground(new java.awt.Color(0,102,153));
        
        p32.add(bn1);
        
        
         bn1.setBounds(10, 10, 110, 25);
         
         p32.add(bn2);
         
      
         
         bn2.setBounds(150, 10, 140, 25);
         
         p32.add(b3);
         
         b3.setBounds(330, 10, 140, 25);
         
         p32.add(b4);
         
         b4.setBounds(500, 10, 140, 25);
         b4.setBackground(Color.white);
        
         
         
      //   p32.add(f32);
         
       // f32.setBounds(400, 20, 175, 25);
        
         this.getContentPane().add(p32);
        
      
        t=new JTable();
        
      //  t.removeRowSelectionInterval(0, t.getRowCount()-1);
        
       JScrollPane scroll = new JScrollPane(t);
 
        
       scroll.setBounds(5, 5, 790, 500);
       
       this.getContentPane().add(scroll);
       
       t.setBackground(new java.awt.Color(0, 102, 153));
       
       scroll.setBackground(Color.LIGHT_GRAY);
       
       t.setForeground(new java.awt.Color(255, 255, 255));
       
       t.setFont(new java.awt.Font("Tahoma", 1, 13));
       
        b3.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn2.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b3.setBackground(Color.white);
       
        b4.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b4.setBackground(Color.white);
        
        ImageIcon icon4 = new ImageIcon("retour.jpg"); 
        
        ImageIcon icon6 = new ImageIcon("imprimer1.jpg"); 
        
        b3.setIcon(icon6);
        
        b3.setIconTextGap(icon6.getIconWidth());
        
        bn1.setIcon(icon4);
        
        bn1.setIconTextGap(icon4.getIconWidth());
        
        ImageIcon icon5 = new ImageIcon("rechercher.jpg"); 
        
        bn2.setIcon(icon5);
        
        bn2.setIconTextGap(icon5.getIconWidth());

        
        bn1.addActionListener(new Retour());
        
        bn2.addActionListener(new Rechercher());
        
        b3.addActionListener(new Imprimer());
        
        b4.addActionListener(new Modifier());
        
      
     
        f32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f32KeyReleased(evt);
            }
        });
        
        
       
      CreateColonne();
       
                  try{
                	  Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM ouvrage");
          
           int hg1;
           
           String hg2;
           
           String hg3;
           
           String h1;
           
           int h2;
           
           String h3;
           
        
            
       
            
            while(b.next()){
                    
          hg1=b.getInt("Identifiant");
          
          hg2=b.getString("Titre");
          
          hg3=b.getString("Auteur");
          
          h1=b.getString("Type");
          
          h2=b.getInt("exemplaire");
          
          h3 = b.getString("Date");
         
          ligne(hg1, hg2, hg3, h1, h2, h3);
                
                
               
    
            
      }
        
            
         
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                      int pou = table.getRowCount();
                      JOptionPane jop1 = new JOptionPane();
                      JOptionPane.showMessageDialog(null,"Nombre d'Ouvrage:\t"+pou, "Information",JOptionPane.INFORMATION_MESSAGE);
                      jop1.setVisible(true);
                     
         
                      
                      
          }
          
            class Imprimer implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
                
                MessageFormat hed = new MessageFormat("Liste Des Ouvrages");
                
                 MessageFormat hed1 = new MessageFormat("Page{0, number, integer}");
                try{
                    t.print(JTable.PrintMode.FIT_WIDTH, hed, hed1);
                }
                catch(Exception l){
                    
                    System.out.println("Erreur d'impression");
                }
   
   
            }
   }
            
            class Modifier implements ActionListener {

            public void actionPerformed(ActionEvent e){
                 
                JOptionPane ti = new JOptionPane();
                String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'indice de la ligne modife\n(les lignes commencent par 0) !", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int p=0;
                try {
                    
                    p=Integer.parseInt(hosp);
                    
                } catch (Exception le) {
                }
                
                Object bol1=null, bol2=null, bol3=null, bol4=null, bol5=null, bol6=null;
                
                for(int i=0;i<table.getColumnCount()-1;i++){
                    
                    bol1=table.getValueAt(p, 0);
                    bol2=table.getValueAt(p, 1);
                    bol3=table.getValueAt(p, 2);
                    bol4=table.getValueAt(p, 3);
                    bol5=table.getValueAt(p, 4);
                    bol6=table.getValueAt(p, 5);
            
                 }
               
                                          try{
                                        	  Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM ouvrage WHERE Identifiant='"+bol1+"'");
 
            b.first();
                    
           b.updateObject("Titre", bol2);
           b.updateObject("Auteur", bol3);
           b.updateObject("Type", bol4);
           b.updateObject("exemplaire", bol5);
           b.updateObject("Date", bol6);
           
            b.updateRow();
        
              JOptionPane jop1 = new JOptionPane();
              JOptionPane.showMessageDialog(null,"Modification", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
         
     
      }catch(Exception er){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,er.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                     
      } 
                
            
            }
            
   
   }
          
      class Rechercher implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                int id=0;
                
                String n="";
                
                String p="";
                
                String ag="";
                
                int s=0;
                
                String c="";
                
                String ad="";
                
                String da ="";
            
                 JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant de l'ouvrage!", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int fp=0;
               
                     try{
            Class.forName("com.mysql.jdbc.Driver");
                 try {
                     fp=Integer.parseInt(hosp);
                    
                } catch (Exception elo) {
                }
              
            String url= "jdbc:mysql://localhost:3306/bibliotheque";
            
            String user="root"; 
            
            String pass="test";
            
            Connection c1 =DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connection bien etablie");
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM ouvrage WHERE Identifiant='"+hosp+"'");
            
            
            
            b.first();
            
            id=b.getInt("Identifiant");
            
            n=b.getString("Titre");
            
            p=b.getString("Auteur");
            
            ag=b.getString("Type");
            
            s=b.getInt("exemplaire");
            
            c=b.getString("Date");
            
           
          
            
                     }catch(Exception ex){}
                     
                     if(id==0){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Aucune information", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                     }
                     else{
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Identifiant:\t\t"+id+"\n"+"Titre:\t\t"+n+"\n"+"Auteur:\t\t"+p+"\n"+"Type:\t\t"+ag+"\n"+"Nombre_exemplaire:\t\t"+s+"\nDerniere_Date_d'enregistrement:\t\t"+c, "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                       id=0;
                     }
                     
            }
            
            
      }
      
      public void CreateColonne(){
        
        table=(DefaultTableModel) t.getModel();
        
        
        table.addColumn("IDENTIFIANT");
        table.addColumn("TITRE");
        table.addColumn("AUTEUR");
        table.addColumn("TYPE");
        table.addColumn("NBRE_EXEMPLAIRE");
        table.addColumn("DATE");
      

  
       
        
    }
       public void ligne(int gh1, String gh2, String gh3, String h1,int h2, String h3){
        
        Object[] line ={gh1, gh2, gh3, h1, h2, h3};
        
        table.addRow(line);
    }
       
           
             class Retour implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   jMenuItem6.setEnabled(true);
                  
                 
    
}            
    
       
 
  }
             
              private void f32KeyReleased(java.awt.event.KeyEvent evt) {                                        
        
           
                String h= f32.getText();
               
                filtrer(h);
         
             
    }                                       

    
    
    
    
    public void filtrer(String h){
        
        TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(table);
        t.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(h));
        
    }
  
    
    
          

      
}
 
   
    public class info2 extends JFrame{
         
          
         
          
          
          DefaultTableModel table;
          
          JTable t;
          
          JTextField f32=new JTextField(); 
          
          JLabel l32=new JLabel("Filtrer");
          
          JButton bn1 = new JButton("Fermer");
          
          JButton bn2 = new JButton("Rechercher");
          
          JButton b3 = new JButton("Imprimer");
          
          JButton b4 = new JButton("Modifier");
      
          
          public info2(){
          
         this.setSize(800,600);
       
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        this.setLocationRelativeTo(null);
       
        this.setResizable(true);
       
        this.setVisible(true);
        
        this.setLayout(null);
        
        
        JPanel p32=new JPanel();
        
        l32.setForeground(new java.awt.Color(255, 255, 255));
        
        l32.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setBackground(new java.awt.Color(255,255,255));
         
         bn2.setBackground(new java.awt.Color(255,255,255));
         
        
       
        p32.setLayout(null);
        
    
        p32.setBounds(5, 510, 785, 55);
        
        p32.setBackground(new java.awt.Color(0,102,153));
        
        p32.add(bn1);
        
        
         bn1.setBounds(10, 10, 110, 25);
         
         p32.add(bn2);
         
      
         
         bn2.setBounds(150, 10, 140, 25);
         
         p32.add(b3);
         
         b3.setBounds(330, 10, 140, 25);
         
         p32.add(b4);
      
         
         
      //   p32.add(f32);
         
       // f32.setBounds(400, 20, 175, 25);
        
         this.getContentPane().add(p32);
        
      
        t=new JTable();
        
      //  t.removeRowSelectionInterval(0, t.getRowCount()-1);
        
       JScrollPane scroll = new JScrollPane(t);
 
        
       scroll.setBounds(5, 5, 790, 500);
       
       this.getContentPane().add(scroll);
       
       t.setBackground(new java.awt.Color(0, 102, 153));
       
       scroll.setBackground(Color.LIGHT_GRAY);
       
       t.setForeground(new java.awt.Color(255, 255, 255));
       
       t.setFont(new java.awt.Font("Tahoma", 1, 13));
       
        b3.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn2.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b3.setBackground(Color.white);
       
        b4.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b4.setBackground(Color.white);
        
        ImageIcon icon4 = new ImageIcon("retour.jpg"); 
        
        ImageIcon icon6 = new ImageIcon("imprimer1.jpg"); 
        
        b3.setIcon(icon6);
        
        b3.setIconTextGap(icon6.getIconWidth());
        
        bn1.setIcon(icon4);
        
        bn1.setIconTextGap(icon4.getIconWidth());
        
        ImageIcon icon5 = new ImageIcon("rechercher.jpg"); 
        
        bn2.setIcon(icon5);
        
        bn2.setIconTextGap(icon5.getIconWidth());

        
        bn1.addActionListener(new Retour());
        
        bn2.addActionListener(new Rechercher());
        
        b3.addActionListener(new Imprimer());
        
        b4.addActionListener(new Modifier());
        
      
     
        f32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f32KeyReleased(evt);
            }
        });
        
        
       
      CreateColonne();
       
                  try{
                	  Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM dispo");
          
           int hg1;
           
           String hg2;
           
           String hg3;
           
           String h1;
           
           int h2;
          
           
        
            
       
            
            while(b.next()){
                    
          hg1=b.getInt("Idl");
          
          hg2=b.getString("Titre");
          
          hg3=b.getString("Auteur");
          
          h1=b.getString("Type");
          
          h2=b.getInt("exemplaire");
          
        ;
         
          ligne(hg1, hg2, hg3, h1, h2);
                
                
               
    
            
      }
        
            
         
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                      int pou = table.getRowCount();
                      JOptionPane jop1 = new JOptionPane();
                      JOptionPane.showMessageDialog(null,"Nombre d'Ouvrage disponible:\t"+pou, "Information",JOptionPane.INFORMATION_MESSAGE);
                      jop1.setVisible(true);
                     
         
                      
                      
          }
          
            class Imprimer implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
                
                MessageFormat hed = new MessageFormat("Liste Des Ouvrages");
                
                 MessageFormat hed1 = new MessageFormat("Page{0, number, integer}");
                try{
                    t.print(JTable.PrintMode.FIT_WIDTH, hed, hed1);
                }
                catch(Exception l){
                    
                    System.out.println("Erreur d'impression");
                }
   
   
            }
   }
            
            class Modifier implements ActionListener {

            public void actionPerformed(ActionEvent e){
                 
                JOptionPane ti = new JOptionPane();
                String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'indice de la ligne modife\n(les lignes commencent par 0) !", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int p=0;
                try {
                    
                    p=Integer.parseInt(hosp);
                    
                } catch (Exception le) {
                }
                
                Object bol1=null, bol2=null, bol3=null, bol4=null, bol5=null, bol6=null;
                
                for(int i=0;i<table.getColumnCount()-1;i++){
                    
                    bol1=table.getValueAt(p, 0);
                    bol2=table.getValueAt(p, 1);
                    bol3=table.getValueAt(p, 2);
                    bol4=table.getValueAt(p, 3);
                    bol5=table.getValueAt(p, 4);
                    bol6=table.getValueAt(p, 5);
            
                 }
               
                                          try{
                                        	  Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM ouvrage WHERE Identifiant='"+bol1+"'");
 
            b.first();
                    
           b.updateObject("Titre", bol2);
           b.updateObject("Auteur", bol3);
           b.updateObject("Type", bol4);
           b.updateObject("exemplaire", bol5);
           b.updateObject("Date", bol6);
           
            b.updateRow();
        
              JOptionPane jop1 = new JOptionPane();
              JOptionPane.showMessageDialog(null,"Modification", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
         
     
      }catch(Exception er){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,er.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                     
      } 
                
            
            }
            
   
   }
          
      class Rechercher implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                int id=0;
                
                String n="";
                
                String p="";
                
                String ag="";
                
                int s=0;
                
                String c="";
                
                String ad="";
                
                String da ="";
            
                 JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant de l'ouvrage!", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int fp=0;
               
                     try{
            Class.forName("com.mysql.jdbc.Driver");
                 try {
                     fp=Integer.parseInt(hosp);
                    
                } catch (Exception elo) {
                }
              
            String url= "jdbc:mysql://localhost:3306/bibliotheque";
            
            String user="root"; 
            
            String pass="test";
            
            Connection c1 =DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connection bien etablie");
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM dispo WHERE Idl='"+hosp+"'");
            
            
            
            b.first();
            
            id=b.getInt("Idl");
            
            n=b.getString("Titre");
            
            p=b.getString("Auteur");
            
            ag=b.getString("Type");
            
            s=b.getInt("exemplaire");
            
           
            
           
          
            
                     }catch(Exception ex){}
                     
                     if(id==0){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Aucune information", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                     }
                     else{
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Identifiant:\t\t"+id+"\n"+"Titre:\t\t"+n+"\n"+"Auteur:\t\t"+p+"\n"+"Type:\t\t"+ag+"\n"+"exemplaire_disponible:\t\t"+s, "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                       id=0;
                     }
                     
            }
            
            
      }
      
      public void CreateColonne(){
        
        table=(DefaultTableModel) t.getModel();
        
        
        table.addColumn("IDENTIFIANT");
        table.addColumn("TITRE");
        table.addColumn("AUTEUR");
        table.addColumn("TYPE");
        table.addColumn("NBRE_EXEMPLAIRE");
      
      

  
       
        
    }
       public void ligne(int gh1, String gh2, String gh3, String h1,int h2){
        
        Object[] line ={gh1, gh2, gh3, h1, h2};
        
        table.addRow(line);
    }
       
           
             class Retour implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   j12.setEnabled(true);
                  
                 
    
}            
    
       
 
  }
             
              private void f32KeyReleased(java.awt.event.KeyEvent evt) {                                        
        
           
                String h= f32.getText();
               
                filtrer(h);
         
             
    }                                       

    
    
    
    
    public void filtrer(String h){
        
        TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(table);
        t.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(h));
        
    }
  
    
    
          

      
}
    
    
       public class info3 extends JFrame{
         
          
         
          
          
          DefaultTableModel table;
          
          JTable t;
          
          JTextField f32=new JTextField(); 
          
          JLabel l32=new JLabel("Filtrer");
          
          JButton bn1 = new JButton("Fermer");
          
          JButton bn2 = new JButton("Rechercher");
          
          JButton b3 = new JButton("Imprimer");
          
          JButton b4 = new JButton("Modifier");
      
          
          public info3(){
          
         this.setSize(1200,600);
       
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        this.setLocationRelativeTo(null);
       
        this.setResizable(true);
       
        this.setVisible(true);
        
        this.setLayout(null);
        
        
        JPanel p32=new JPanel();
        
        l32.setForeground(new java.awt.Color(255, 255, 255));
        
        l32.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setBackground(new java.awt.Color(255,255,255));
         
         bn2.setBackground(new java.awt.Color(255,255,255));
         
        
       
        p32.setLayout(null);
        
    
        p32.setBounds(5, 510, 1185, 55);
        
        p32.setBackground(new java.awt.Color(0,102,153));
        
        p32.add(bn1);
        
        
         bn1.setBounds(10, 10, 110, 25);
        
         p32.add(b3);
         
         b3.setBounds(150, 10, 140, 25);
         
      
         
         
        p32.add(f32);
         
       f32.setBounds(300, 10, 175, 25);
        
         this.getContentPane().add(p32);
        
      
        t=new JTable();
        
      //  t.removeRowSelectionInterval(0, t.getRowCount()-1);
        
       JScrollPane scroll = new JScrollPane(t);
 
        
       scroll.setBounds(5, 5, 1185, 500);
       
       this.getContentPane().add(scroll);
       
       t.setBackground(new java.awt.Color(0, 102, 153));
       
       scroll.setBackground(Color.LIGHT_GRAY);
       
       t.setForeground(new java.awt.Color(255, 255, 255));
       
       t.setFont(new java.awt.Font("Tahoma", 1, 13));
       
        b3.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn2.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b3.setBackground(Color.white);
       
        b4.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b4.setBackground(Color.white);
        
        ImageIcon icon4 = new ImageIcon("retour.jpg"); 
        
        ImageIcon icon6 = new ImageIcon("imprimer1.jpg"); 
        
        b3.setIcon(icon6);
        
        b3.setIconTextGap(icon6.getIconWidth());
        
        bn1.setIcon(icon4);
        
        bn1.setIconTextGap(icon4.getIconWidth());
        
        ImageIcon icon5 = new ImageIcon("rechercher.jpg"); 
        
        bn2.setIcon(icon5);
        
        bn2.setIconTextGap(icon5.getIconWidth());

        
        bn1.addActionListener(new Retour());
        
        bn2.addActionListener(new Rechercher());
        
        b3.addActionListener(new Imprimer());
        
        b4.addActionListener(new Modifier());
        
      
     
        f32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f32KeyReleased(evt);
            }
        });
        
        
       
      CreateColonne();
       
                  try{
                	  Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM pret WHERE Etat='"+0+"'");
          
           int h0;
          int h1;
          
          String h2;
          
          int h3;
          
          String h4;  
          
          String h5;
          
          String h6;
          
          String h7;
           
        
            
       
            
            while(b.next()){
                
          h0=b.getInt("IDENTIFIANT");
                    
          h1=b.getInt("Idl");
          
          h2=b.getString("Titre");
          
          h3=b.getInt("Id");
          
          h4=b.getString("Nom");
          
          h5= b.getString("Prenom");
          
          h6=b.getString("Date_emp");
          
          h7=b.getString("Date_retour");
        
         
          ligne(h0, h1, h2, h3, h4, h5, h6, h7);
                
                
               
    
            
      }
        
            
         
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                      int pou = table.getRowCount();
                      JOptionPane jop1 = new JOptionPane();
                      JOptionPane.showMessageDialog(null,"Nombre de prets:\t"+pou, "Information",JOptionPane.INFORMATION_MESSAGE);
                      jop1.setVisible(true);
                     
         
                      
                      
          }
          
            class Imprimer implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
                
                MessageFormat hed = new MessageFormat("Liste Des Ouvrages");
                
                 MessageFormat hed1 = new MessageFormat("Page{0, number, integer}");
                try{
                    t.print(JTable.PrintMode.FIT_WIDTH, hed, hed1);
                }
                catch(Exception l){
                    
                    System.out.println("Erreur d'impression");
                }
   
   
            }
   }
            
            class Modifier implements ActionListener {

            public void actionPerformed(ActionEvent e){
                 
                JOptionPane ti = new JOptionPane();
                String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'indice de la ligne modife\n(les lignes commencent par 0) !", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int p=0;
                try {
                    
                    p=Integer.parseInt(hosp);
                    
                } catch (Exception le) {
                }
                
                Object bol1=null, bol2=null, bol3=null, bol4=null, bol5=null, bol6=null;
                
                for(int i=0;i<table.getColumnCount()-1;i++){
                    
                    bol1=table.getValueAt(p, 0);
                    bol2=table.getValueAt(p, 1);
                    bol3=table.getValueAt(p, 2);
                    bol4=table.getValueAt(p, 3);
                    bol5=table.getValueAt(p, 4);
                    bol6=table.getValueAt(p, 5);
            
                 }
               
                                          try{
                                        	  Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM pret WHERE Identifiant='"+bol1+"'");
 
            b.first();
                    
           b.updateObject("Titre", bol2);
           b.updateObject("Auteur", bol3);
           b.updateObject("Type", bol4);
           b.updateObject("exemplaire", bol5);
           b.updateObject("Date", bol6);
           
            b.updateRow();
        
              JOptionPane jop1 = new JOptionPane();
              JOptionPane.showMessageDialog(null,"Modification", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
         
     
      }catch(Exception er){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,er.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                     
      } 
                
            
            }
            
   
   }
          
      class Rechercher implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                int id=0;
                
                String n="";
                
                String p="";
                
                String ag="";
                
                int s=0;
                
                String c="";
                
                String ad="";
                
                String da ="";
            
                 JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant de l'ouvrage!", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int fp=0;
               
                     try{
            Class.forName("com.mysql.jdbc.Driver");
                 try {
                     fp=Integer.parseInt(hosp);
                    
                } catch (Exception elo) {
                }
              
            String url= "jdbc:mysql://localhost:3306/bibliotheque";
            
            String user="root"; 
            
            String pass="";
            
            Connection c1 =DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connection bien etablie");
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM dispo WHERE Idl='"+hosp+"'");
            
            
            
            b.first();
            
            id=b.getInt("Idl");
            
            n=b.getString("Titre");
            
            p=b.getString("Auteur");
            
            ag=b.getString("Type");
            
            s=b.getInt("exemplaire");
            
           
            
           
          
            
                     }catch(Exception ex){}
                     
                     if(id==0){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Aucune information", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                     }
                     else{
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Identifiant:\t\t"+id+"\n"+"Titre:\t\t"+n+"\n"+"Auteur:\t\t"+p+"\n"+"Type:\t\t"+ag+"\n"+"exemplaire_disponible:\t\t"+s, "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                       id=0;
                     }
                     
            }
            
            
      }
      
      public void CreateColonne(){
        
        table=(DefaultTableModel) t.getModel();
        
        table.addColumn("IDENTIFIANT PRET");
        table.addColumn("IDENTIFIANT_OUVRAGE");
        table.addColumn("TITRE");
        table.addColumn("IDENTIFIANT_ADHERENT");
        table.addColumn("NOM");
        table.addColumn("PRENOM");
        table.addColumn("DATE EMPRUNTE");
        table.addColumn("DATE_RETOUR");
      
      

  
       
        
    }
       public void ligne(int h0, int gh1, String gh2, int gh3, String h1,String h2, String h3, String h4){
        
        Object[] line ={h0, gh1, gh2, gh3, h1, h2, h3, h4};
        
        table.addRow(line);
    }
       
           
             class Retour implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   jMenuItem8.setEnabled(true);
                  
                 
    
}            
    
       
 
  }
             
              private void f32KeyReleased(java.awt.event.KeyEvent evt) {                                        
        
           
                String h= f32.getText();
               
                filtrer(h);
         
             
    }                                       

    
    
    
    
    public void filtrer(String h){
        
        TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(table);
        t.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(h));
        
    }
  
    
    
          

      
}
 

 
     
  
    public class info extends JFrame{
         
          
         
          
          
          DefaultTableModel table;
          
          JTable t;
          
          JTextField f32=new JTextField(); 
          
          JLabel l32=new JLabel("Filtrer");
          
          JButton bn1 = new JButton("Fermer");
          
          JButton bn2 = new JButton("Rechercher");
          
          JButton b3 = new JButton("Imprimer");
          
          JButton b4 = new JButton("Modifier");
      
          
          public info(){
          
         this.setSize(800,600);
       
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        this.setLocationRelativeTo(null);
       
        this.setResizable(true);
       
        this.setVisible(true);
        
        this.setLayout(null);
        
        
        JPanel p32=new JPanel();
        
        l32.setForeground(new java.awt.Color(255, 255, 255));
        
        l32.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setBackground(new java.awt.Color(255,255,255));
         
         bn2.setBackground(new java.awt.Color(255,255,255));
         
        
       
        p32.setLayout(null);
        
    
        p32.setBounds(5, 510, 785, 55);
        
        p32.setBackground(new java.awt.Color(0,102,153));
        
        p32.add(bn1);
        
        
         bn1.setBounds(10, 10, 110, 25);
         
         p32.add(bn2);
         
      
         
         bn2.setBounds(150, 10, 140, 25);
         
         p32.add(b3);
         
         b3.setBounds(330, 10, 140, 25);
         
         p32.add(b4);
         b4.setBounds(500, 10, 140, 25);
           
         b4.setBackground(Color.white);
        
         
        
         
         
      //   p32.add(f32);
         
       // f32.setBounds(400, 20, 175, 25);
        
         this.getContentPane().add(p32);
        
      
        t=new JTable();
        
      //  t.removeRowSelectionInterval(0, t.getRowCount()-1);
        
       JScrollPane scroll = new JScrollPane(t);
 
        
       scroll.setBounds(5, 5, 790, 500);
       
       this.getContentPane().add(scroll);
       
       t.setBackground(new java.awt.Color(0, 102, 153));
       
       scroll.setBackground(Color.LIGHT_GRAY);
       
       t.setForeground(new java.awt.Color(255, 255, 255));
       
       t.setFont(new java.awt.Font("Tahoma", 1, 13));
       
        b3.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn2.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b3.setBackground(Color.white);
       
        b4.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b4.setBackground(Color.white);
        
        ImageIcon icon4 = new ImageIcon("retour.jpg"); 
        
        ImageIcon icon6 = new ImageIcon("imprimer1.jpg"); 
        
        b3.setIcon(icon6);
        
        b3.setIconTextGap(icon6.getIconWidth());
        
        bn1.setIcon(icon4);
        
        bn1.setIconTextGap(icon4.getIconWidth());
        
        ImageIcon icon5 = new ImageIcon("rechercher.jpg"); 
        
        bn2.setIcon(icon5);
        
        bn2.setIconTextGap(icon5.getIconWidth());

        
        bn1.addActionListener(new Retour());
        
        bn2.addActionListener(new Rechercher());
        
        b3.addActionListener(new Imprimer());
        
        b4.addActionListener(new Modifier());
        
      
     
        f32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f32KeyReleased(evt);
            }
        });
        
        
       
      CreateColonne();
       
                  try{
                	  Connection c1 = Connexion.connecter();
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM emprunteur");
          
           int hg1;
           
           String hg2;
           
           String hg3;
           
           String h1;
           
           String h2;
           
           String h3;
           
           String h4;
           
           String h5;
            
       
            
            while(b.next()){
                    
          hg1=b.getInt("IDENTIFIANT");
          
          hg2=b.getString("Nom");
          
          hg3=b.getString("Prenom");
          
          h1=b.getString("Age");
          
          h2 = b.getString("Sexe");
          
          h3 = b.getString("Categorie");
           
          h4 = b.getString("Adresse");
          
          h5 = b.getString("Date_inscription");
          ligne(hg1, hg2, hg3, h1, h2, h3, h4, h5);
                
                
               
    
            
      }
        
            
         
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                      int pou = table.getRowCount();
                      JOptionPane jop1 = new JOptionPane();
                      JOptionPane.showMessageDialog(null,"Nombre d'Adherents:\t"+pou, "Information",JOptionPane.INFORMATION_MESSAGE);
                      jop1.setVisible(true);
                     
          }
                 class Modifier implements ActionListener {

            public void actionPerformed(ActionEvent e){
                 
                JOptionPane ti = new JOptionPane();
                String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'indice de la ligne modife\n(les lignes commencent par 0) !", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int p=0;
                try {
                    
                    p=Integer.parseInt(hosp);
                    
                } catch (Exception le) {
                }
                
                Object bol1=null, bol2=null, bol3=null, bol4=null, bol5=null, bol6=null, bol7=null, bol8=null;
                
                for(int i=0;i<table.getColumnCount()-1;i++){
                    
                    bol1=table.getValueAt(p, 0);
                    bol2=table.getValueAt(p, 1);
                    bol3=table.getValueAt(p, 2);
                    bol4=table.getValueAt(p, 3);
                    bol5=table.getValueAt(p, 4);
                    bol6=table.getValueAt(p, 5);
                    bol7=table.getValueAt(p, 6);
                    bol8=table.getValueAt(p, 7);
            
                 }
                                          try{
                                        	  Connection c1 = Connexion.connecter();          
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM emprunteur WHERE Identifiant='"+bol1+"'");
 
            b.first();
                    
           b.updateObject("Nom", bol2);
           b.updateObject("Prenom", bol3);
           b.updateObject("Age", bol4);
           b.updateObject("Sexe", bol5);
           b.updateObject("Adresse", bol7);
           b.updateObject("Date_inscription", bol8);
           b.updateObject("Categorie", bol6);
           
            b.updateRow();
        
              JOptionPane jop1 = new JOptionPane();
              JOptionPane.showMessageDialog(null,"Modification effectuee", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
         
     
      }catch(Exception er){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,er.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                     
      } 
                
            
            }
            
   
   }
      
          
            class Imprimer implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
                
                MessageFormat hed = new MessageFormat("Liste Des Adherents");
                
                 MessageFormat hed1 = new MessageFormat("Page{0, number, integer}");
                try{
                    t.print(JTable.PrintMode.FIT_WIDTH, hed, hed1);
                }
                catch(Exception l){
                    
                    System.out.println("Erreur d'impression");
                }
   
   
            }
   }
            
          
      class Rechercher implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                int id=0;
                
                String n="";
                
                String p="";
                
                String ag="";
                
                String s="";
                
                String c="";
                
                String ad="";
                
                String da ="";
            
                 JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant de l'adherent!", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int fp=0;
                 try {
                     fp=Integer.parseInt(hosp);
                    
                } catch (Exception elo) {
                }
               
                     try{
                    	 Connection c1 = Connexion.connecter();
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM emprunteur WHERE Identifiant='"+fp+"'");
            
            b.first();
            
            id=b.getInt("Identifiant");
            
            n=b.getString("Nom");
            
            p=b.getString("Prenom");
            
            ag=b.getString("Age");
            
            s=b.getString("Sexe");
            
            c=b.getString("Categorie");
            
            ad=b.getString("Adresse");
            
            da=b.getString("Date_inscription");
            
          
            
                     }catch(Exception ex){}
            
                     if(id==0){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Aucune information", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                     }
                     else{
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Identifiant:\t\t"+id+"\n"+"Nom:\t\t"+n+"\n"+"Prenom:\t\t"+p+"\n"+"Age:\t\t"+ag+"\n"+"Categorie:\t\t"+c+"\nAdresse:\t\t"+ad+"\nDate:"+da, "Information ",JOptionPane.INFORMATION_MESSAGE);
                     
                       id=0;
                     }
                     
            }
            
            
      }
      
      public void CreateColonne(){
        
        table=(DefaultTableModel) t.getModel();
        
        
        table.addColumn("IDENTIFIANT");
        table.addColumn("NOM");
        table.addColumn("PRENOM");
        table.addColumn("AGE");
        table.addColumn("SEXE");
        table.addColumn("CATEGORIE");
        table.addColumn("ADRESSE");
        table.addColumn("DATE");
        

  
       
        
    }
       public void ligne(int gh1, String gh2, String gh3, String h1, String h2, String h3, String h4, String h5){
        
        Object[] line ={gh1, gh2, gh3, h1, h2, h3, h4, h5};
        
        table.addRow(line);
    }
       
           
             class Retour implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   jMenuItem4.setEnabled(true);
                  
                 
    
}            
    
       
 
  }
             
              private void f32KeyReleased(java.awt.event.KeyEvent evt) {                                        
        
           
                String h= f32.getText();
               
                filtrer(h);
         
             
    }                                       

    
    
    
    
    public void filtrer(String h){
        
        TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(table);
        t.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(h));
        
    }
  
    
    
          

      
}
    public class add extends JFrame{
    
   
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    
    public add(){
     jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(634, 640));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");
    


        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("NOM");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(70, 50, 28, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Prenom");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(50, 110, 60, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Age");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(70, 160, 30, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Sexe");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(70, 220, 40, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Adresse");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(50, 280, 60, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Date");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(70, 340, 40, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Categorie");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(40, 390, 70, 16);
        jPanel3.add(jTextField1);
        jTextField1.setBounds(120, 50, 140, 22);

      
        jPanel3.add(jTextField2);
        jTextField2.setBounds(120, 110, 140, 22);

       
        jPanel3.add(jTextField3);
        jTextField3.setBounds(120, 160, 140, 22);
        jPanel3.add(jTextField4);
        jTextField4.setBounds(120, 220, 140, 22);
        jPanel3.add(jTextField5);
        jTextField5.setBounds(120, 280, 140, 22);
        jPanel3.add(jTextField6);
        jTextField6.setBounds(120, 340, 140, 22);
        jPanel3.add(jTextField7);
        jTextField7.setBounds(120, 390, 140, 22);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(50, 80, 550, 470);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("ajouter.jpg")); // NOI18N
        jButton1.setText("Ajouter");
        jPanel2.add(jButton1);
        jButton1.setBounds(200, 570, 120, 25);
        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("retour.jpg")); // NOI18N
        jButton3.setText("Retour");
        jPanel2.add(jButton3);
        jButton3.setBounds(50, 570, 110, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ajout d'un Adherent");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(150, 20, 250, 29);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 630, 620);
        
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        pack();
        
        setLocationRelativeTo(null);
    
    
        jButton1.addActionListener(new Ajouter());
       
        jButton3.addActionListener(new Quitter());
       
     
    }
              class Quitter implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   
                   jMenuItem3.setEnabled(true);
                
}            
    
                  
}
    
    
           class Ajouter implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                                   
     String s1=jTextField1.getText();
     String s2=jTextField2.getText();
     String s3=jTextField3.getText();
     String s4=jTextField4.getText();
     String s5= jTextField5.getText();
     String s6=jTextField6.getText();
     String s7 = jTextField7.getText();
     
           if(jTextField1.getText().isEmpty()==true || jTextField2.getText().isEmpty()==true || jTextField3.getText().isEmpty()==true || jTextField4.getText().isEmpty()==true || jTextField5.getText().isEmpty()==true   || jTextField6.getText().isEmpty()==true || jTextField7.getText().isEmpty()==true ){
 
               
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Veuillez rensigner les champs vides", "Erreur",JOptionPane.ERROR_MESSAGE);
                    jop1.setVisible(true);
           }
           else{
 
     
  
     
                    try{
                        
                    	Connection c1 = Connexion.connecter();
            Statement a = c1.createStatement();
           
            a.executeUpdate("INSERT INTO emprunteur(Nom, Prenom, Age, Sexe, Adresse, Date_inscription, Categorie) VALUES('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"', '"+s6+"', '"+s7+"')");
              
           
           }catch(Exception ex){
            ex.printStackTrace();
           }
                   
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Ajout bien effectue", "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField7.setText("");
                    
                    conf1 co = new conf1();
                    
               
                    
} 
           
}
            
}

  
}
    public class ouvadd extends JFrame {
      private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    
    
    
    public ouvadd(){
    
     initComponents();
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
    }
     private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(568, 580));
        setVisible(true);
        setResizable(true);
        setTitle("BiblioCare");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Titre");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(110, 80, 30, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Auteur");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(100, 130, 60, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Type");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(110, 180, 31, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Examplaire");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(80, 240, 80, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Date");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(110, 300, 31, 16);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(170, 80, 180, 22);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(170, 130, 180, 22);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(170, 180, 180, 22);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(170, 240, 180, 22);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(170, 300, 180, 22);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 80, 490, 410);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ajout des Ouvrages");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 20, 380, 44);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("retour.jpg")); // NOI18N
        jButton1.setText("Fermer");
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 510, 120, 25);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("ajouter.jpg")); // NOI18N
        jButton2.setText("Ajouter");
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 510, 130, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 570, 550);
        
        jButton1.addActionListener(new quit());
        
        jButton2.addActionListener(new Ajouter());
        
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        pack();
        
         setLocationRelativeTo(null);
    }  
           class Ajouter implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                                   
     String s1=jTextField1.getText();
     String s2=jTextField2.getText();
     String s3=jTextField3.getText();
     String s4=jTextField4.getText();
     String s5= jTextField5.getText();
    
     
           if(jTextField1.getText().isEmpty()==true || jTextField2.getText().isEmpty()==true || jTextField3.getText().isEmpty()==true || jTextField4.getText().isEmpty()==true || jTextField5.getText().isEmpty()==true){
 
               
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Veuillez rensigner les champs vides", "Erreur",JOptionPane.ERROR_MESSAGE);
                    jop1.setVisible(true);
           }
           else{
 
               int i=0;
               
               int ou=0;
               
               try {
                   
                   i=Integer.parseInt(s4);
                   
                  
                   
               } catch (Exception fe) {
               }
     
  
     
                    try{
                        
                    	Connection c1 = Connexion.connecter();
         
            PreparedStatement a = c1.prepareStatement("INSERT INTO ouvrage VALUES(?, ?, ?, ?, ?, ?)");
            
            a.setInt(1, 0);
                            
            a.setString(2, jTextField1.getText());
                
            a.setString(3, jTextField2.getText());
                
            a.setString(4, jTextField3.getText());
                 
            a.setInt(5, i);
                
            a.setString(6, jTextField5.getText());
            
            a.executeUpdate();
    
                
           
           }catch(Exception ex){
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, ex.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
           }
                    try{
                    	Connection c1 = Connexion.connecter();
                            int gh=0;

                            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                            ResultSet b = a.executeQuery("SELECT * FROM ouvrage WHERE (Titre='"+jTextField1.getText()+"' AND Auteur='"+jTextField2.getText()+"')");

                            b.first();

                            ou=b.getInt("Identifiant");


                           }catch(Exception lop){}
                    

                    try{
                        
                    	Connection c1 = Connexion.connecter();
         
            PreparedStatement a = c1.prepareStatement("INSERT INTO dispo VALUES(?, ?, ?, ?, ?, ?)");
            
            a.setInt(1, 0);
                            
            a.setInt(2, ou);
                
            a.setString(3, jTextField1.getText());
                
            a.setString(4, jTextField2.getText());
            
            a.setString(5, jTextField3.getText());
                 
            a.setInt(6, i);
                
            a.executeUpdate();
            
             JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Ajout bien effectue", "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
                
           
           }catch(Exception ex){
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, ex.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
           }
                   
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                  
               
                    
} 
           
}
            
}
     
              class quit implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   
                   jMenuItem5.setEnabled(true);
                
              }
          } 

    
}
    public class reservation extends JFrame{
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    
    
    public reservation(){
    
    initComponents();
    
    
    }
      private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(null);
        setPreferredSize(new java.awt.Dimension(614, 640));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Titre");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(180, 140, 30, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Identifiant adherent");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(80, 200, 140, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Nom");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(180, 260, 30, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Prenom");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(160, 310, 60, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Date");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(180, 370, 31, 16);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(230, 90, 160, 22);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(230, 140, 160, 22);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(230, 200, 160, 22);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(230, 260, 160, 22);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(230, 310, 160, 22);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(230, 370, 160, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Identifiant ouvrage");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(80, 90, 140, 16);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 80, 530, 480);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ajout des Reservations");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 300, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Identifiant ouvrage");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 170, 126, 16);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("retour.jpg")); // NOI18N
        jButton1.setText("Fermer");
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 570, 120, 25);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("ajouter.jpg")); // NOI18N
        jButton2.setText("Ajouter");
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 570, 130, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 610);

        pack();
        
          setLocationRelativeTo(null);
          
          
        jButton2.addActionListener(new Ajouter());
       
        jButton1.addActionListener(new Quitter());
    }                       
         class Ajouter implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                                   
     String s1=jTextField1.getText();
     String s2=jTextField2.getText();
     String s3=jTextField3.getText();
     String s4=jTextField4.getText();
     String s5= jTextField5.getText();
     String s6=jTextField6.getText();
    
           if(jTextField1.getText().isEmpty()==true || jTextField2.getText().isEmpty()==true || jTextField3.getText().isEmpty()==true || jTextField4.getText().isEmpty()==true || jTextField5.getText().isEmpty()==true   || jTextField6.getText().isEmpty()==true ){
 
               
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Veuillez rensigner les champs vides", "Erreur",JOptionPane.ERROR_MESSAGE);
                    jop1.setVisible(true);
           }
           else{
 
                int kp=0;
                
                int kl=0;
                
                try {
                   kp=Integer.parseInt(jTextField1.getText());
                   
                   kl=Integer.parseInt(jTextField3.getText());
               } catch (Exception ge) {
               }
  
             try{
                        
            	 Connection c1 = Connexion.connecter();
         
            PreparedStatement a = c1.prepareStatement("INSERT INTO reservation VALUES(?, ?, ?, ?, ?, ?, ?)");
            
            a.setInt(1, 0);
                            
            a.setInt(2, kp);
                
            a.setString(3, jTextField2.getText());
                
            a.setInt(4, kl);
            
            a.setString(5, jTextField4.getText());
                
            a.setString(6, jTextField5.getText());
            
            a.setString(7, jTextField6.getText());
            
            a.executeUpdate();
            
             JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Ajout bien effectue", "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
                
           
           }catch(Exception ex){
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, ex.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
           }
               
                    
} 
           
}
            
}
           class Quitter implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                  jMenuItem9.setEnabled(true);
                   setVisible(false);
                   
                
              }
          }
   
}

    
    public class Ajoupre extends JFrame {
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    
 
    public Ajoupre(){
    
    initComponents();
    
    
    }
    
     private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(640, 640));
        setResizable(true);
        setVisible(true);
        setTitle("BiblioCare");
    

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Identifiant Ouvrage");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(70, 70, 130, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Titre");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(170, 120, 30, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Identifiant Adherent");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 170, 140, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Nom");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(180, 220, 27, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Prenom");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(160, 270, 50, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("date d'emprunte");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(100, 320, 110, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Date de retour");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(110, 370, 100, 16);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(220, 70, 160, 22);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(220, 120, 160, 22);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(220, 170, 160, 22);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(220, 220, 160, 22);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(220, 270, 160, 22);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(220, 320, 160, 22);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(220, 370, 160, 22);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 80, 570, 470);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("retour.jpg")); // NOI18N
        jButton1.setText("Fermer");
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 570, 120, 25);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("ajouter.jpg")); // NOI18N
        jButton2.setText("Ajouter");
        jPanel1.add(jButton2);
        jButton2.setBounds(200, 570, 130, 25);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ajout des Prets");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(190, 30, 200, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 610);

        pack();
        
        jButton1.addActionListener(new quit());
        
        jButton2.addActionListener(new Ajouter());
        
        
         setLocationRelativeTo(null);
     }
           class Ajouter implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
                                   
     String s1=jTextField1.getText();
     String s2=jTextField2.getText();
     String s3=jTextField3.getText();
     String s4=jTextField4.getText();
     String s5= jTextField5.getText();
     String s6=jTextField6.getText();
     String s7=jTextField7.getText();
    
     
           if(jTextField1.getText().isEmpty()==true || jTextField2.getText().isEmpty()==true || jTextField3.getText().isEmpty()==true || jTextField4.getText().isEmpty()==true || jTextField5.getText().isEmpty()==true || jTextField6.getText().isEmpty()==true || jTextField7.getText().isEmpty()==true){
 
               
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Veuillez rensigner les champs vides", "Erreur",JOptionPane.ERROR_MESSAGE);
                    jop1.setVisible(true);
           }
           else{
 
               int i=0;
               
               int h=0;
               
               int nb=0;
               
               try {
                   
                   i=Integer.parseInt(s1);
                   
                   h=Integer.parseInt(s3);
                   
               } catch (Exception fe) {
               }
               
          
                    try{
                        
                    	Connection c1 = Connexion.connecter();
         
            PreparedStatement a = c1.prepareStatement("INSERT INTO pret VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            a.setInt(1, 0);
            
            a.setInt(2, i);
                            
            a.setString(3, jTextField2.getText());
                
            a.setInt(4, h);
                
            a.setString(5, jTextField4.getText());
                
            a.setString(6, jTextField5.getText());
            
            a.setString(7, jTextField6.getText());
            
            a.setString(8, jTextField7.getText());
            
            a.setInt(9, 0);
            
            a.executeUpdate();
            
             JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, "Ajout bien effectue", "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
                
           
           }catch(Exception ex){
                    JOptionPane jop1 = new JOptionPane();
                    JOptionPane.showMessageDialog(null, ex.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                    jop1.setVisible(true);
                    
           }
                             try{
                            	 Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            a.executeUpdate("DELETE FROM reservation WHERE (Idl='"+i+"' AND Id='"+h+"')");
            
           }
            catch(Exception ko){}
                   
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");
                    jTextField6.setText("");
                    jTextField7.setText("");
                  
          
          try{
        	  Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM dispo WHERE Idl='"+i+"'");
 
            b.first();
            
            int kl = b.getInt("exemplaire");
            
            b.updateInt("exemplaire",kl-1 );
            
            b.updateRow();;
            
          }catch(Exception lop){}
          
          
               
   
}
                                    
           
            }            
}
             class quit implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   
                   jMenuItem7.setEnabled(true);
                
              }
          } 

    
}

    public class conf1 extends JFrame {
    
       private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel jLabel10;
    
    

    
    
         public conf1(){
         jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(478, 495));
        setResizable(true);
        setVisible(true);
        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CARTE");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 150, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identifiant");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 80, 110, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nom");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(40, 130, 27, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prenom");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 180, 60, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Age");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(40, 230, 26, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sexe");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 280, 31, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categorie");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 330, 80, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Adresse");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 380, 70, 16);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(210, 80, 150, 22);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(210, 130, 150, 22);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(210, 180, 150, 22);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(210, 230, 150, 22);
        jPanel1.add(jTextField5);
        jTextField5.setBounds(210, 280, 150, 22);
        jPanel1.add(jTextField6);
        jTextField6.setBounds(210, 330, 150, 22);
        jPanel1.add(jTextField7);
        jTextField7.setBounds(210, 380, 150, 22);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 420, 100, 30);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 420, 480, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 420);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Suivant");
        jPanel5.add(jButton1);
        jButton1.setBounds(150, 10, 110, 25);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Retour");
        jPanel5.add(jButton2);
        jButton2.setBounds(10, 10, 100, 25);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 420, 480, 40);
        
              try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        pack();
        
        setLocationRelativeTo(null);
        
        jButton2.addActionListener(new Annuler());
        
        jButton1.addActionListener(new suivant());
    } 
         
         class suivant implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
               
                conf2 conf = new conf2();
                
                conf.setVisible(true);
                 
   
            }
   }

       class Annuler implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
               
                 setVisible(false);
                 
                 
   
            }
   }
                     
     public class conf2 extends JFrame {
    
     private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    JLabel l7;
    
                    
    private javax.swing.JButton jButton1;
   
   
    
   public conf2(){
   
     jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);

        
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(null);
        setPreferredSize(new java.awt.Dimension(503, 515));
        setResizable(true);
        setVisible(false);
        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        
       l1 = new JLabel();
       l2 = new JLabel();
       l3 = new JLabel();
       l4 = new JLabel();
       l5 = new JLabel();
       l6 = new JLabel();
       l7 = new JLabel();
       l1.setFont(new java.awt.Font("Tahoma", 1, 18));
       
       l2.setFont(new java.awt.Font("Tahoma", 1, 18));
       l3.setFont(new java.awt.Font("Tahoma", 1, 18));
       l4.setFont(new java.awt.Font("Tahoma", 1, 18));
       l5.setFont(new java.awt.Font("Tahoma", 1, 18));
       l6.setFont(new java.awt.Font("Tahoma", 1, 18));
       l7.setFont(new java.awt.Font("Tahoma", 1, 18));
       l1.setText(jTextField1.getText());
       
       l2.setText(jTextField2.getText());
       l3.setText(jTextField3.getText());
       l4.setText(jTextField4.getText());
       l5.setText(jTextField5.getText());
       l6.setText(jTextField6.getText());
       l7.setText(jTextField7.getText());
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CARTE");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(160, 20, 160, 22);
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identifiant");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 90, 110, 16);
        jPanel1.add(l1);
        jPanel1.add(l2);
        jPanel1.add(l3);
        jPanel1.add(l4);
        jPanel1.add(l5);
        jPanel1.add(l6);
        jPanel1.add(l7);
        
        l1.setBounds(210, 90, 110, 22);
        l2.setBounds(210, 140, 160, 22);
        l3.setBounds(210, 190, 160, 22);
        l4.setBounds(210, 230, 160, 22);
        l5.setBounds(210, 280, 160, 22);
        l6.setBounds(210, 330, 160, 22);
        l7.setBounds(210, 380, 160, 22);
        
        l1.setForeground(new java.awt.Color(255, 255, 255));
        
        l2.setForeground(new java.awt.Color(255, 255, 255));
        
        l3.setForeground(new java.awt.Color(255, 255, 255));
        
        l4.setForeground(new java.awt.Color(255, 255, 255));
        
        l5.setForeground(new java.awt.Color(255, 255, 255));
        
        l6.setForeground(new java.awt.Color(255, 255, 255));
        
        l7.setForeground(new java.awt.Color(255, 255, 255));
       


        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nom");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 150, 27, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Prenom");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 190, 60, 16);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Age");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 230, 26, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sexe");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 280, 31, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Categorie");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 330, 80, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Adresse");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 380, 60, 16);
        
        
        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setLayout(null);
        jPanel1.add(jPanel4);
        jPanel4.setBounds(480, 20, 20, 420);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(null);
        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 20, 20, 420);

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setLayout(null);
        jPanel1.add(jPanel6);
        jPanel6.setBounds(20, 420, 460, 20);

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setLayout(null);
        jPanel1.add(jPanel7);
        jPanel7.setBounds(0, 0, 500, 20);


        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 440);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Retour");
        jPanel3.add(jButton1);
        jButton1.setBounds(10, 10, 85, 25);

      
        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setText("Imprimer");
        jPanel3.add(jButton2);
        jButton2.setBounds(150, 10, 100, 25);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 440, 500, 40);
        
              try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        pack();
        
        setLocationRelativeTo(null);
        
        jButton1.addActionListener(new tour());
        
        jButton2.addActionListener(new Impression1(jPanel1));
    }// </editor-fold>                        

   
         class tour implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
               
                 setVisible(false);
                 
                 
   
            }
   }
         
         
  public class Impression1 extends JPanel implements Printable, ActionListener{


  public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

    if (page > 0) {
      return NO_SUCH_PAGE;
    }

    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());

    jPanel1.printAll(g);

    return PAGE_EXISTS;
   }

  public void actionPerformed(ActionEvent e) {
      
 
  
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(this);
    boolean ok = job.printDialog();
    if (ok) {
      try {
        job.print();
            
   
      } catch (PrinterException ex) {
     }
    }
    
     setVisible(false);
      
  }

  public Impression1(JPanel f) {
    jPanel1= f;
  }
    
 }
   }
    
    
    
    }
     public class info5 extends JFrame{
         
          
         
          
          
          DefaultTableModel table;
          
          JTable t;
          
          JTextField f32=new JTextField(); 
          
          JLabel l32=new JLabel("Filtrer");
          
          JButton bn1 = new JButton("Fermer");
          
          JButton bn2 = new JButton("Rechercher");
          
          JButton b3 = new JButton("Imprimer");
          
          JButton b4 = new JButton("Modifier");
      
          
          public info5(){
          
         this.setSize(800,600);
       
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        this.setLocationRelativeTo(null);
       
        this.setResizable(true);
       
        this.setVisible(true);
        
        this.setLayout(null);
        
        
        JPanel p32=new JPanel();
        
        l32.setForeground(new java.awt.Color(255, 255, 255));
        
        l32.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setBackground(new java.awt.Color(255,255,255));
         
         bn2.setBackground(new java.awt.Color(255,255,255));
         
        
       
        p32.setLayout(null);
        
    
        p32.setBounds(5, 510, 785, 55);
        
        p32.setBackground(new java.awt.Color(0,102,153));
        
        p32.add(bn1);
        
        
         bn1.setBounds(10, 10, 110, 25);
         
         p32.add(bn2);
         
      
         
         bn2.setBounds(150, 10, 140, 25);
         
         p32.add(b3);
         
         b3.setBounds(330, 10, 140, 25);
        
         
         
      //   p32.add(f32);
         
       // f32.setBounds(400, 20, 175, 25);
        
         this.getContentPane().add(p32);
        
      
        t=new JTable();
        
      //  t.removeRowSelectionInterval(0, t.getRowCount()-1);
        
       JScrollPane scroll = new JScrollPane(t);
 
        
       scroll.setBounds(5, 5, 790, 500);
       
       this.getContentPane().add(scroll);
       
       t.setBackground(new java.awt.Color(0, 102, 153));
       
       scroll.setBackground(Color.LIGHT_GRAY);
       
       t.setForeground(new java.awt.Color(255, 255, 255));
       
       t.setFont(new java.awt.Font("Tahoma", 1, 13));
       
        b3.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn1.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        bn2.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b3.setBackground(Color.white);
       
        b4.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        b4.setBackground(Color.white);
        
        ImageIcon icon4 = new ImageIcon("retour.jpg"); 
        
        ImageIcon icon6 = new ImageIcon("imprimer1.jpg"); 
        
        b3.setIcon(icon6);
        
        b3.setIconTextGap(icon6.getIconWidth());
        
        bn1.setIcon(icon4);
        
        bn1.setIconTextGap(icon4.getIconWidth());
        
        ImageIcon icon5 = new ImageIcon("rechercher.jpg"); 
        
        bn2.setIcon(icon5);
        
        bn2.setIconTextGap(icon5.getIconWidth());

        
        bn1.addActionListener(new Retour());
        
        bn2.addActionListener(new Rechercher());
        
        b3.addActionListener(new Imprimer());
        
        b4.addActionListener(new Modifier());
        
      
     
        f32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                f32KeyReleased(evt);
            }
        });
        
        
       
      CreateColonne();
       
                  try{
                	  Connection c1 = Connexion.connecter();
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM reservation");
        
            int h1;
            
            int h2;
            
            String h3;
            
            int h4;
            
            String h5;
            
            String h6;
            
            String h7;
          
           
        
            
       
            
            while(b.next()){
                    
          h1=b.getInt("Identifiant");
          
          h2=b.getInt("Idl");
          
          h3=b.getString("Titre");
          
          h4=b.getInt("Id");
          
          h5=b.getString("Nom");
          
          h6=b.getString("Prenom");
          
          h7=b.getString("Date");
          
        
         
          ligne(h1, h2, h3, h4, h5, h6, h7);
                
                
               
    
            
      }
        
            
         
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
                      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
                      int pou = table.getRowCount();
                      JOptionPane jop1 = new JOptionPane();
                      JOptionPane.showMessageDialog(null,"Nombre de reservation:\t"+pou, "Information",JOptionPane.INFORMATION_MESSAGE);
                      jop1.setVisible(true);
                     
         
                      
                      
          }
          
            class Imprimer implements ActionListener {
            
       
            public void actionPerformed(ActionEvent e){
                
                MessageFormat hed = new MessageFormat("Liste Des Ouvrages");
                
                 MessageFormat hed1 = new MessageFormat("Page{0, number, integer}");
                try{
                    t.print(JTable.PrintMode.FIT_WIDTH, hed, hed1);
                }
                catch(Exception l){
                    
                    System.out.println("Erreur d'impression");
                }
   
   
            }
   }
            
            class Modifier implements ActionListener {

            public void actionPerformed(ActionEvent e){
                 
                JOptionPane ti = new JOptionPane();
                String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'indice de la ligne modife\n(les lignes commencent par 0) !", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int p=0;
                try {
                    
                    p=Integer.parseInt(hosp);
                    
                } catch (Exception le) {
                }
                
                Object bol1=null, bol2=null, bol3=null, bol4=null, bol5=null, bol6=null;
                
                for(int i=0;i<table.getColumnCount()-1;i++){
                    
                    bol1=table.getValueAt(p, 0);
                    bol2=table.getValueAt(p, 1);
                    bol3=table.getValueAt(p, 2);
                    bol4=table.getValueAt(p, 3);
                    bol5=table.getValueAt(p, 4);
                    bol6=table.getValueAt(p, 5);
            
                 }
               
                                          try{
                                        	  Connection c1 = Connexion.connecter();
            
            int gh=0;
            
            Statement a = c1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet b = a.executeQuery("SELECT * FROM ouvrage WHERE Identifiant='"+bol1+"'");
 
            b.first();
                    
           b.updateObject("Titre", bol2);
           b.updateObject("Auteur", bol3);
           b.updateObject("Type", bol4);
           b.updateObject("exemplaire", bol5);
           b.updateObject("Date", bol6);
           
            b.updateRow();
        
              JOptionPane jop1 = new JOptionPane();
              JOptionPane.showMessageDialog(null,"Modification", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
         
     
      }catch(Exception er){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,er.toString(), "Information",JOptionPane.INFORMATION_MESSAGE);
                     
      } 
                
            
            }
            
   
   }
          
      class Rechercher implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               int h1=0;
               
               int h2=0;
               
               String h3="";
               
               int h4=0;
               
               String h5="";
               
               String h6="";
               
               String h7="";
            
                 JOptionPane ti = new JOptionPane();
                 String hosp = JOptionPane.showInputDialog(null, "Veuillez Entrer l'identifiant de la reservation!", "Information !",JOptionPane.QUESTION_MESSAGE);
                 int fp=0;
               
                     try{
            Class.forName("com.mysql.jdbc.Driver");
                 try {
                     fp=Integer.parseInt(hosp);
                    
                } catch (Exception elo) {
                }
              
            String url= "jdbc:mysql://localhost:3306/bibliotheque";
            
            String user="root"; 
            
            String pass="test";
            
            Connection c1 =DriverManager.getConnection(url, user, pass);
            
            System.out.println("Connection bien etablie");
            
            Statement a = c1.createStatement();
            
            ResultSet b = a.executeQuery("SELECT * FROM reservation WHERE Identifiant='"+hosp+"'");
            
            
            
            b.first();
            
           h1=b.getInt("Identifiant");
           h2=b.getInt("Idl");
           h3=b.getString("Titre");
           h4=b.getInt("Id");
           h5=b.getString("Nom");
           h6=b.getString("Prenom");
           h7=b.getString("Date");
            
           
            
           
          
            
                     }catch(Exception ex){}
                     
                     if(h1==0){
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Aucune information", "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                     }
                     else{
                       JOptionPane jop1 = new JOptionPane();
                       JOptionPane.showMessageDialog(null,"Identifiant:\t\t"+h1+"\n"+"Identifiant Ouvrage:\t\t"+h2+"\n"+"Titre:\t\t"+h3+"\n"+"Identifiant Adherent:\t\t"+h4+"\n"+"Nom:\t\t"+h5+"\nPrenom"+h6+"\nDate"+h7, "Information",JOptionPane.INFORMATION_MESSAGE);
                     
                       h1=0;
                     }
                     
            }
            
            
      }
      
      public void CreateColonne(){
        
        table=(DefaultTableModel) t.getModel();
        
        
        table.addColumn("IDENTIFIANT_RESERVATION");
        table.addColumn("IDENTIFIANT_LIVRE");
        table.addColumn("TITRE");
        table.addColumn("IDENTIFIANT_ADHERENT");
        table.addColumn("NOM");
        table.addColumn("PRENOM");
        table.addColumn("DATE");
      
      

  
       
        
    }
       public void ligne(int h1, int h2, String h3, int h4, String h5, String h6, String h7){
        
        Object[] line ={h1, h2, h3, h4, h5, h6, h7};
        
        table.addRow(line);
    }
       
           
             class Retour implements ActionListener {

            public void actionPerformed(ActionEvent e){
                
               
                   setVisible(false);
                   jMenuItem10.setEnabled(true);
                  
                 
    
}            
    
       
 
  }
             
              private void f32KeyReleased(java.awt.event.KeyEvent evt) {                                        
        
           
                String h= f32.getText();
               
                filtrer(h);
         
             
    }                                       

    
    
    
    
    public void filtrer(String h){
        
        TableRowSorter<DefaultTableModel> tr = new  TableRowSorter<DefaultTableModel>(table);
        t.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(h));
        
    }
  
   
}

}
 
 

    }