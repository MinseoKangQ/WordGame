import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingPanel extends JPanel {
	
	// 생성자에게 전달 위한 레퍼런스 선언
	private Audio audio = null;
	private GamePanel gamePanel = null;
		
	private Font defaultFont = new Font("Jokerman", Font.BOLD, 12);
	
	private JButton pausePlayButton = new JButton("Pause Game");
	private JButton playSoundButton = new JButton("Play Sound");
	private JButton pauseSoundButton = new JButton("Pause Sound");
	
	// 생성자
	public SettingPanel(Audio audio, GamePanel gamePanel) { 
		
		this.audio = audio;
		this.gamePanel = gamePanel;
		
		Color backgroundColor = new Color(184, 221, 207);
		setBackground(backgroundColor);
		
		setLayout(null);
		 
		// 버튼들 부착
		makePausePlayButton();
		makePlaySoundButton();
		makePauseSoundButton();
		
	}
	
	public void makePausePlayButton() {
		
		pausePlayButton.setFont(defaultFont);
		pausePlayButton.setSize(100, 50);
		pausePlayButton.setLocation(100, 45);
		pausePlayButton.addActionListener(new GamePausePlayListener());
		this.add(pausePlayButton);
		
	}
	
	public void makePlaySoundButton() {
		
		playSoundButton.setFont(defaultFont);
		playSoundButton.setSize(100, 50);
		playSoundButton.setLocation(25, 150);
		playSoundButton.addActionListener(new AudioListener());
		this.add(playSoundButton);
		
	}
	
	public void makePauseSoundButton() {
		
		pauseSoundButton.setFont(defaultFont);
		pauseSoundButton.setSize(100, 50);
		pauseSoundButton.setLocation(175, 150);
		pauseSoundButton.addActionListener(new AudioListener());
		this.add(pauseSoundButton);
		
	}

	private class GamePausePlayListener implements ActionListener {
			
		@Override
		public void actionPerformed(ActionEvent e) { // 버튼이 클릭되면
			
			JButton button = (JButton)e.getSource();
			
			if(button.getText().equals("Pause Game")) { // 게임 중지시키기
				button.setText("Play Game"); // 텍스트 바꾸기
				audio.stopAudio("gameBackground"); // 오디오 중지
				gamePanel.stopGame(); // 게임스레드, 타이머스레드 중지
				playSoundButton.setEnabled(false); // playSoundButton 비활성화
				pauseSoundButton.setEnabled(false); // pauseSoundButton 비활성화
			}
			else { // 게임 이어서하기
				button.setText("Pause Game"); // 텍스트 바꾸기
				audio.playAudio("gameBackground"); // 오디오 시작 
				gamePanel.resumeGame(); // 게임스레드, 타이머스레드 다시 시작
				playSoundButton.setEnabled(true); // playSoundButton 활성화
				pauseSoundButton.setEnabled(true); // pauseSoundButton 활성화
				}
				
			}
		}
		
		private class AudioListener implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()) {
					case "Play Sound":
						audio.playAudio("gameBackground"); // 오디오 시작 
						break;
					case "Pause Sound":
						audio.stopAudio("gameBackground"); // 오디오 중지
						break;
						
				}
			}
		}
}
