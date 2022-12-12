package Gameroom.Client;

import Gameroom.Client.controller.Controller;
import Gameroom.Client.model.ClientModel;
import Gameroom.Client.view.LobbyPanel;
import Gameroom.Client.view.LoginPanel;
import Gameroom.Client.view.MainFrame;
import Gameroom.Client.view.MainPanel;
import Gameroom.Client.view.MakeGamePanel;
import Gameroom.Client.view.RegisterPanel;
import Gameroom.Client.view.UserInfoFrame;

public class ClientMain {

	public static void main(String[] args) {
		ClientModel model = new ClientModel();
		MainFrame mainFrame = new MainFrame(); // 메인 프레임
		LoginPanel loginPanel = new LoginPanel(); // 로그인 패널
		RegisterPanel ragisterPanel = new RegisterPanel();
		LobbyPanel lobbyPanel = new LobbyPanel(); // 로비 패널
		MainPanel mainPanel = new MainPanel(); // 메인 패널
		MakeGamePanel makeGamePanel = new MakeGamePanel(); // 게임방 생성 패널
		UserInfoFrame userInfoFrame = new UserInfoFrame(); // 유저 정보 패널
		Controller controller = new Controller(mainFrame,loginPanel,ragisterPanel,lobbyPanel,mainPanel,makeGamePanel,userInfoFrame,model);
		
	}
}
