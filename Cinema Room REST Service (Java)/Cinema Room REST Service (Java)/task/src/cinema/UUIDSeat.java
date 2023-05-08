package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UUIDSeat {
    //create the UUID class with Json values token row column price
    //create setters and getters methods for each value
    @JsonProperty("token")
    private UUID token;
    @JsonProperty("ticket")
    private Seat purchasedSeat;



    public UUIDSeat(Seat purchasedSeat) {
        this.token= UUID.randomUUID();
        this.purchasedSeat=purchasedSeat;
    }

    //create getters and setters
    @JsonIgnore
    public Seat getSeat(){return this.purchasedSeat;}
    @JsonIgnore
    public int getRow(){return this.purchasedSeat.getRow();}
    public void setRow(int row){this.purchasedSeat.setRow(row);}
    @JsonIgnore
    public int getColumn(){return this.purchasedSeat.getColumn();}
    public void setColumn(int column){this.purchasedSeat.setColumn(column);}
    @JsonIgnore
    public int getPrice(){return this.purchasedSeat.getPrice();}
    public void setPrice(int price){
        this.purchasedSeat.setPrice(price);
    }
    @JsonIgnore
    public UUID getToken(){return this.token;}


}
