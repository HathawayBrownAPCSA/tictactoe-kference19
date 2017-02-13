import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.*;

public class TicTacToe extends JPanel
{
  JButton buttons[] [] = new JButton[3] [3]; 
    int alternate = 0;//if this number is a even, then put a X. If it's odd, then put an O
    
    public TicTacToe()
    {
      setLayout(new GridLayout(3,3));
      initializebuttons(); 
    }
    
    public void initializebuttons()
    {
        for(int r = 0; r <= 3; r++)
        {
          for (int c=0; c<3; c++)
            buttons[r][c] = new JButton();
            buttons[r][c].setText("");
            buttons[r][c].addActionListener(new buttonListener());
            buttons[r][c].setFont(new Font("Arial", Font.BOLD, 70));
            
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
                                //because this whole class is a JPanel already           
        }
    }
}
    public void resetButtons()
    {
        for(int r = 0; r <= 3; r++)
        {
          (int c=0; c<3; c++)
            buttons[r][c].setText("");
        }
    }
   
// when a button is clicked, it generates an ActionEvent. Thus, each button needs an ActionListener. When it is clicked, it goes to this listener class that I have created and goes to the actionPerformed method. There (and in this class), we decide what we want to do.
    private class buttonListener implements ActionListener
    {
       
        public void actionPerformed(ActionEvent e) 
        {
            
            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if (buttonClicked.getText ().length() > 0)
               JOptionPane.showConfirmDialog(null,
                   "You cant do that!!", "You dufus!", JOptionPane.DEFAULT_OPTION);
            if(alternate%2 == 0)
                buttonClicked.setText("X");
            else
                buttonClicked.setText("O");
            
            if(checkForWin() == true)
            {
                int input = JOptionPane.showConfirmDialog(null,
                   "Game Over", "ok!", JOptionPane.DEFAULT_OPTION);
                       
                resetButtons();
            }
                
            alternate++;
            
        }
        
        public boolean checkForWin()
        {
            /**   Reference: the button array is arranged like this as the board
             *      0 | 1 | 2
             *      3 | 4 | 5
             *      6 | 7 | 8
             */
            //horizontal win check
            if( checkAdjacent(0,1) && checkAdjacent(1,2) ) //no need to put " == true" because the default check is for true
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
            
            //vertical win check
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            
            //diagonal win check
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
            
            
        }
        
        public boolean checkThree(String s1, String s2, String s3)
        {
            if (s1.equals(s2) && s1.equals(s3) && s1.length() >0)
                return true;
            else
                return false;
        }
        
    }
    
    public static void main(String[] args) 
    {
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
    