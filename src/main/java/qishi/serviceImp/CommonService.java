package qishi.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import qishi.entity.QuerySql;
import qishi.repositoryInterface.CommonRepositoryITF;
import qishi.repositoryInterface.QuerySqlRepositoryITF;
import qishi.repositoryInterface.SettingRepositoryITF;
import qishi.serviceInterface.CommonServiceITF;
import qishi.sqlset.Setting;

import java.util.List;
import java.util.Map;

@Service
@Scope("singleton")
public class CommonService implements CommonServiceITF {


    @Autowired
    SettingRepositoryITF setRepo;

    @Autowired
    private Setting context;

    public CommonService(){

    }

    @Override
    public List<Map> getData(String sqlName) {
        QuerySql querySql=context.getQuerySql(sqlName);
        if(querySql!=null)
            return setRepo.listMapBySQL(querySql.getSqltext());

        return null;
    }


    @Override
    public void loginIn() {


    }

    @Override
    public void loginOut() {

    }

    @Override
    public List<Map> test(Map<String,String> paraMap){
        List<Map> result=null;
        QuerySql querySql=null;
        String SQL_TEXT=null;
        int PAGE_SIZE=0;
        String SQL_NAME=paraMap.get("SQL_NAME");
        int PAGE_NUM=Integer.parseInt(paraMap.get("PAGE_NUM"));
        if(SQL_NAME!=null&PAGE_NUM>0) {
            querySql=context.getQuerySql(SQL_NAME);
            SQL_TEXT = querySql.getSqltext();
            PAGE_SIZE=querySql.getPagesize();
            System.out.println("SQL_NAME="+SQL_NAME+"||SQL_TEXT="+SQL_TEXT);
        }
        if(SQL_TEXT!=null) {
            result = setRepo.listMapBySQL(SQL_TEXT+" limit "+((PAGE_NUM-1)*PAGE_SIZE)+","+PAGE_SIZE);
        }
        return result;
    }

}
