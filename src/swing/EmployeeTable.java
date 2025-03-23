package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BENNET DYANI <bennet.dyani>
 */
public class EmployeeTable extends JFrame implements ActionListener, ItemListener {

    private JPanel eastPanel, westPanel, southPanel, northPanel, centerPanel, topCenterPanel;
    private JComboBox combo;
    private JLabel lblCombo, lblName, lblSurname, lblEmpNum, lblRadio;
    private JTextField txtName, txtSurname, txtEmpNum;
    private JButton btnAdd, btnExit;
    private JRadioButton btnRadio1, btnRadio2;
    private ButtonGroup group;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scroll;
    private String name, surname, empNum, comboInfo, btnRadioInfo, output;
    private FileWriter file;
    private BufferedWriter bfWriter;

    //this is a constructor
    public EmployeeTable() {

        super("GUI project ");

        //here i am institiating the attributes that i declared above with no paremeters
        eastPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        westPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel = new JPanel();
        northPanel = new JPanel();
        centerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topCenterPanel = new JPanel();

        comboInfo = "null";

        //i will set the preferd Size here
        /// westPanel.setPreferredSize(new Dimension (, 50));
        // eastPanel.setPreferredSize( new Dimension (150,50));
        //this is my string array to store the values that should be stored inside the comboBox
        String[] departments = {"None", "Graphic Design", "Information Technology", "Business Economics", "Data Analyst"};
        combo = new JComboBox(departments);//this stores the array

        lblCombo = new JLabel("Department: ");
        lblName = new JLabel("Name: ");
        lblSurname = new JLabel("Surname: ");
        lblEmpNum = new JLabel("Employee No:");
        lblRadio = new JLabel("Employee Type: ");

        txtName = new JTextField();
        txtSurname = new JTextField();
        txtEmpNum = new JTextField();

        //these are the values of the radio buttons
        btnRadio1 = new JRadioButton("Permenent");
        btnRadio2 = new JRadioButton("Temporary");
        group = new ButtonGroup();

        btnAdd = new JButton("Add");
        btnExit = new JButton("Exit");
        //i will add the preferd size here if necesarry

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        scroll = new JScrollPane(table);

        name = txtName.getText();
        surname = txtSurname.getText();
        empNum = txtEmpNum.getText();

    }

    //now i am setting a class that does nothig butb set values of the above constructor, just like a Setter methods in OOP
    public void setGUI() {
        group.add(btnRadio1);
        group.add(btnRadio2);
        
        tableModel.addColumn("Department");
        tableModel.addColumn("Name");
        tableModel.addColumn("Surname");
        tableModel.addColumn("Employee No");
        tableModel.addColumn("Employee Type");
        add(scroll);

        topCenterPanel.setLayout(new GridLayout(1, 2));

        topCenterPanel.add(btnRadio1);
        topCenterPanel.add(btnRadio2);

        westPanel.setLayout(new GridLayout(10, 10));
        westPanel.add(lblCombo);
        westPanel.add(lblName);
        westPanel.add(lblSurname);
        westPanel.add(lblEmpNum);
        westPanel.add(lblRadio);
        this.add(westPanel, BorderLayout.WEST);
//        
        centerPanel.setLayout(new GridLayout(10, 10));
        centerPanel.add(combo);
        centerPanel.add(txtName);
        centerPanel.add(txtSurname);
        centerPanel.add(txtEmpNum);
        centerPanel.add(topCenterPanel);
        centerPanel.add(topCenterPanel);
        
        // eastPanel.add(topCenterPanel);
        this.add(centerPanel, BorderLayout.CENTER);

        

        southPanel.setLayout(new GridLayout(1, 2));
        
        southPanel.add(btnAdd);
        southPanel.add(btnExit);
        this.add(southPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(this);
        btnExit.addActionListener(this);

        combo.addItemListener(this);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getStateChange() == ItemEvent.SELECTED) {
            comboInfo = (String) combo.getSelectedItem();

        }

    }

    @Override

    public void actionPerformed(ActionEvent selectedItem) {
        if (selectedItem.getSource().equals(btnAdd)) {
            if (btnRadio1.isSelected()) {
                btnRadioInfo = btnRadio1.getText();
            } else if (btnRadio2.isSelected()) {
                btnRadioInfo = btnRadio2.getText();

            }

            name = txtName.getText();
            surname = txtSurname.getText();
            empNum = txtEmpNum.getText();

            tableModel.addRow(new Object[]{comboInfo, name, surname, empNum, btnRadioInfo});
            Employee emp = new Employee(comboInfo, name, surname, empNum, btnRadioInfo);
            emp.fileWritter(emp.toString());
            combo.setSelectedItem("");
            txtName.setText("");
            txtSurname.setText("");
            txtEmpNum.setText("");
            group.clearSelection();
        } else if (selectedItem.getActionCommand().equals("EXIT")) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter valid values!!");
        }

    }

}
