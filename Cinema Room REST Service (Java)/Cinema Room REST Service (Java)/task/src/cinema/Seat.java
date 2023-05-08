package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public  class Seat {
    //create the Seat class with Json objects row column price
    //create setters and getters methods for each value
    @JsonIgnore
    private boolean purchased;
    @JsonProperty("row")
    private int row;
    @JsonProperty("column")
    private int column;
    @JsonProperty("price")
    private int price;


    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        if(this.row>4){
            this.price=8;
        }else{this.price=10;}
    }
    //create getters and setters
    public int getRow(){
        return this.row;
    }
    public void setRow(int row){
        this.row=row;
    }
    public int getColumn(){
        return this.column;
    }
    public void setColumn(int column){
        this.column=column;
    }
    public int getPrice(){
        return this.price;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public boolean getPurchased(){
        return this.purchased;
    }
    public void setPurchased(boolean purchased){
        this.purchased=purchased;
    }

}
