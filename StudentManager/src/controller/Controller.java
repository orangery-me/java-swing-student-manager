package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.MenuView;

public class Controller implements ActionListener{
    private MenuView mv;
    public Controller(MenuView mv){
        this.mv= mv;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String action= e.getActionCommand();
        if (action.equals("Add")){
            JOptionPane.showMessageDialog(mv,"Please fill the student information to add to list"); 
            this.mv.eraseForm();
            this.mv.model.setChoice("Add");
        }
        
        if (action.equals("Save")){
            if (mv.model.getChoice().equals("") || mv.model.getChoice().equals("Add") || mv.model.getChoice().equals("Edit"))
                this.mv.addOrUpdate(this.mv.getDataFromTextField());
        }

        if (action.equals("Edit")) {
            this.mv.model.setChoice("Edit");
            this.mv.getDataFromTable();
        }

        if (action.equals("Cancel"))
            this.mv.eraseForm();

        if (action.equals("Delete")){
            int choice= JOptionPane.showConfirmDialog(mv, "Are you sure you want to delete this row?", "Confirm", 0);
            if (choice == JOptionPane.YES_OPTION){
                this.mv.deleteARow();
            }
        }

        if (action.equals("Filter")){
            this.mv.filter();
        }
        if (action.equals("Undo")){
            this.mv.printList(this.mv.model.getConList());
        }

        if (action.equals("About us")){
            JOptionPane.showMessageDialog(mv, "Phần mềm quản lý thông tin thí sinh 1.0\nLast update: 1/7/2023", "About us", 1);
        }
        if (action.equals("Save As")){
            this.mv.saveFileAction();
        }
        if (action.equals("Open")){
            this.mv.openFileAction();
        }
        if (action.equals("Exit")){
            int choice= JOptionPane.showConfirmDialog(mv, "Are you sure you want to exit", "Confirm", 0);
                if (choice == JOptionPane.YES_OPTION)
                    this.mv.exit();
        }
    }
    
}
