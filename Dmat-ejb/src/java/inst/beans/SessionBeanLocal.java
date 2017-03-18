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
import javax.ejb.Local;

/**
 *
 * @author Muzaffar
 */
@Local
public interface SessionBeanLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    void removeSprTipUch(SprTipUch sprTipUch);

    List<SprTipUch> getSprTipUchFindAll();

    void removeSprGruppa(SprGruppa sprGruppa);

    List<SprGruppa> getSprGruppaFindAll();

    void removeSprFacult(SprFacult sprFacult);

    List<SprFacult> getSprFacultFindAll();

    void removePosesh(Posesh posesh);

    List<Posesh> getPoseshFindAll();

    void removeSemestr(Semestr semestr);

    List<Semestr> getSemestrFindAll();

    void removeSprStudent(SprStudent sprStudent);

    List<SprStudent> getSprStudentFindAll();

    void removeKurs(Kurs kurs);

    List<Kurs> getKursFindAll();

    void removeGrafik(Grafik grafik);

    List<Grafik> getGrafikFindAll();
}
