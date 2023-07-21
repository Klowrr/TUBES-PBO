
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author Leily
 */
public class menu_item extends javax.swing.JPanel {

    public ArrayList<menu_item> getSubMenu() {
        return subMenu;
    }
    private final ArrayList<menu_item> subMenu = new ArrayList<>();
    
    private ActionListener act;
    /**
     * Creates new form menu_items
     */
    public menu_item(Icon icon, boolean sbm, Icon iconSubmenu, String menuName, ActionListener act, menu_item... subMenu) {
        initComponents();
        lb_icon_menu.setIcon(icon);
        lb_menu_name.setText(menuName);
        lb_icon_submenu.setIcon(iconSubmenu);
        lb_icon_submenu.setVisible(sbm);
        
        if(act!=null){
            this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
        for (int i = 0; i<subMenu.length;i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_menu_name = new javax.swing.JLabel();
        lb_icon_submenu = new javax.swing.JLabel();
        lb_icon_menu = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lb_menu_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_menu_name.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_icon_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_icon_submenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_menu_name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_icon_menu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lb_icon_submenu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(lb_menu_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean showing = false; 

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if(showing){
            hideMenu();
        }else{
            showMenu();
        }
        if(act!=null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_icon_menu;
    private javax.swing.JLabel lb_icon_submenu;
    private javax.swing.JLabel lb_menu_name;
    // End of variables declaration//GEN-END:variables

    private void hideMenu() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i = subMenu.size()-1;i>=0;i--){
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;

            }
        }).start();
    }

    private void showMenu() {
        new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i = 0; i<subMenu.size();i++){
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }
    private void sleep(){
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
}
