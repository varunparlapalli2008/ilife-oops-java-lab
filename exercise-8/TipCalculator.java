import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TipCalculator extends Application {
    public void start(Stage stage) {
        TextField bill = new TextField(); ComboBox<Integer> percent = new ComboBox<>();
        percent.getItems().addAll(10, 15, 18, 20, 25); percent.setValue(15);
        Label tip = new Label("Tip: ₹0.00"), total = new Label("Total: ₹0.00"); Button calculate = new Button("Calculate");
        calculate.setOnAction(e -> { try { double b=Double.parseDouble(bill.getText()); double t=b*percent.getValue()/100.0; tip.setText(String.format("Tip: ₹%.2f",t)); total.setText(String.format("Total: ₹%.2f",b+t)); } catch(NumberFormatException ex) { tip.setText("Enter a valid bill amount"); } });
        GridPane grid=new GridPane(); grid.setPadding(new Insets(20)); grid.setHgap(10); grid.setVgap(10);
        grid.addRow(0,new Label("Bill amount:"),bill); grid.addRow(1,new Label("Tip percent:"),percent); grid.addRow(2,calculate); grid.addRow(3,tip); grid.addRow(4,total);
        stage.setScene(new Scene(grid,360,240)); stage.setTitle("Tip Calculator"); stage.show();
    }
    public static void main(String[] args) { launch(args); }
}
