import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Connectivity extends JFrame {
    JLabel lblID,lblName,lblAddress;
    JTextField txtID,txtName,txtAddress;
    JButton btnSave,btnUpdate,btnDelete,btnClear,btnSelect;
    Manager db = new Manager();

    Connectivity() {
        setLayout(new GridLayout(6,2));
        setSize(340, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblID = new JLabel("Enter ID");
        lblName = new JLabel("Enter Name");
        lblAddress = new JLabel("Enter Address");

        txtID = new JTextField(12);
        txtName = new JTextField(12);
        txtAddress = new JTextField(12);

        btnClear = new JButton("Clear");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");
        btnSave = new JButton("Save");
        btnSelect = new JButton("Select");

        add(lblID);
        add(txtID);
        add(lblName);
        add(txtName);
        add(lblAddress);
        add(txtAddress);

        add(btnSave);
        add(btnDelete);
        add(btnUpdate);
        add(btnClear);
        add(btnSelect);

        pack();

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query="insert into login values('"+txtID.getText()+"','"+txtName.getText()+"','"+txtAddress.getText()+"')";
                db.insertUpdateDelete(query);
                JOptionPane.showMessageDialog(Connectivity.this, "Data Saved Sucessfully");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query="delete from login where id='"+txtID.getText()+"'";
                db.insertUpdateDelete(query);
                JOptionPane.showMessageDialog(Connectivity.this, "Data Deleted Sucessfully");
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query="update login set name='"+txtName.getText()+"',address='"+txtAddress.getText()+"' where id='"+txtID.getText()+"'";
                db.insertUpdateDelete(query);
                JOptionPane.showMessageDialog(Connectivity.this, "Data Updated Sucessfully");
            }
        });

        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT TOP 10 * FROM login";
                ResultSet res = db.select(query);

                try {
                    while (res.next()) {
                        String name = res.getString("name");
                        String address = res.getString("address");
                        System.out.println("   "+name+" "+address);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtAddress.setText("");
                txtID.setText("");
                txtName.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new Connectivity();
    }
}
