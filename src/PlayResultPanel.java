import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PlayResultPanel extends JPanel {

	private UserRankingFrame userRankingFrame;
	private ProfileAndScorePanel profileAndSocorePanel;
	private Font defaultFont = new Font("Jokerman", Font.BOLD, 15); // 기본 폰트 설정
	private LineBorder defaultLineBorder = new LineBorder(Color.WHITE, 5);
	
	
	private JLabel gameResultTextLabel = new JLabel(" ★ Game Result ★ ");
	private JLabel nameTextLabel = new JLabel(GameManagement.name);
	private JLabel profileImageLabel = new JLabel(GameManagement.profileImage);
	private JLabel difficultyLabel = new JLabel(GameManagement.difficulty + " mode");
	private JLabel scoreLabel;
	private JButton exitButton = new JButton("Exit");
	
	public PlayResultPanel(UserRankingFrame userRankingFrame, ProfileAndScorePanel profileAndScorePanel) {
		
		this.profileAndSocorePanel = profileAndScorePanel;
		this.userRankingFrame =  userRankingFrame;
		
		Color backgroundColor = new Color(168, 200, 236);
		setBackground(backgroundColor);
		
		setLayout(null);
		
		makeTextLabels();
		makeProfileImageLabel();
		makeExitButton();
		
	}
	
	private void makeTextLabels() {
		
		// Game Result 텍스트
		gameResultTextLabel.setFont(new Font("Jokerman", Font.BOLD, 20));
		gameResultTextLabel.setForeground(Color.WHITE);
		gameResultTextLabel.setSize(220, 45);
		gameResultTextLabel.setLocation(90, 35);
		gameResultTextLabel.setOpaque(true);
		gameResultTextLabel.setBackground(new Color(129, 172, 236));
		gameResultTextLabel.setHorizontalAlignment(JLabel.CENTER);
		gameResultTextLabel.setBorder(defaultLineBorder);
		this.add(gameResultTextLabel);
				
		// name 텍스트
		nameTextLabel.setFont(defaultFont);
		nameTextLabel.setForeground(Color.WHITE);
		nameTextLabel.setSize(200, 35);
		nameTextLabel.setLocation(100, 105);
		nameTextLabel.setOpaque(true);
		nameTextLabel.setBackground(new Color(129, 172, 236));
		nameTextLabel.setHorizontalAlignment(JLabel.CENTER); 
		this.add(nameTextLabel);
		
		// difficulty 텍스트
		difficultyLabel.setFont(defaultFont);
		difficultyLabel.setForeground(Color.WHITE);
		difficultyLabel.setSize(200, 35);
		difficultyLabel.setLocation(100, 415);
		difficultyLabel.setOpaque(true);
		difficultyLabel.setBackground(new Color(129, 172, 236));
		difficultyLabel.setHorizontalAlignment(JLabel.CENTER); 
		this.add(difficultyLabel);
				
		// score 텍스트
		String score = Integer.toString(profileAndSocorePanel.getScore());
		scoreLabel = new JLabel("Your Score is " + score);
		scoreLabel.setFont(defaultFont);
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setSize(200, 35);
		scoreLabel.setLocation(100, 475);
		scoreLabel.setOpaque(true);
		scoreLabel.setBackground(new Color(129, 172, 236));
		scoreLabel.setHorizontalAlignment(JLabel.CENTER); 
		this.add(scoreLabel);
		
	}
	
	private void makeProfileImageLabel() {
		
		// 프로필 이미지
		profileImageLabel.setSize(180, 225);
		profileImageLabel.setLocation(110, 165);
		
		profileImageLabel.setBorder(new LineBorder(new Color(129, 172, 236), 3));
		this.add(profileImageLabel);
				
	}
	
	private void makeExitButton() {
		
		// 종료 버튼
		exitButton.setFont(defaultFont);
		exitButton.setSize(100, 70);
		exitButton.setLocation(160, 550); 
		exitButton.addKeyListener(new ExitListener());
		
		// 포커스 강제 설정
		exitButton.setFocusable(true);
		exitButton.requestFocus();
				
		this.add(exitButton);
				
	}
}

class ExitListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyChar() == '\n') { // 엔터를 받으면 
			System.exit(0); // 프로그램 종료
		}
		
	}
}
