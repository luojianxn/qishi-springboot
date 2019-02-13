package qishi.sqlset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import qishi.entity.QuerySql;
import qishi.entity.SpParam;
import qishi.repositoryInterface.CommonRepositoryITF;
import qishi.repositoryInterface.QuerySqlRepositoryITF;
import qishi.repositoryInterface.SettingRepositoryITF;
import qishi.repositoryInterface.SpParaRepositoryITF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ljx on 2019/2/4.
 */
@Component
@Scope("singleton")
public class MysqlSetting implements Setting {

    static private HashMap<String,QuerySql> sqlStringCache;

    static private HashMap<String,List<SpParam>> sqlParamCache;

    private boolean isInited;

    @Autowired
    SettingRepositoryITF setRepo;


    public MysqlSetting(){
        isInited=false;
    }

    public boolean isInited(){

        return isInited;
    }

    @Override
    public boolean refresh() {
        sqlStringCache.clear();
        sqlParamCache.clear();
        sqlStringCache=null;
        sqlStringCache=null;
        sqlStringCache=new HashMap<String,QuerySql>();
        sqlParamCache=new HashMap<String,List<SpParam>>();


        return read();
    }

    @Override
    public boolean read() {
      List<Map> querySqls=setRepo.listMapBySQL("select SQLNAME,SQLTEXT,PAGESIZE from tsql where active='Y' order by insertdate limit 0,100");
          if(querySqls.size()==0) return false;
          for(int i=0;i<querySqls.size();i++) {
                HashMap<String,Object> sql=( HashMap<String,Object>)querySqls.get(i);
                QuerySql querySql=new QuerySql();
                querySql.setSqlname(sql.get("SQLNAME").toString());
                querySql.setSqltext(sql.get("SQLTEXT").toString().toUpperCase());
                querySql.setPagesize((Integer) sql.get("PAGESIZE"));
                sqlStringCache.put(sql.get("SQLNAME").toString(),querySql);
            }
        querySqls=null;
        List<Map> sqParams=setRepo.listMapBySQL("select PARASSPNAME,PARANAME,PARALINE from tsppara where active='Y'  order by parasSpName,paraline");
        List<SpParam> listParam=null;
        for(int i=0;i<sqParams.size();i++) {
            HashMap<String, String> sqParam = (HashMap<String, String>) sqParams.get(i);
            SpParam spm = new SpParam();
            spm.setParasspname(sqParam.get("PARASSPNAME").toString());
            spm.setParaName(sqParam.get("PARANAME").toString());
            // spm.setParaLine(sqParam.get("PARALINE").toString());
            if (!sqlParamCache.containsKey(sqParam.get("PARASSPNAME").toString())) {
                listParam = new ArrayList<SpParam>();
                sqlParamCache.put(sqParam.get("PARASSPNAME").toString(), listParam);
            }
            if (listParam != null)
                listParam.add(spm);
        }
        sqParams=null;
        return true;
    }
    @Override
    public List  printCache(){
       List cache=new ArrayList();
        cache.add(sqlStringCache);
        cache.add(sqlParamCache);
       return cache;
    }

    @Override
    public boolean initialize(){
        sqlStringCache=new HashMap<String,QuerySql>();
        sqlParamCache=new HashMap<String,List<SpParam>>();
        if(read()) this.isInited=true;

        return  isInited;
    };

    @Override
    public  QuerySql getQuerySql(String sqlName){
      if(sqlStringCache!=null&&sqlStringCache.containsKey(sqlName))
          return sqlStringCache.get(sqlName);
      return null;
    };

    @Override
    public List<SpParam> getParamsMap(String spName){
        if(sqlStringCache!=null&&sqlStringCache.containsKey(spName))
           return (List<SpParam>)sqlStringCache.get(spName);
     return null;
    };
}
