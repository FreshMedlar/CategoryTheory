package dennis_fx;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;

/*
import javafx.scene.layout.VBox;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Camera;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import jdk.dynalink.beans.StaticClass;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
*/

public class Main extends Application {
    static final int height =1020;
    static final int width =720;
    static final int mxl=10;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        int i =0;
        String s="";
        Set<element> o = null;

        primaryStage.setTitle("HeLlO");
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setScene(new Scene(keeptrack.root));
        primaryStage.show();
        Button button=new Button("add Integer category");
        button.setId("9999");
        Button button2=new Button("add String category    ");
        button2.setLayoutX(125);
        button.setId("9999");

        keeptrack.root.getChildren().addAll(button,button2);
        button.setOnAction(actionEvent -> addCategory(i));
        button2.setOnAction(actionEvent -> addCategory(s));
    }
    public static void addCategory(Object t){
        if (keeptrack.category_list.size() < mxl) {
            Random a = new Random();
            int r = 55;
            int x = 240;
            int y = 480;
            int count = 0;
            for (int i = 0; i < keeptrack.category_list.size(); i++) {
                if (count > 10000) {
                    return;
                }
                double D = Math.sqrt(Math.pow(keeptrack.category_list.get(i).x - x, 2) + Math.pow(keeptrack.category_list.get(i).y - y, 2));
                if (D < 2 * r) {
                    x = a.nextInt((width - r) - (r + 65)) + r;
                    y = a.nextInt((height - r) - (r + 70)) + r;
                    i = -1;
                    count++;
                }
            }
                keeptrack.category_list.add(new category_draw(keeptrack.root, x, y,keeptrack.category_list.size(),t));
        }
        else{
            Label l= new Label("maximum category reached ");
            l.setFont(new Font ("Arial",16));
            l.setLayoutX(width/2);
            keeptrack.root.getChildren().add(l);
        }
    }
    public void removeCategory(String ID,int INDEX) {
            boolean flag=false;
        for (int i = 0; i < keeptrack.root.getChildren().size(); i++) {
            if (keeptrack.root.getChildren().get(i) instanceof VBox) {
                keeptrack.root.getChildren().remove(i);
                break;
            }
        }
            for (int i = 0; i < keeptrack.root.getChildren().size(); i++) {
                if (keeptrack.root.getChildren().get(i) instanceof Button) {
                    if (String.valueOf(keeptrack.root.getChildren().get(i).getId()) == ID) {
                        keeptrack.root.getChildren().remove(i);
                        break;
                    }
                }
            }
            for (int i =0; i < keeptrack.category_list.size(); i++) {
                if (flag){
                    keeptrack.category_list.get(i).changeid(Integer.toString(i), i);
                }
                if (i==INDEX && !flag){
                        flag=true;
                        keeptrack.category_list.remove(i);
                        i=-1;
                }
            }
       }
}
class category_draw<E> extends Main{
    ButtonBar category =new ButtonBar();
    Random elem_gen= new Random();
    int radius =55;
    Button button ;
    String id;
    VBox optionslist= new VBox();
    VBox elementslist= new VBox();
    category_m category_math=new category_m<>();
    int x;
    int y;
    int index;
    public category_draw (Pane root,int x, int y,int index,Object t){
        this.x=x;
        this.y=y;
        this.index=index;

        if (t instanceof Integer){
            category_math=new categoryint(new ArrayList<element<Integer>>(),"integer");
        }
        if (t instanceof String){
            category_math=new categoryString(new ArrayList<element<String>>(),"string");
        }

        elementslist.setLayoutY(50);
        button=new Button(" ");
        button.setShape(new Circle(radius));
        button.setMinSize(2*radius, 2*radius);
        button.setMaxSize(2*radius, 2*radius);
        button.setId(Integer.toString(index));
        id=button.getId();
        button.setOnAction(actionEvent -> showoptions(root));
        button.setLayoutX(x);
        button.setLayoutY(y);
        root.getChildren().addAll(button);
        elem_gen.setSeed(Long.parseLong(id) +100);

    }
    public void showoptions(Pane root){
        generateaccordion();
        optionslist.setLayoutX(0);
        optionslist.setLayoutY(50);

        for (int i=0; i<keeptrack.root.getChildren().size();i++){
               if ( keeptrack.root.getChildren().get(i) instanceof VBox){
                   root.getChildren().remove(i);
               }
        }
        keeptrack.root.getChildren().add(optionslist);
    }
    public void generateaccordion(){
        optionslist=new VBox();
        Button b1=new Button("   add element   ");
        Button b2=new Button("remove category");
        Button b3=new Button("compose");
        b2.setOnAction(actionEvent -> removeCategory(this.id,this.index));
        b1.setOnAction(actionEvent -> add_elements());
        b3.setOnAction(actionEvent->compose());
        optionslist.getChildren().addAll(b1,b2,b3);
        Button morphism[]=new Button[category_math.morphism_list.size()];
        for (int i=0;i<category_math.morphism_list.size();i++){
            morphism mo= (dennis_fx.morphism) category_math.morphism_list.get(i);
            morphism[i]=new Button(mo.nome);
            morphism[i].setOnAction(actionEvent ->callfunction(mo));

        }
        for(int i=0;i<morphism.length;i++){
            optionslist.getChildren().add(morphism[i]);
        }
    }
    public void callfunction(morphism m) {
        if (elementslist.getChildren().size()!=0) {
            for (int in = 0; in < keeptrack.root.getChildren().size(); in++) {
                if (keeptrack.root.getChildren().get(in) instanceof VBox) {
                    keeptrack.root.getChildren().remove(in);
                    break;
                }
            }
            for (int in = 0; in < elementslist.getChildren().size(); in++) {
                Button a = (Button) elementslist.getChildren().get(in);
                a.setOnAction(actionEvent -> evoke(a.getId(), m));
            }
            keeptrack.root.getChildren().add(elementslist);
        }
    }
    public void add_elements(){
    int n=3;
        element e=new element();
    if(category_math.id =="string"){
        String s="";
        for (int i=0;i<=elem_gen.nextInt(3)+1;i++) {
            s=s+(char) (elem_gen.nextInt(26) + 'a');
        }
        e=new element<String>(s);
    }
    if (category_math.id=="integer"){
        e=new element<Integer>((elem_gen.nextInt(99)));
    }
    category_math.add(e);
    button.setText(button.getText()+" "+e);
    if(category_math.element_list.size()%n==0){
        button.setText(button.getText()+"\n");
    }
    Button element_b= new Button(""+e);
    element_b.setId(""+e);
    elementslist.getChildren().add(element_b);
    }
    public void add_element(Object e){
        if (e instanceof String){
            category_math.add(new element<String>((String) e));
        }
        if (e instanceof Integer){
            category_math.add(new element<String>((String) e));
        }
        button.setText(button.getText()+" "+e);
        if(category_math.element_list.size()%3==0){
            button.setText(button.getText()+"\n");
        }
        Button element_b= new Button(""+e);
        element_b.setId(""+e);
        elementslist.getChildren().add(element_b);
    }
    public void changeid(String id,int index){
        this.id=id;
        button.setId(id);
        this.index=index;
    }
    public void evoke(String element,morphism a){
        String result;
        if(a.domain=="integer"){
            result = String.valueOf(a.Funzione.apply(Integer.parseInt(element)));
        }
        else{
            if (a.codomain!=a.domain){
                result=String.valueOf( a.Funzione.apply(element));
            }
            else{
                result= (String) a.Funzione.apply(element);
            }
        }
        if(a.codomain== category_math.id) {
            add_element(result);
        }
        else{
            int i=0;
            for(;i<keeptrack.category_list.size();i++){
                if (keeptrack.category_list.get(i).category_math.id==a.codomain){
                    keeptrack.category_list.get(i).add_element(result);
                    break;
                }
            }
           if(i==keeptrack.category_list.size()){
               Main.addCategory(1);
               keeptrack.category_list.get(keeptrack.category_list.size()-1).add_element(result);
           }
        }
        showoptions(keeptrack.root);
    }
    public void compose() {
            for (int in = 0; in < keeptrack.root.getChildren().size(); in++) {
                if (keeptrack.root.getChildren().get(in) instanceof VBox) {
                    keeptrack.root.getChildren().remove(in);
                    break;
                }
            }
            VBox a=new VBox();
            a.setId("composing");
            a.setLayoutY(50);
            CheckBox morphism_checkbox[] = new CheckBox[category_math.morphism_list.size()];
            for (int i = 0; i < category_math.morphism_list.size(); i++) {
                morphism mo = (morphism) category_math.morphism_list.get(i);
                morphism_checkbox[i] = new CheckBox(mo.nome);
                a.getChildren().add(morphism_checkbox[i]);
            }
            Button submit = new Button("submit");
            submit.setId("sumbit");
            submit.setOnAction(actionEvent ->make_compose(morphism_checkbox) );
            a.getChildren().add(submit);
            keeptrack.root.getChildren().add(a);
    }
   public void make_compose(CheckBox[] morphism_checkbox){
        morphism f=morphism.morphism_copy(category_m.identity);
        f.nome="";
        for (int i = 0; i<morphism_checkbox.length; i++){
            if(morphism_checkbox[i].isSelected()){
                f=category_m.compose(f, (morphism) category_math.morphism_list.get(i));
            }
        }
        category_math.morphism_list.add(f);
       showoptions(keeptrack.root);
   }
}
class keeptrack{
    static ArrayList<category_draw> category_list = new ArrayList();
    static Pane root = new Pane();
}