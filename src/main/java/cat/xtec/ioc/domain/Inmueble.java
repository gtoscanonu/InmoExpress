package cat.xtec.ioc.domain;

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Inmueble")
public class Inmueble implements Serializable {
    
    private static long serialVersionUID = 1L;
    @Id
  //  @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vivienda")
    private Integer idVivienda;
    
    @Column(name = "tipoInmueble")
    @NotNull
    @Size(max = 100)
    private String tipo;
    
    @Column(name = "Ubicacion")
    @NotNull
    @Size(max = 100)
    private String ubicacion;
    
    @Column(name = "superficie")
    @NotNull
    private float superficie;
    
    @Column(name = "precio")
    @NotNull
    private float precio;
    
    @Column(name = "numHabitaciones")
    @NotNull
    private int numHabitaciones;
    
    @Column(name = "numBaños")
    @NotNull
    private int numBaños;
    
    @Column(name = "Extras")
    @Size(max=100)
    private String extras;
    
    @Column(name = "Descripcion")
    @Size(max = 100)
    private String descripcion;
    
    @Column(name = "imagen") //,  nullable=false, columnDefinition="mediumblob"
    private String imagen;

    public Inmueble(){};

    public Inmueble(Integer idVivienda, String tipo, String ubicacion, float superficie, float precio, int numHabitaciones, int numBaños, Boolean amueblado, String extras, String descripcion){
        this.idVivienda=idVivienda;
        this.tipo=tipo;
        this.ubicacion=ubicacion;
        this.precio=precio;
        this.numHabitaciones=numHabitaciones;
        this.numBaños=numBaños;
        this.extras=extras;
        this.descripcion=descripcion;
}

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the idVivienda
     */
    public Integer getIdVivienda() {
        return idVivienda;
    }

    /**
     * @param idVivienda the idVivienda to set
     */
    public void setIdVivienda(Integer idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the superficie
     */
    public float getSuperficie() {
        return superficie;
    }

    /**
     * @param superficie the superficie to set
     */
    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the numHabitaciones
     */
    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    /**
     * @param numHabitaciones the numHabitaciones to set
     */
    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    /**
     * @return the numBaños
     */
    public int getNumBaños() {
        return numBaños;
    }

    /**
     * @param numBaños the numBaños to set
     */
    public void setNumBaños(int numBaños) {
        this.numBaños = numBaños;
    }

    /**
     * @return the extras
     */
    public String getExtras() {
        return extras;
    }

    /**
     * @param extras the extras to set
     */
    public void setExtras(String extras) {
        this.extras = extras;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
