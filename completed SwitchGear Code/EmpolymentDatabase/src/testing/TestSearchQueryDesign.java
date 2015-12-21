package testing;

import design.*;
import javax.swing.*;
import java.awt.*;

public class TestSearchQueryDesign {

	public static void main(String[] args) {
		JFrame frame = new JFrame("search query");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		SearchQuery query = new SearchQuery();
		frame.add(query);
		
	}

}
