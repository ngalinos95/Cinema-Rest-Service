package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SeatsInfo{
    /*create Seats Info class with JSON objects fot total_rows
    total _columns and a List with Seats (available_seats)
     */
    @JsonProperty("total_rows")
    private int totalRows;
    @JsonProperty("total_columns")
    private int totalColumns;
    @JsonProperty("available_seats")
    private ArrayList<Seat> AvailableSeats;

    public SeatsInfo(int totalRows,int totalColumns,ArrayList<Seat> AvailableSeats ){
        this.totalRows=totalRows;
        this.totalColumns=totalColumns;
        this.AvailableSeats=AvailableSeats;

    }
}