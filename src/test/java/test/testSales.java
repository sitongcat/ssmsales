package test;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springmvc.service.ISalesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/*.xml"}) //加载配置文件
@Transactional
public class testSales {

    @Autowired
    private ISalesService salesService;

    @Test
     public void testGetSales() throws Exception{

        salesService.getAllSales(new Page(1,5),null);

     }






}
