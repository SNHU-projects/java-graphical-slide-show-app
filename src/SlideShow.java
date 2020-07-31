import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPaneTitles;
    private JPanel textPaneCredits; // Add new pane for image credits
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextAreaTitles;
    private JLabel lblTextAreaCredits; // Add new label for image credits

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPaneTitles = new JPanel();
        textPaneTitles.setBorder(BorderFactory.createEmptyBorder(50,10,0,10)); // Add empty border for spacing
		textPaneTitles.setBounds(5, 0, 790, 50);
		textPaneTitles.setVisible(true);
        textPaneCredits = new JPanel(); // Additional JPanel to add image credits
        textPaneCredits.setBounds(5, 470, 790, 50);
        textPaneCredits.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Detox/Wellness Travel Destinations");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPaneTitles.setLayout(cardText);
        textPaneCredits.setLayout(cardText); // Set new panel layout to cardText
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextAreaTitles = new JLabel();
            lblTextAreaCredits = new JLabel(); // Init credits text area
			lblSlide.setText(getResizeIcon(i));
			lblTextAreaTitles.setText(getTextTitlesAndDescription(i));
            lblTextAreaCredits.setText(getImageCredits(i)); // Call method to add image credits
			slidePane.add(lblSlide, "card" + i);
			textPaneTitles.add(lblTextAreaTitles, "cardText" + i);
            textPaneCredits.add(lblTextAreaCredits, "cardText" + i); // Add credits label to credits panel
		}

		// Add it all together
		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPaneTitles, BorderLayout.NORTH); // Set titles panel to display at top of frame
        getContentPane().add(textPaneCredits, BorderLayout.SOUTH); // Set credits panel to display at bottom of frame

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPaneTitles);
        cardText.previous(textPaneCredits); // Show our previous image credits
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPaneTitles);
        cardText.next(textPaneCredits); // Show our next image credits
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/ayurmana-ayurveda-mCb06TSaab0-unsplash.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/mario-dobelmann-2eF15Vi6cTI-unsplash.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/marcus-lewis-f7tZdKY0F28-unsplash.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/jaromir-kavan-i9eaAR4dWi8-unsplash.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/darryl-brian-oAyQLmhT6RA-unsplash.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values for titles and brief description
	 */
	private String getTextTitlesAndDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 The Spa at Chablé Resort, Mexico</font><br>Lush spa, blending holistic and Mayan traditions.</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Lanserhof Tegernsee, Germany</font> <br>Nestled in the Bavarian mountains, guests craft all encompassing health plans with their on-site physician.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 New Life Hiking Spa, Vermont</font> <br>Hikes, yoga, massages, and healthy cooking workshops.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Santani Wellness Resort and Spa, Sri Lanka</font> <br>A wellness resort that offers tri-level spa services using hydrotherapy facilities.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Mii Amo, A Destination Spa, Arizona</font> <br>Get a fresh beginning, a healthy body, or spiritual exploration.</body></html>";
		}
		return text;
	}

    /**
     * Method that provides image credit text values
     * @param i
     * @return Image credits text
     */
    private String getImageCredits(int i) {
        String text = "";
        // Display the correct image credit by matching the value of the int passed to the method
        if (i==1){
            text = "<html>" +
                    "<body>" +
                    "<sub>Courtesy: https://www.travelandleisure.com/trip-ideas/spa-vacations/destination-spas" +
                    "<br> Photo: Ayurmana Ayurveda, https://unsplash.com/@ayurmanaayurveda</sub>" +
                    "</body>" +
                    "</html>";
        } else if (i==2){
            text = "<html>" +
                    "<body>" +
                    "<sub>Courtesy: https://www.travelandleisure.com/trip-ideas/spa-vacations/destination-spas" +
                    "<br> Photo: Mario Dobelman, https://unsplash.com/@mariodobelmann</sub>" +
                    "</body>" +
                    "</html>";
        } else if (i==3){
            text = "<html>" +
                    "<body>" +
                    "<sub>Courtesy: https://www.travelandleisure.com/trip-ideas/spa-vacations/destination-spas" +
                    "<br> Photo: Marcus Lewis, https://unsplash.com/@marcusvlewis</sub>" +
                    "</body>" +
                    "</html>";
        } else if (i==4){
            text = "<html>" +
                    "<body>" +
                    "<sub>Courtesy: https://www.travelandleisure.com/trip-ideas/spa-vacations/destination-spas" +
                    "<br> Photo: Jaromir Kavan, https://unsplash.com/@jerrykavan</sub>" +
                    "</body>" +
                    "</html>";
        } else if (i==5){
            text = "<html>" +
                    "<body>" +
                    "<sub>Courtesy: https://www.travelandleisure.com/trip-ideas/spa-vacations/destination-spas" +
                    "<br> Photo: Darryl Brian, https://unsplash.com/@darrylbrian</sub>" +
                    "</body>" +
                    "</html>";
        }
        return text;
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}