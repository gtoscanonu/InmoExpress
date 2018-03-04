/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.repository.impl;

import org.hibernate.Criteria;
import cat.xtec.ioc.domain.Inmueble;
import cat.xtec.ioc.repository.InmuebleRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class InmuebleHibernate implements InmuebleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Inmueble getInmuebleByCody(String codi) {
        return getSession().get(Inmueble.class, codi);
    }

    @Override
    public List<Inmueble> getAllInmuebles() {
        Criteria criteria = createEntityCriteria();
        return (List<Inmueble>) criteria.list();
    }

    @Override
    public List<Inmueble> getInmueblesByTipus(String tipo) {
        return (List<Inmueble>) getSession().get(Inmueble.class, tipo);
    }

    @Override
    public void addInmueble(Inmueble habitatge) {        
        getSession().saveOrUpdate(habitatge);
    }

    @Override
    public void updateInmueble(Inmueble habitatge) {
        getSession().merge(habitatge);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Criteria createEntityCriteria() {
        return getSession().createCriteria(Inmueble.class);
    }

}
