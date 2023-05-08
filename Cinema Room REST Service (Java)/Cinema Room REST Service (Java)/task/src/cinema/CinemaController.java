package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController{
    int ticketNumbers=0;
    int currentIncome=0;


    @GetMapping("/seats")
    public SeatsInfo GetSeatsInfo(){
        int rows=9;
        int columns=9;
        ArrayList<Seat> AvailableSeats=new ArrayList<>();
        for(int y=0;y<rows;y++){
            for(int x=0;x<columns;x++){
                    AvailableSeats.add(new Seat(y+1,x+1));}

        }
        return new SeatsInfo(rows,columns,AvailableSeats);

    }
    //create a List with all the PurchasedSeats
    private ArrayList<UUIDSeat>orderedSeatsList=new ArrayList<>();
    private boolean isPurchased;
    private boolean correctToken;
    @PostMapping("/purchase")
    public ResponseEntity<?> purchase (@RequestBody Seat orderedSeat){
        //check if the RequestBody is in the list of the PurchasedTickets- if yes the set isPurchased true
        for(UUIDSeat x:orderedSeatsList){
            if(x.getColumn()==orderedSeat.getColumn() && x.getRow()==orderedSeat.getRow()){
                isPurchased=true;}
            else{
            isPurchased=false;}
        }
        if(orderedSeat.getRow()<1 || orderedSeat.getColumn()<1 || orderedSeat.getRow()>9 || orderedSeat.getColumn()>9){
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
        else if(isPurchased)
        {
            return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);}
        else{
            UUIDSeat y =new UUIDSeat(new Seat(orderedSeat.getRow(),orderedSeat.getColumn()));
            System.out.println(y.getToken());
        orderedSeatsList.add(y);
        ticketNumbers++;
        currentIncome+=y.getPrice();

        return new ResponseEntity<>(y,HttpStatus.OK);}
    }
    UUIDSeat returnedTicket;
    @PostMapping("/return")
    public ResponseEntity<?> returnTicket (@RequestBody UUIDToken returned){
        //check if the RequestBody has the correct token for the orderedSeatsList
        for(UUIDSeat x: orderedSeatsList){
            if(x.getToken().equals(returned.getToken())){
                correctToken=true;
                returnedTicket=x;
                break;
            }else{correctToken=false;}
        }
        if(correctToken){
            UUIDReturn y=new UUIDReturn(returnedTicket);
            //remove the entry from the orderedSeatsList.
            orderedSeatsList.remove(returnedTicket);
            ticketNumbers--;
            currentIncome-=returnedTicket.getPrice();
            return new ResponseEntity<>(y,HttpStatus.OK);}
        else{
            return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);}

    }

    @PostMapping("/stats")
    public ResponseEntity<?> stats (@RequestParam(required = false) String password){
        if (password!=null && password.equals("super_secret")){
            Statistics y=new Statistics(currentIncome,ticketNumbers);
            return new ResponseEntity<>(y,HttpStatus.OK);
        }else{return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);}
    }





    }


