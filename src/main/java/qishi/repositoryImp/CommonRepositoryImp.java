package qishi.repositoryImp;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import qishi.repositoryInterface.BaseRepositoryITF;
import qishi.repositoryInterface.CommonRepositoryITF;

import javax.persistence.EntityManager;
import java.util.List;
import java.io.Serializable;

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


}
