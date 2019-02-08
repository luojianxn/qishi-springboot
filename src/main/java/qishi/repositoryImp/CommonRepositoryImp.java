package qishi.repositoryImp;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import qishi.repositoryInterface.BaseRepositoryITF;
import qishi.repositoryInterface.CommonRepositoryITF;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.io.Serializable;
import java.util.Map;


//@Repository(value="commonRepo")
@Scope("singleton")
public class CommonRepositoryImp<T,ID extends Serializable>  extends SimpleJpaRepository<T,ID>  implements CommonRepositoryITF<T,ID> {

   private  final  EntityManager em;

    public CommonRepositoryImp(Class<T> domainClass, EntityManager em) {

        super(domainClass, em);
        System.out.println("CommonRepositoryImp : create");
        this.em=em;
    }

    public List<Object[]>  listBySQL(String sql){
        return em.createNativeQuery(sql).getResultList();
    };

    public List<Map>  listMapBySQL(String sql){
        Query query = em.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map> map = query.getResultList();
        return map;
    }

    public Map  excuteSp(String spName){


        return null;
    }

}
