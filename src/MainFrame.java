/*
* File: MainFrame.java
* Author: Németh Ottó
* Copyright: 2023.05.26
* Group: Szoft I/2-E
* Date: 2023-05-23
* Github: https://github.com/ottoburg17/
* Licenc: GNU GPL
*/



import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    InputPanel lmPanel;
    InputPanel fnPanel;
    InputPanel nPanel;
    InputPanel TcPanel;
    JPanel buttonPanel;
    JButton calcButton;
    
    public MainFrame() {
        this.initComponent();
        this.addComponent();
        this.handleEvent();
        this.setFrame();
    }
    private void initComponent() {
        this.lmPanel= new InputPanel("Megmunkálthossz (lm):");
        this.fnPanel = new InputPanel("Fodulatonkéntielőtolás(fn):");
        this.nPanel = new InputPanel("Főorsófordulatszám(n):");
        this.buttonPanel = new JPanel();
       this.TcPanel = new InputPanel("Megmunkálási idő(Tc): ");
        this.calcButton = new JButton("Számít");
    }
    private void addComponent() {
        this.add(this.lmPanel);
        this.add(this.fnPanel);
        this.add(this.nPanel);
        this.add(this.buttonPanel);
        this.add(this.TcPanel);
        this.buttonPanel.add(this.calcButton);
    }
    private void handleEvent() {
        this.calcButton.addActionListener( e -> {
            startCalc();
        });
    }
    private void startCalc() {
        String lmStr = this.lmPanel.getValue();
        if(!this.checkInput(lmStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }
        double lm = Double.parseDouble(lmStr);
        String fnStr = this.fnPanel.getValue();
        if(!this.checkInput(fnStr)) {
            JOptionPane.showMessageDialog(this, "Csak számjegy");
            return;
        }        
        double fn = Double.parseDouble(fnStr);
    String nStr = this.nPanel.getValue();
if(!this.checkInput(nStr)) {
    JOptionPane.showMessageDialog(this, "Csak számjegy");
    return;
}        
double n = Double.parseDouble(nStr);
        Double Tc= this.Tc(lm, fn,n);
        this.TcPanel.setValue(Tc.toString());
    }

    public double Tc(double lm, double fn,double n) {
        return lm /(fn*n);
    }

    public boolean checkInput(String input) {
        boolean ok = false;
        if(input.matches("[0-9.]+")) {
            ok = true;
        }
        return ok;
    }

    private void setFrame() {
        this.setLayout(new BoxLayout(
            this.getContentPane(), BoxLayout.PAGE_AXIS)
        );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        this.pack();
        this.setVisible(true);
    }
    
}
