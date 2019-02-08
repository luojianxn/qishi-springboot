package qishi.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
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
    public List<Map> getData(String sqlId) {
        String sqlText=context.getSqlText(sqlId);
        if(sqlText!=null)
            return setRepo.listMapBySQL(sqlText);

        return null;
    }


    @Override
    public void loginIn() {


    }

    @Override
    public void loginOut() {

    }

    @Override
    public List<Map> test(){

      List<Map> result=setRepo.listMapBySQL("SELECT * FROM tsql");

        return result;

    }

}
