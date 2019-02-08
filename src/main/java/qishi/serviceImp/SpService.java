package qishi.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import qishi.entity.SpParam;
import qishi.serviceInterface.SpServiceITF;
import qishi.sqlset.Setting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ljx on 2019/2/6.
 */
@Service
@Scope("singleton")
public class SpService  implements SpServiceITF {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Setting context;

    public Map excuteSp(Map<String,String> paraMap){
        Map msg=new HashMap();
        try {
            jdbcTemplate.execute("call sp_insert_table()");
        }catch (Exception e){
          msg.put("error",e.getMessage());
        }
        msg.put("success","000");
     return msg;
    }

    public void testSp(final Map<String,String> reqParaMap){
        final String storedProc=createSpString(reqParaMap);
        Map resultMsg=new HashMap();
        //final  int paramSize=getSpParamSize(reqParaMap.get("SP_NAME"));
        final  List<SpParam> listParams=context.getParamsMap(reqParaMap.get("SP_NAME"));
        String relustValue=null;
       try {
           relustValue= (String) jdbcTemplate.execute(
                   new CallableStatementCreator() {
                       public CallableStatement createCallableStatement(Connection con) throws SQLException {
                           CallableStatement cs = con.prepareCall(storedProc);
                           for (int i = 1; i <= listParams.size(); i++) {
                               cs.setString(i, reqParaMap.get(listParams.get(i).getParaName().toUpperCase()));// 设置输入参数的值
                           }
                           cs.registerOutParameter(listParams.size() + 1, Types.VARCHAR);// 注册输出参数的类型
                           return cs;
                       }
                   }, new CallableStatementCallback() {
                       public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                           cs.execute();
                           return cs.getString(listParams.size() + 1);// 获取输出参数的值
                       }
                   });
       }catch (Exception e){
           resultMsg.put("error",e.getMessage());
       }
        resultMsg.put("success",relustValue);
    }



    private String createSpString(Map<String,String> reqParaMap){
        String  requestSp=reqParaMap.get("SP_NAME");
        if(requestSp==null) return null;
        List paraList=context.getParamsMap(requestSp);
        String spCall="{call "+requestSp+"(";
        for(int i=0;i<paraList.size();i++){
            if(i==paraList.size()-1)
                spCall=spCall+"?";
            else
                spCall=spCall+"?,";
        };
        spCall=spCall+")}";
        return spCall;
    }

    private int  getSpParamSize(String spName) {
        List paraList=context.getParamsMap(spName);
        if(paraList!=null)
           return paraList.size();
        return 0;
    }
}
