package qishi.factory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import qishi.repositoryImp.CommonRepositoryImp;
public class RepositoryFactoryBean<R extends JpaRepository<T,I>,T,I extends Serializable> extends JpaRepositoryFactoryBean {

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CommonRepositoryFactory<T,I>(entityManager);
    }

    private static class CommonRepositoryFactory<T,I extends Serializable> extends JpaRepositoryFactory{

        private  final  EntityManager em;

        public CommonRepositoryFactory( EntityManager em) {
            super(em);
            this.em = em;
            System.out.println("CommonRepositoryFactory create");

        }

        @Override
        protected  Object getTargetRepository(RepositoryInformation information) {
            System.out.println("getTargetRepository : CommonRepositoryImp");
            return new CommonRepositoryImp<T,I>((Class<T>) information.getDomainType(),em);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            System.out.println("getRepositoryBaseClass : CommonRepositoryImp");
            return CommonRepositoryImp.class;
        }
    }
}
