package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {
    @JsonProperty("current_income")
    private int current_income;
    @JsonProperty("number_of_available_seats")
    private int number_of_available_seats;
    @JsonProperty("number_of_purchased_tickets")
    private int number_of_purchased_tickets;
      public Statistics(int current_income,int number_of_purchased_tickets){
          this.current_income=current_income;
          this.number_of_purchased_tickets=number_of_purchased_tickets;
          this.number_of_available_seats=81-number_of_purchased_tickets;
      }


}
