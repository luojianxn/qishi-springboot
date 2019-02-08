package qishi.controls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qishi.serviceInterface.CommonServiceITF;
import qishi.serviceInterface.SpServiceITF;
import qishi.sqlset.Setting;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class CommonControl {
    @Autowired
    CommonServiceITF comomSer;

    @Autowired
    SpServiceITF spSer;

    @Autowired
    Setting cahe;

    @RequestMapping(value={"/say"}, method={RequestMethod.POST,RequestMethod.GET})
     public List<Map> say(@RequestParam Map<String,String> paraMap){
        if(!cahe.isInited())  cahe.initialize();
        return cahe.printCache();
       }
    @RequestMapping(value={"/getData"}, method={RequestMethod.POST,RequestMethod.GET})
    public List<Map> getData(@RequestParam Map<String,String> paraMap){

        return comomSer.test();
    }

    @RequestMapping(value={"/excuteSp"}, method={RequestMethod.POST,RequestMethod.GET})
    public Map excuteSp(@RequestParam Map<String,String> paraMap){

        return spSer.excuteSp(paraMap);
    }



}
