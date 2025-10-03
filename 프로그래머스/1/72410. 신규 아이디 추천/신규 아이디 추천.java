class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String id = new_id.toLowerCase();
        
        id = id.replaceAll("[^0-9a-z\\-_.]","");
        id = id.replaceAll("\\.+",".");
        id = id.replaceAll("^\\.|\\.$","");
        
        if(id.isEmpty()){
            id = "a";
        }
        
        if(id.length()>=16){
            id = id.substring(0,15);
            id = id.replaceAll("\\.$","");
        }

        while(id.length()<=2){
            id+=id.charAt(id.length()-1);
        }
        
        return id;
    }
}