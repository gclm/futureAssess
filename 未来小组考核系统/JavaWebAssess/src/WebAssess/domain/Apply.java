package WebAssess.domain;

public class Apply {
   private String id;
   private String username;
   private String applyidentity;
   
   public Apply(String username,String applyidentity){
	   this.username=username;
	   this.applyidentity=applyidentity;
   } 
   public Apply(){}
   public String getId(){
	   return id;
	   
   }
   public void setId(String id){
	   this.id=id;
   }
   public String getUsername(){
	   return username;
   }
   public void setUsername(String username){
	   this.username=username;
   }
   public String getApplyidentity(){
	   return applyidentity;
   }
   public void setApplyidentity(String applyidentity){
	   this.applyidentity=applyidentity;
   }
}
