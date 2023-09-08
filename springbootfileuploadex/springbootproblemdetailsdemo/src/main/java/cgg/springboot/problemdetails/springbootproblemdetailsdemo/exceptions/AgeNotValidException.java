package cgg.springboot.problemdetails.springbootproblemdetailsdemo.exceptions;

public class AgeNotValidException extends RuntimeException {

  public AgeNotValidException(){
    super();
  }
  public AgeNotValidException(String message){
    super(message);
  }
    
}
