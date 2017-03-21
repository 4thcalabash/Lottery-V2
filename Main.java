package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class Main extends Application {
	private Label tt = new Label();
	private Button bt = new Button ("STOP");
	public boolean stop=false;
//	private final int MAX;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setFullScreen(true);
//		primaryStage.setOnCloseRequest(dispose());
		VBox hb = new VBox (2);
		hb.getChildren().add(tt);
		hb.getChildren().add(bt);
		hb.setAlignment(Pos.CENTER);
		bt.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				stop=!stop;
				if (stop){
					bt.setText("Begin");
				}else{
					bt.setText("Stop");
				}
			}
			
		});
		Scene scene = new Scene (hb,200,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		new Thread(new Repaint()).start();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		primaryStage.show();
	}
	public class Repaint implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				System.out.println(stop);
				
			while (!stop){
				Platform.runLater(()->{
					tt.setText(Integer.toString((int)(Math.random()*80)));
				});
				try{
					Thread.sleep(70);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			}
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
