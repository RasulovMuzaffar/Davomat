/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inst.beans;

import inst.entities.Grafik;
import inst.entities.Kurs;
import inst.entities.Posesh;
import inst.entities.Semestr;
import inst.entities.SprFacult;
import inst.entities.SprGruppa;
import inst.entities.SprStudent;
import inst.entities.SprTipUch;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Muzaffar
 */
@Stateless(name = "SessionBean", mappedName = "Dmat-ejbPU")
public class SessionBean implements SessionBeanLocal {

    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Dmat-ejbPU")
    private EntityManager em;

    public SessionBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    @Override
    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    @Override
    public void removeSprTipUch(SprTipUch sprTipUch) {
        sprTipUch = em.find(SprTipUch.class, sprTipUch.getId());
        em.remove(sprTipUch);
    }

    /** <code>select o from SprTipUch o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<SprTipUch> getSprTipUchFindAll() {
        return em.createNamedQuery("SprTipUch.findAll", SprTipUch.class).getResultList();
    }

    @Override
    public void removeSprGruppa(SprGruppa sprGruppa) {
        sprGruppa = em.find(SprGruppa.class, sprGruppa.getId());
        em.remove(sprGruppa);
    }

    /** <code>select o from SprGruppa o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<SprGruppa> getSprGruppaFindAll() {
        return em.createNamedQuery("SprGruppa.findAll", SprGruppa.class).getResultList();
    }

    @Override
    public void removeSprFacult(SprFacult sprFacult) {
        sprFacult = em.find(SprFacult.class, sprFacult.getId());
        em.remove(sprFacult);
    }

    /** <code>select o from SprFacult o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<SprFacult> getSprFacultFindAll() {
        return em.createNamedQuery("SprFacult.findAll", SprFacult.class).getResultList();
    }

    @Override
    public void removePosesh(Posesh posesh) {
        posesh = em.find(Posesh.class, posesh.getId());
        em.remove(posesh);
    }

    /** <code>select o from Posesh o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Posesh> getPoseshFindAll() {
        return em.createNamedQuery("Posesh.findAll", Posesh.class).getResultList();
    }

    @Override
    public void removeSemestr(Semestr semestr) {
        semestr = em.find(Semestr.class, semestr.getId());
        em.remove(semestr);
    }

    /** <code>select o from Semestr o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Semestr> getSemestrFindAll() {
        return em.createNamedQuery("Semestr.findAll", Semestr.class).getResultList();
    }

    @Override
    public void removeSprStudent(SprStudent sprStudent) {
        sprStudent = em.find(SprStudent.class, sprStudent.getId());
        em.remove(sprStudent);
    }

    /** <code>select o from SprStudent o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<SprStudent> getSprStudentFindAll() {
        return em.createNamedQuery("SprStudent.findAll", SprStudent.class).getResultList();
    }

    @Override
    public void removeKurs(Kurs kurs) {
        kurs = em.find(Kurs.class, kurs.getId());
        em.remove(kurs);
    }

    /** <code>select o from Kurs o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Kurs> getKursFindAll() {
        return em.createNamedQuery("Kurs.findAll", Kurs.class).getResultList();
    }

    @Override
    public void removeGrafik(Grafik grafik) {
        grafik = em.find(Grafik.class, grafik.getId());
        em.remove(grafik);
    }

    /** <code>select o from Grafik o</code>
     *
     * @return
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<Grafik> getGrafikFindAll() {
        return em.createNamedQuery("Grafik.findAll", Grafik.class).getResultList();
    }
}
