package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;

public class TableViewController implements Initializable{

    @FXML
    private TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, String> idColumn;
    @FXML
    private TableColumn<Customer, String> dateColumn;

    List<Customer> list = new ArrayList();
    List<String> ids = new ArrayList();
    List<String> idsTest = new ArrayList();
    List<String> conditionV = new ArrayList();

    int theSInt = 0;
    int s2 = 0;


    private Main main;

    public void setMain(Main main) {
        // TODO Auto-generated method stub
        this.main = main;
        list = main.customerData;
        for(int i = 0; i < list.size(); i++){
            if("2017".equals(list.get(i).getDate().get())){
                ids.add(list.get(i).getId().get());
//				System.out.println(list.get(i).getDate().get());
//				System.out.println(list.get(i).getId().get());
            }
        }
        for(int i = 0; i < list.size(); i++){

            if(i == 1){
                conditionV.add("2");
            }
            if(ids.contains(list.get(i).getId().get())){
                conditionV.add("1");

            }else{
                conditionV.add("0");
            }
        }
        System.out.println(conditionV.size());
        tableView.setItems(main.customerData);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub


        idColumn.setCellValueFactory(cellData -> cellData.getValue().getId());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDate());

        test();


//		(column -> {
//		    return new TableCell<Customer, String>() {
//		        @Override
//		        protected void updateItem(LocalDate item, boolean empty) {
//		            super.updateItem(item, empty);
//
//		            if (item == null || empty) {
//		                setText(null);
//		                setStyle("");
//		            } else {
//		                // Format date.
//		                setText(myDateFormatter.format(item));
//
//		                // Style all dates in March with a different color.
//		                if (item.getMonth() == Month.MARCH) {
//		                    setTextFill(Color.CHOCOLATE);
//		                    setStyle("-fx-background-color: yellow");
//		                } else {
//		                    setTextFill(Color.BLACK);
//		                    setStyle("");
//		                }
//		            }
//		        }
//		    };
//		});

    }


    public void test(){



        dateColumn.setCellFactory(column -> {
            return new TableCell<Customer, String>(){
                @Override
                protected void updateItem(String item, boolean empty){
                    super.updateItem(item, empty);
                    System.out.println(empty);

                    System.out.println("item = "+item+"         empty = "+empty);
                    TableRow<Customer> currentRow = getTableRow();

                    if(!isEmpty()) {
                        currentRow.setStyle("-fx-background-color:lightgreen");
                        setText(empty ? "" : getItem());
                        if(theSInt < conditionV.size()){
                            //
                            if("2017".equals(item)){

                                currentRow.setStyle("-fx-background-color:lightgreen");
                            }else if("2016".equals(item)){
                                currentRow.setStyle("-fx-background-color: yellow");
                                if("1".equals(conditionV.get(theSInt))){
                                    currentRow.setStyle("-fx-background-color:lightgreen");
                                }
                            }else{
                                currentRow.setStyle("-fx-background-color: red");
                                if("1".equals(conditionV.get(theSInt))){
                                    currentRow.setStyle("-fx-background-color:lightgreen");
                                }
                            }
                            setTextFill(Color.BLACK);



//							System.out.println("item          "+item+"   id = "+idsTest.get(theSInt));
//		            		System.out.println("condition        "+conditionV.get(theSInt));
//							System.out.println("sssss               "+ theSInt);

                            theSInt++;
                        }
                    }
//


                }
            };
        });

//		idColumn.setCellFactory(column -> {
//			return new TableCell<Customer, String>(){
//				@Override
//				protected void updateItem(String item, boolean empty){
//					super.updateItem(item, empty);
//
//					if (item == null || empty) {
//		                setText(null);
//
//
//		            }else{
//		            	if(s2 < conditionV.size()){
//
//			            	if("2017".equals(item) || "1".equals(conditionV.get(s2))){
//			            		setStyle("-fx-background-color: green");
//			            	}else if("2016".equals(item)){
//			            		setStyle("-fx-background-color: yellow");
//			            	}else{
//			            		setStyle("-fx-background-color: red");
//			            	}
//			            	setTextFill(Color.BLACK);
//							setText(item);
//
//
////							System.out.println("item          "+item+"   id = "+idsTest.get(s2));
////		            		System.out.println("condition        "+conditionV.get(s2));
////							System.out.println("sssss               "+ s2);
//
//							s2++;
//		            	}
//		            }
//
//				}
//			};
//		});


    }




}
