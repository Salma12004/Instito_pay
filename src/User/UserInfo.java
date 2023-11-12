package User;

import java.util.Map;

public class UserInfo {
    private Map<String, String> Info;
    public UserInfo(Map<String, String> Info){
        this.Info = Info;
    }
    void setInfo(Map<String, String> Info){
        this.Info = Info;
    }
    Map<String, String> getInfo(){
        return this.Info;
    }
    UserInfo getInfo(String key){
        return new UserInfo(Map.of(key, this.Info.get(key)));
    }

    

   
    
}
