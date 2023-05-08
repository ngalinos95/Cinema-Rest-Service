package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UUIDReturn {
    //create the UUID class for the return post with Json values token row column price
    //create setters and getters methods for each value
    @JsonIgnore
    private UUID token;
    @JsonProperty("returned_ticket")
    private Seat purchasedSeat;



    public UUIDReturn(UUIDSeat purchasedSeat) {
        this.token=purchasedSeat.getToken();
        this.purchasedSeat=purchasedSeat.getSeat();
    }

    //create getters and setters
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
    public UUID getUUID(){return this.token;}
}
