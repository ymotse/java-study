package estudos;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExemploJSONcomObjetos{
     
     public static void main(String[] args) {
            
    	 
    	 
            try {
                JSONArray array = new JSONArray();
                
                // CriaÁ„o do Objeto JSONObject:
                ExemploJSONcomObjetosPessoa pOne = new ExemploJSONcomObjetosPessoa();
        
                pOne.setNome("Fernanda");
                pOne.setTelefone("987456321");
                
                JSONObject jsonOne = new JSONObject();

                jsonOne.put("nome", pOne.getNome());
                jsonOne.put("telefone", pOne.getTelefone());
                
                
                //--------------------------------
                ExemploJSONcomObjetosPessoa pTwo = new ExemploJSONcomObjetosPessoa();
                
                pTwo.setNome("Caio");
                pTwo.setTelefone("123456789");
                
                JSONObject jsonTwo = new JSONObject();
                
                jsonTwo.put("nome", pTwo.getNome());
                jsonTwo.put("telefone", pTwo.getTelefone());
                
                
                //-------------------------------
                array.put(jsonOne);
                array.put(jsonTwo);
                
                System.out.println("JSONArray: " + array);
                                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
} 
