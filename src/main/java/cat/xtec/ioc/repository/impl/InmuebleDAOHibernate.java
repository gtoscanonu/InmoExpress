package cat.xtec.ioc.repository.impl;

import cat.xtec.ioc.domain.Inmueble;
import cat.xtec.ioc.domain.Vendedor;
import cat.xtec.ioc.repository.InmuebleDAORepository;
import cat.xtec.ioc.repository.VendedorDAORepository;
import java.util.ArrayList;
import java.util.HashSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class InmuebleDAOHibernate implements InmuebleDAORepository {

   @Autowired 
   private VendedorDAORepository vendedorDAORepository;
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Inmueble getInmuebleById(Integer id_vivienda) {
        return getSession().get(Inmueble.class, id_vivienda);
    }

    @Override
    public Set<Inmueble> getAllInmueblesByVendedor(Integer idVendedor) {
       Vendedor vendedor = vendedorDAORepository.getVendedorByIdVendedor(idVendedor);
        return vendedor.getInmuebles();
    }

    @Override
    public List<Inmueble> getInmueblesByTipus(String tipo) {
        return (List<Inmueble>) getSession().get(Inmueble.class, tipo);
    }

    @Override
    public void addInmueble(Inmueble inmueble, Integer idVendedor) {        
        Vendedor vendedor = vendedorDAORepository.getVendedorByIdVendedor(idVendedor);
        Set<Inmueble> inmuebles = vendedor.getInmuebles();
        if (inmuebles != null){
            inmuebles.add(inmueble);
        } else{
            inmuebles = new HashSet<>();
            inmuebles.add(inmueble);
            vendedor.setInmuebles(inmuebles);
        }
    }

    @Override
    public void updateInmueble(Inmueble inmueble) {
        getSession().merge(inmueble);
    }
    
   @Override
    public void deleteInmueble(Inmueble inmueble, Integer idVendedor) {
        Vendedor vendedor = vendedorDAORepository.getVendedorByIdVendedor(idVendedor);
        Set<Inmueble> inmuebles = vendedor.getInmuebles();
            inmuebles.remove(inmueble);
            vendedor.setInmuebles(inmuebles);
            vendedorDAORepository.updateVendedor(vendedor);        
    }
    
    @Override 
    public List<Inmueble> getAllInmuebles(){
        List<Inmueble> allInmuebles = new ArrayList<Inmueble>();
     
          List<Vendedor> vendedores = vendedorDAORepository.getAllVendedor();
          
          for (Vendedor vendedor : vendedores ){
              Set<Inmueble> inmuebles = vendedor.getInmuebles();
              
              for (Inmueble inmueble : inmuebles){
                  allInmuebles.add(inmueble);
              }
         }
        
        return allInmuebles;
    
    }
    
    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
