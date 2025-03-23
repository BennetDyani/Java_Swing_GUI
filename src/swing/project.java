
package swing;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author BENNET DYANI <bennet.dyani>
 */
public class project {

    
    public static void main(String[] args) {
        
        EmployeeTable table= new EmployeeTable();
        
        table.pack();
        table.setSize(400, 600 );
        table.setVisible(true);
        table.setDefaultCloseOperation(EXIT_ON_CLOSE);
        table.setGUI();
    }
    
}
