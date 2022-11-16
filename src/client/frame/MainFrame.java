package client.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	
	MainPanel mainpanel;
//  프래임 1개에 패널을 바꾸는 방식 (깃허브에서 참고) + 게임프래임은 따로 만들어도 될거같고용..
	public MainFrame() {

		setTitle("끝말잇기 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 이걸 달아놨는데 안꺼져요 어떻게 해야 할지 모르겠어요.. ㅜㅜ 
		setSize(300, 300);
		
		setLocationRelativeTo(null);
		
		mainpanel = new MainPanel(this);
	    getContentPane().add(mainpanel); // main패널 보여주기 
	    
	    setResizable(false);
	    setVisible(true);
	}

	  /*panel 바꾸기*/
	  public void change(JPanel panelName) {

	    getContentPane().removeAll(); // 컨텐트 팬에서 모두 지우고, 
	    getContentPane().add(panelName); // 패넗을 다시 붙이고 보여주는 형식 
	    revalidate(); 
	    repaint();
	  }
	
		/*
		 * public static void main(String[] args) { new MainFrame();
		 * 
		 * }
		 */

}
