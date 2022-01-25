/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManagementSystem;

import Credential.LoginForm;
import DatabaseConnection.DatabaseConnection;
import DatabaseConnection.registerUserCon;
import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.image.ImageObserver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;
import TaskManagementSystem.EditTask;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import TaskManagementSystem.Profile;
import static Credential.LoginForm.userIdField;
import static Credential.LoginForm.isLoggedIn;

/**
 *
 * @author Bisma
 */
public class DashboardMain extends javax.swing.JFrame {

    /**
     * Creates new form ToDoTask
     */
    DefaultTableModel model;
    ImageIcon icon; 
    boolean isEditBtnClicked = false;
    public static String taskId;
    public static Date date1;
    
    // data for the sidebar profile
    int userId = Integer.parseInt(userIdField.getText());
    public static String fullnameSidebar;
    public static String careerSidebar;
    
    private void getTaskDoneTodo(){
        String taskDoneQuery = "SELECT COUNT(`status`) FROM `task_list` WHERE `status`= \"Done\";";
        String taskTodoQuery = "SELECT COUNT(`status`) FROM `task_list` WHERE `status`= \"To Do Task\";";
        
        try{
            ResultSet rs = registerUserCon.getConnection().createStatement().executeQuery(taskTodoQuery);
            ResultSet rset = registerUserCon.getConnection().createStatement().executeQuery(taskDoneQuery);
            if(rs.next()){
                todoCount.setText(rs.getString(1));
            }
            if (rset.next()){
                doneCount.setText(rset.getString(1));
            }
        } catch (Exception e){
            System.out.println(e);
        }
        
        
    }
    
    public void getSidebarProfileData(){
        
        String sql = "SELECT `full_name`, `career` FROM `register_user` WHERE `user_id` = '"+userId+"'";    
        try{
           ResultSet rs = registerUserCon.getConnection().createStatement().executeQuery(sql);
           // store the data in public variable in dashobard
           if(rs.next()){
               fullnameSidebar = rs.getString(1);
               careerSidebar = rs.getString(2);
               
               // set text
               fullname.setText(fullnameSidebar);
               career.setText(careerSidebar);
               greetings.setText("Welcome Back "+ fullnameSidebar + "!");
           }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    public void checkLogin(){
        if (!isLoggedIn){
            JOptionPane.showMessageDialog(null, "Not Logged IN");
            dispose();
        }
    }
    
    
    public void display(){
        int row = dashboardTable.getRowCount();
        for (int a =0; a<row; a++ ){
            model.removeRow(a);
        }
        String username = "root";
        String password = "";
        String sqlQuery = "SELECT * FROM `task_list`";
        try{
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/task_management_java", username, password);
            ResultSet rs = cn.createStatement().executeQuery(sqlQuery);
            while(rs.next()){
                String data [] = {rs.getString(6), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7), rs.getString(1)};
                model.addRow(data);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    public DashboardMain() {
        initComponents();
        setTitle("Dashboard");
        this.setLocationRelativeTo(null);
        
        // sidebar data
        getSidebarProfileData();
        
        
        // variable data
        String [] title = {"Task Category", "Task Name", "Deadline", "Status", "Task Priority", "Description", "task_id"};
        model = new DefaultTableModel(title, 0);
        dashboardTable.setModel(model);
        
        // hide the id column in the table 
        dashboardTable.getColumnModel().getColumn(6).setMinWidth(0);
        dashboardTable.getColumnModel().getColumn(6).setMaxWidth(0);
        dashboardTable.getColumnModel().getColumn(6).setWidth(0);
        
        // dynamically change the username and career in the sidebar
//        fullname.setText(Profile.fullNameValue.getText());
//        career.setText(Profile.careerValue.getText());
        
        
        display();
        
        // Task tod & done count
        getTaskDoneTodo();
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        sidebar = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        todo_menu = new javax.swing.JPanel();
        todo_menu_text = new javax.swing.JLabel();
        todo_menu_icon = new javax.swing.JLabel();
        profile_menu = new javax.swing.JPanel();
        profile_menu_text = new javax.swing.JLabel();
        profile_menu_icon = new javax.swing.JLabel();
        logout_menu = new javax.swing.JPanel();
        logout_menu_text = new javax.swing.JLabel();
        logout_menu_icon = new javax.swing.JLabel();
        pomodoro_menu = new javax.swing.JPanel();
        pomodoro_menu_text = new javax.swing.JLabel();
        pomodoro_menu_icon = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fullname = new javax.swing.JLabel();
        career = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        todoCount = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        doneCount = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dashboardTable = new javax.swing.JTable();
        add_task_btn = new javax.swing.JPanel();
        add_task_btn_text = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setBackground(new java.awt.Color(250, 252, 254));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(241, 242, 247));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(241, 242, 247));

        todo_menu.setBackground(new java.awt.Color(241, 242, 247));
        todo_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        todo_menu.setPreferredSize(new java.awt.Dimension(260, 60));
        todo_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todo_menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                todo_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                todo_menuMouseExited(evt);
            }
        });

        todo_menu_text.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        todo_menu_text.setForeground(new java.awt.Color(153, 153, 153));
        todo_menu_text.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        todo_menu_text.setText("To-Do Task");

        todo_menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/todo.png"))); // NOI18N

        javax.swing.GroupLayout todo_menuLayout = new javax.swing.GroupLayout(todo_menu);
        todo_menu.setLayout(todo_menuLayout);
        todo_menuLayout.setHorizontalGroup(
            todo_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todo_menuLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(todo_menu_icon)
                .addGap(34, 34, 34)
                .addComponent(todo_menu_text, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        todo_menuLayout.setVerticalGroup(
            todo_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todo_menuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(todo_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(todo_menu_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(todo_menu_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(todo_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(todo_menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sidebar.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 260, 60));

        profile_menu.setBackground(new java.awt.Color(241, 242, 247));
        profile_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profile_menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profile_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profile_menuMouseExited(evt);
            }
        });

        profile_menu_text.setBackground(new java.awt.Color(241, 242, 247));
        profile_menu_text.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        profile_menu_text.setForeground(new java.awt.Color(153, 153, 153));
        profile_menu_text.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        profile_menu_text.setText("Profile");

        profile_menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/profile.png"))); // NOI18N

        javax.swing.GroupLayout profile_menuLayout = new javax.swing.GroupLayout(profile_menu);
        profile_menu.setLayout(profile_menuLayout);
        profile_menuLayout.setHorizontalGroup(
            profile_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profile_menuLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(profile_menu_icon)
                .addGap(32, 32, 32)
                .addComponent(profile_menu_text, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        profile_menuLayout.setVerticalGroup(
            profile_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profile_menuLayout.createSequentialGroup()
                .addGroup(profile_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(profile_menuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(profile_menu_text, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, profile_menuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(profile_menu_icon)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        sidebar.add(profile_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 260, 60));

        logout_menu.setBackground(new java.awt.Color(241, 242, 247));
        logout_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout_menu.setPreferredSize(new java.awt.Dimension(260, 60));
        logout_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logout_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logout_menuMouseExited(evt);
            }
        });

        logout_menu_text.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        logout_menu_text.setForeground(new java.awt.Color(153, 153, 153));
        logout_menu_text.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logout_menu_text.setText("Log Out");

        logout_menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/log.png"))); // NOI18N

        javax.swing.GroupLayout logout_menuLayout = new javax.swing.GroupLayout(logout_menu);
        logout_menu.setLayout(logout_menuLayout);
        logout_menuLayout.setHorizontalGroup(
            logout_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_menuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(logout_menu_icon)
                .addGap(40, 40, 40)
                .addComponent(logout_menu_text, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        logout_menuLayout.setVerticalGroup(
            logout_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logout_menuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(logout_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout_menu_icon)
                    .addComponent(logout_menu_text, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        sidebar.add(logout_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 590, 260, 60));

        pomodoro_menu.setBackground(new java.awt.Color(241, 242, 247));
        pomodoro_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pomodoro_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pomodoro_menuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pomodoro_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pomodoro_menuMouseExited(evt);
            }
        });

        pomodoro_menu_text.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pomodoro_menu_text.setForeground(new java.awt.Color(153, 153, 153));
        pomodoro_menu_text.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pomodoro_menu_text.setText("Pomodoro");

        pomodoro_menu_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Pomodoro.png"))); // NOI18N

        javax.swing.GroupLayout pomodoro_menuLayout = new javax.swing.GroupLayout(pomodoro_menu);
        pomodoro_menu.setLayout(pomodoro_menuLayout);
        pomodoro_menuLayout.setHorizontalGroup(
            pomodoro_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pomodoro_menuLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(pomodoro_menu_icon)
                .addGap(28, 28, 28)
                .addComponent(pomodoro_menu_text, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        pomodoro_menuLayout.setVerticalGroup(
            pomodoro_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pomodoro_menuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pomodoro_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pomodoro_menu_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pomodoro_menu_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        sidebar.add(pomodoro_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 260, 60));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/TM.png"))); // NOI18N
        sidebar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(236, 235, 252));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setBackground(new java.awt.Color(236, 235, 252));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(113, 97, 207));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Dashboard");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        sidebar.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 260, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Task Manager");
        sidebar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(251, 251, 251));

        fullname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fullname.setText("Babayaga Harosh");

        career.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        career.setForeground(new java.awt.Color(51, 51, 51));
        career.setText("Project Manager");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/ProfileArrow.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fullname, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addComponent(career, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fullname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(career))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        sidebar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, 80));

        bg.add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 760));

        jPanel2.setBackground(new java.awt.Color(232, 232, 246));
        jPanel2.setLayout(new java.awt.BorderLayout());
        bg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 270, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Dashboard");
        bg.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Ready for work? Setup your task.");
        bg.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 300, -1));

        jPanel10.setBackground(new java.awt.Color(253, 242, 224));

        jLabel22.setBackground(new java.awt.Color(248, 170, 75));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(248, 170, 75));
        jLabel22.setText("To-do");

        todoCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        todoCount.setForeground(new java.awt.Color(248, 170, 75));
        todoCount.setText("20");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(todoCount)
                .addGap(21, 21, 21))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(todoCount, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        bg.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 160, 50));

        jPanel11.setBackground(new java.awt.Color(225, 241, 224));
        jPanel11.setForeground(new java.awt.Color(225, 221, 244));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(91, 199, 79));
        jLabel24.setText("Task Done");

        doneCount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        doneCount.setForeground(new java.awt.Color(91, 199, 79));
        doneCount.setText("3");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(doneCount)
                .addGap(21, 21, 21))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(doneCount, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 30, -1, -1));

        greetings.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        greetings.setText("Welcome Back Babayaga!");
        bg.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 420, -1));

        dashboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Task Category", "Task Name", "Deadline", "Status", "Task Priority", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dashboardTable.setAlignmentX(3.0F);
        dashboardTable.setAlignmentY(3.0F);
        dashboardTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardTable.setRowHeight(60);
        dashboardTable.setRowMargin(3);
        dashboardTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(dashboardTable);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 930, 390));

        add_task_btn.setBackground(new java.awt.Color(236, 235, 252));
        add_task_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_task_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_task_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_task_btnMouseEntered(evt);
            }
        });

        add_task_btn_text.setBackground(new java.awt.Color(113, 97, 207));
        add_task_btn_text.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        add_task_btn_text.setForeground(new java.awt.Color(113, 97, 207));
        add_task_btn_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_task_btn_text.setText("Add Task");

        jLabel62.setBackground(new java.awt.Color(113, 97, 207));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(113, 97, 207));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/add-task.png"))); // NOI18N

        javax.swing.GroupLayout add_task_btnLayout = new javax.swing.GroupLayout(add_task_btn);
        add_task_btn.setLayout(add_task_btnLayout);
        add_task_btnLayout.setHorizontalGroup(
            add_task_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_task_btnLayout.createSequentialGroup()
                .addComponent(add_task_btn_text, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
        );
        add_task_btnLayout.setVerticalGroup(
            add_task_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(add_task_btn_text, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(add_task_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 220, 120, 30));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel63.setText("Task List");
        bg.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        refreshBtn.setBackground(new java.awt.Color(113, 97, 207));
        refreshBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(113, 97, 207));
        refreshBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/refresh-black.png"))); // NOI18N
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshBtnMouseClicked(evt);
            }
        });
        bg.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 220, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 1338, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void todo_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todo_menuMouseEntered
        // TODO add your handling code here:
        todo_menu.setBackground(new Color(236,235,252));
        todo_menu_text.setForeground(new Color(113,97,207));
        icon = new ImageIcon(getClass().getResource("../Icons/To-Do Active.png "));
        todo_menu_icon.setIcon(icon);
        
    }//GEN-LAST:event_todo_menuMouseEntered

    private void todo_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todo_menuMouseExited
        // TODO add your handling code here
        todo_menu.setBackground(new Color(241,242,247));
        todo_menu_text.setForeground(new Color(153,153,153)); 
        icon = new ImageIcon(getClass().getResource("../Icons/todo.png"));
        todo_menu_icon.setIcon(icon);
    }//GEN-LAST:event_todo_menuMouseExited

    private void profile_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_menuMouseEntered
        // TODO add your handling code here:
        profile_menu.setBackground(new Color(236,235,252));
        profile_menu_text.setForeground(new Color(113,97,207));
        icon = new ImageIcon(getClass().getResource("../Icons/profileActive.png "));
        profile_menu_icon.setIcon(icon);
    }//GEN-LAST:event_profile_menuMouseEntered

    private void profile_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_menuMouseExited
        // TODO add your handling code here:
        profile_menu.setBackground(new Color(241,242,247));
        profile_menu_text.setForeground(new Color(153,153,153)); 
        icon = new ImageIcon(getClass().getResource("../Icons/profile.png"));
        profile_menu_icon.setIcon(icon);
    }//GEN-LAST:event_profile_menuMouseExited

    private void pomodoro_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pomodoro_menuMouseEntered
        // TODO add your handling code here:
        pomodoro_menu.setBackground(new Color(236,235,252));
        pomodoro_menu_text.setForeground(new Color(113,97,207));
        icon = new ImageIcon(getClass().getResource("../Icons/pomodoroActive.png"));
        pomodoro_menu_icon.setIcon(icon);
    }//GEN-LAST:event_pomodoro_menuMouseEntered

    private void pomodoro_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pomodoro_menuMouseExited
        // TODO add your handling code here:
        pomodoro_menu.setBackground(new Color(241,242,247));
        pomodoro_menu_text.setForeground(new Color(153,153,153));
        icon = new ImageIcon(getClass().getResource("../Icons/pomodoro.png"));
        pomodoro_menu_icon.setIcon(icon);
    }//GEN-LAST:event_pomodoro_menuMouseExited

    private void logout_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_menuMouseEntered
        // TODO add your handling code here:
        logout_menu.setBackground(new Color(236,235,252));
        logout_menu_text.setForeground(new Color(113,97,207));
        icon = new ImageIcon(getClass().getResource("../Icons/logoutActive.png"));
        logout_menu_icon.setIcon(icon);
    }//GEN-LAST:event_logout_menuMouseEntered

    private void logout_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_menuMouseExited
        // TODO add your handling code here:
        logout_menu.setBackground(new Color(241,242,247));
        logout_menu_text.setForeground(new Color(153,153,153));
        icon = new ImageIcon(getClass().getResource("../Icons/log.png"));
        logout_menu_icon.setIcon(icon);
    }//GEN-LAST:event_logout_menuMouseExited

    private void add_task_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_task_btnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_add_task_btnMouseEntered

    private void todo_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todo_menuMouseClicked
        // Display the todo page
        ToDoTask todoPage = new ToDoTask(); 
        todoPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_todo_menuMouseClicked

    private void profile_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profile_menuMouseClicked
        // Display the profile page
        Profile profilePage = new Profile(); 
        profilePage.setVisible(true);
        dispose();
    }//GEN-LAST:event_profile_menuMouseClicked

    private void pomodoro_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pomodoro_menuMouseClicked
        // Display the pomodoro page
        Pomodoro pomodoroPage = new Pomodoro(); 
        pomodoroPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_pomodoro_menuMouseClicked

    private void logout_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_menuMouseClicked
        // Display the dialog
        int userResponse = JOptionPane.showConfirmDialog(this, "Are you sure want to log out ?", "Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        //if yes redirect into the login page
        if (userResponse == JOptionPane.YES_OPTION){
            System.out.println("Logged Out");
            LoginForm loginPage = new LoginForm(); 
            loginPage.setVisible(true);
            dispose();
        }
        // if no don't logged out the user
        else{
            System.out.println("Logged In");
        }
            
    }//GEN-LAST:event_logout_menuMouseClicked

    private void add_task_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_task_btnMouseClicked
        // Display the add task ui
        AddTask addTaskUi = new AddTask(); 
        addTaskUi.setVisible(true); 
    }//GEN-LAST:event_add_task_btnMouseClicked

    private void dashboardTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTableMouseClicked
   
        // open the info tab
        TaskInfo ti = new TaskInfo();
        ti.setVisible(true);
        
            
    }//GEN-LAST:event_dashboardTableMouseClicked

    private void dashboardTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTableMouseEntered
        // DO NOTHING
    }//GEN-LAST:event_dashboardTableMouseEntered

    private void refreshBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshBtnMouseClicked
        // refresh the page when it's clicked
        DashboardMain dashboardpage = new DashboardMain();
        dashboardpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_refreshBtnMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(DashboardMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_task_btn;
    private javax.swing.JLabel add_task_btn_text;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel career;
    public static javax.swing.JTable dashboardTable;
    private javax.swing.JLabel doneCount;
    private javax.swing.JLabel fullname;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logout_menu;
    private javax.swing.JLabel logout_menu_icon;
    private javax.swing.JLabel logout_menu_text;
    private javax.swing.JPanel pomodoro_menu;
    private javax.swing.JLabel pomodoro_menu_icon;
    private javax.swing.JLabel pomodoro_menu_text;
    private javax.swing.JPanel profile_menu;
    private javax.swing.JLabel profile_menu_icon;
    private javax.swing.JLabel profile_menu_text;
    private javax.swing.JLabel refreshBtn;
    private javax.swing.JPanel sidebar;
    private javax.swing.JLabel todoCount;
    private javax.swing.JPanel todo_menu;
    private javax.swing.JLabel todo_menu_icon;
    private javax.swing.JLabel todo_menu_text;
    // End of variables declaration//GEN-END:variables
}
