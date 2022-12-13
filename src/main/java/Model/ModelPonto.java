package Model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dklug
 */
public class ModelPonto {
    private Map<String, Integer> location;
    private String pontoDeReferencia;

    public ModelPonto(String pontoDeReferencia) {
        this.location = new HashMap<String, Integer>();
        this.pontoDeReferencia = pontoDeReferencia;
    }

    public boolean setPontoDeReferencia(String pontoDeReferencia) {
        if(!pontoDeReferencia.isEmpty()) {
            this.pontoDeReferencia = pontoDeReferencia;
            return true;
        } else {
            return false;
        }
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }
    
    /**
     * Seta a latitude e a longitude do ponto de onibus
     * @Integer latitude
     * @Integer longitude
     * @return boolean
     */
    public boolean setLatitudeLongitude(int latitude, int longitude) {
        try{
            this.location.put("lat", latitude);
            this.location.put("lng", longitude);
            return true;
        }catch( Exception e) {
            return false;
        }
    }
    
    /**
     * Retorna o map de latitude e longitude do ponto de onnibus
     * @return Map<String, Integer>; 
     */
    public Map<String, Integer> getLatitudeLongitude(){
        return this.location;
    }
    
    
    public int getLatitude() {
        return this.location.get("lat");
    }
    
    public int getLongitude(){
        return this.location.get("lng");
    }
    
    @Override
    public String toString(){
        String retorno = "";
        if(this.getPontoDeReferencia().isEmpty()) {
          retorno = "Latitude:" + this.getLatitude() + "Longitude: " + this.getLongitude();
        } else {
            retorno = this.getPontoDeReferencia();
        }
        
        return retorno;
    }
    
}
