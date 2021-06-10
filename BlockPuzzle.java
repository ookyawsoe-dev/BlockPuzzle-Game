package BlockPuzzleGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class BlockPuzzle extends JFrame {
	public Clip audioClip = null;
	public static Clip clip = null;

	private JLabel statusbar;

	public BlockPuzzle() {

		initUI();
	}

	private void initUI() {

		statusbar = new JLabel(" 0");
		add(statusbar, BorderLayout.SOUTH);

		var board = new Board(this);
		add(board);
		board.start();

		setTitle("Block Puzzle Game               Developed by Mr.Kyaw Soe");
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(250, 150);
		setResizable(false);
		board.setBackground(Color.DARK_GRAY);
	}

	JLabel getStatusBar() {

		return statusbar;
	}

	public static void main(String[] args) throws IOException {
		
		BlockPuzzle t = new BlockPuzzle();
		t.audio();
		clip.start();
		EventQueue.invokeLater(() -> {

			var game = new BlockPuzzle();
			game.setVisible(true);
		});
	}

	private void audio() throws IOException {
			

			String name = "src/bgsoundforblock.wav";
			try {
				clip = AudioSystem.getClip();
				this.audioClip = clip;
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File((name)));
				File file = new File(name);
				inputStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(inputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);

			} catch (Exception e) {
				//System.out.println("Error: Can't locate sound.");
				e.printStackTrace();
			}
		}
		
	}

