package WebAssess.domain;

public class Info {
   private String id;
   private String information;
   public Info(String information){
	   this.information=information;
   }
   public Info(){}
   public String getId(){
	   return id;
   }
   public void setId(String id){
	   this.id=id;
   }
   public String getInformation(){
	  return information;
   }
   public void setInformation(String information){
	   this.information=information;
   }
}
